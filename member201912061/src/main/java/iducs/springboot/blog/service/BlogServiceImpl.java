package iducs.springboot.blog.service;

import java.util.List;

import iducs.springboot.blog.domain.Blog;
import iducs.springboot.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service			//spring bin 객체
public class BlogServiceImpl implements BlogService {
	private BlogRepository blogRepository;
	@Autowired
	public BlogServiceImpl(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}

	@Override
	public int postBlog(Blog blog) {
		return blogRepository.create(blog);
	}

	@Override
	public Blog getBlog(Long id) {
		Blog blog = new Blog();
		blog.setId(id);
		return blogRepository.read(blog);
	}

	@Override
	public List<Blog> getBlogs() {
		return blogRepository.readList();
	}

	@Override
	public List<Blog> getBlogsByTitle(String title) {		//추가기능_타이틀로 찾기
		return null;
	}

	@Override
	public List<Blog> getBlogsByBlogger(String blogger) {		//추가기능_올린사람으로 찾기
		return null;
	}

	@Override
	public List<Blog> getBlogsByPage(int index, int size) {		//추가기능_페이지로 나누기
		return null;
	}

	@Override
	public int updateBlog(Blog blog) {
		return blogRepository.update(blog);
	}

	@Override
	public int deleteBlog(Long id) {
		Blog blog = new Blog();
		blog.setId(id);
		return blogRepository.delete(blog);		//id로 반환
	}

	@Override
	public int getTotalRowCount() {
		return 0;
	}
}