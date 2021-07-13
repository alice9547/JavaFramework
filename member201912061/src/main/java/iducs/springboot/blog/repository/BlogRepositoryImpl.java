package iducs.springboot.blog.repository;

import iducs.springboot.blog.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;


@Repository("blogRepositoryImpl")
public class BlogRepositoryImpl implements BlogRepository {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public BlogRepositoryImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource); // Spring Bean dataSource 객체를 주입해야함.
	}
	@Override
	public int create(Blog blog) {
		String sql = "insert into blog values(seq_blog.nextval,?,?,?,?,?)";
		Object[] params = new Object[]{blog.getTitle(),blog.getContent(), blog.getFilepath(), blog.getBlogger(), blog.getRegDateTime()};
		return jdbcTemplate.update(sql, params);
	}

	@Override
	public Blog read(Blog blog) {
		String query = "select * from blog where id=?";
		Object[] id = new Object[] {blog.getId()};
		try {
			return jdbcTemplate.queryForObject(query,
					new BeanPropertyRowMapper<Blog>(Blog.class),id);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Blog> readList() {
		String sql = "select * from blog order by id desc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Blog.class));
	}


	@Override
	public int update(Blog blog) {
		String sql = "update blog set title=?, content=?, filepath=?, blogger=? where id=?";
		return jdbcTemplate.update(sql, blog.getTitle(), blog.getContent(), blog.getFilepath(), blog.getBlogger(), blog.getId());
	}

	@Override
	public int delete(Blog blog) {
		return jdbcTemplate.update(
				"delete from blog where id = ?",
				blog.getId());
	}
}
