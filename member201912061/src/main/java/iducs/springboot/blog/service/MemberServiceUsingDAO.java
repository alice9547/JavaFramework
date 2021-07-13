package iducs.springboot.blog.service;

import iducs.springboot.blog.domain.Blogger;
import iducs.springboot.blog.repository.MemberDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MemberServiceUsingDAO {
    private MemberDAOImpl memberDAO;
    @Autowired
    public MemberServiceUsingDAO(MemberDAOImpl memberDAO) { // MemberRepository 유형의 등록된 객체를 Spring Framework이 자동 주입
        this.memberDAO = memberDAO;
    }

    public Blogger getMemberByEmail(String email) throws SQLException {
        Blogger blogger = new Blogger();
        blogger.setEmail(email);
        return memberDAO.readByEmail(blogger);
    }
}
