package iducs.springboot.blog.repository;

import iducs.springboot.blog.domain.Blogger;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository("bloggerRepositoryImplMyBatis")
public class BloggerRepositoryImplMyBatis implements BloggerRepository {

    private SqlSession sqlSession;
    @Autowired
    public BloggerRepositoryImplMyBatis(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    private static String namespace = "iducs.springboot.blog.mapper.BloggerMapper";

   @Override
    public int create(Blogger blogger) {
        return sqlSession.insert(namespace + ".create", blogger);
    }

    @Override
    public Blogger readById(Blogger blogger) {
        return sqlSession.selectOne(namespace + ".readById", blogger.getId());
    }

    @Override
    public Blogger readByEmail(Blogger blogger) {
        return sqlSession.selectOne(namespace + ".readByEmail", blogger.getEmail());
    }

    @Override
    public List<Blogger> readMembers() {
        System.out.println("MyBatis : " + sqlSession);
        return sqlSession.selectList(namespace + ".readMembers");
    }

    @Override
    public int update(Blogger blogger) {
        return sqlSession.update(namespace + ".update", blogger);
    }

    @Override
    public int delete(Blogger blogger) {
        return sqlSession.delete(namespace + ".delete", blogger.getId());
    }
}
