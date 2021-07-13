package iducs.springboot.blog.service;

import com.zaxxer.hikari.HikariDataSource;
import iducs.springboot.blog.domain.Blogger;
import iducs.springboot.blog.repository.BloggerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class BloggerServiceImplTest {
    Logger logger =  LoggerFactory.getLogger(this.getClass());

    HikariDataSource dataSource;
    BloggerService bloggerService;
    BloggerRepository bloggerRepository;

    @BeforeEach // 각 메소드를 실행하기 전에 동작하는 메소드
    public void BeforeEach() {
       // memberRepository = new MemberRepositorylmpl(dataSource);
        bloggerService = new BloggerServiceImpl(bloggerRepository); // 같은 memberRepository를 사용(Dependency Injection)
    }
    @Test
    void getMember() {
    }

    @Test
    void getMemberByEmail() {
        Blogger blogger = bloggerService.getMemberByEmail("induk@induk.ac.kr");
        logger.info(blogger.getPhone());
    }

    @Test
    void getMembers() {
    }

    @Test
    void getMembersByPage() {
    }

    @Test
    void postMember() {
    }

    @Test
    void putMember() {
    }

    @Test
    void deleteMember() {
    }
}