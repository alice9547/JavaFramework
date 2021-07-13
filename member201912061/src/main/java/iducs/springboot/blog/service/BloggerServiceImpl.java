package iducs.springboot.blog.service;

import iducs.springboot.blog.domain.Blogger;
import iducs.springboot.blog.repository.BloggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloggerServiceImpl implements BloggerService {
    private BloggerRepository bloggerRepository;
    @Autowired // MemberRepository 유형의 등록된 객체를 Spring Framework 가 자동 주입
    public BloggerServiceImpl(BloggerRepository bloggerRepository) {
        this.bloggerRepository = bloggerRepository;
    }

    @Override
    public Blogger getMember(long id) {
        Blogger blogger = new Blogger();
        blogger.setId(id);
        return bloggerRepository.readById(blogger);
    }
    @Override
    public Blogger getMemberByEmail(String email) {
        Blogger blogger = new Blogger();
        blogger.setEmail(email);
        return bloggerRepository.readByEmail(blogger);
    }
    @Override
    public List<Blogger> getMembers() {
        return bloggerRepository.readMembers();
    }

    @Override
    public int postMember(Blogger blogger) {
        return bloggerRepository.create(blogger);
    }
    @Override
    public int putMember(Blogger blogger) {
        return bloggerRepository.update(blogger);
    }
    @Override
    public int deleteMember(Blogger blogger) {
        return bloggerRepository.delete(blogger);
    }
}
