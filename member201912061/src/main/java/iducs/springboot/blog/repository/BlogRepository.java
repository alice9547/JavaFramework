package iducs.springboot.blog.repository;

import iducs.springboot.blog.domain.Blog;

import java.util.List;

public interface BlogRepository {
	int create(Blog blog);
	Blog read(Blog blog);			//id로
	List<Blog> readList();

	int update(Blog blog);
	int delete(Blog blog);

}
