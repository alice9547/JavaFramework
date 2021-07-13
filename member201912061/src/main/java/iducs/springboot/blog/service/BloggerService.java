package iducs.springboot.blog.service;

import iducs.springboot.blog.domain.Blogger;

import java.util.List;

public interface BloggerService {
    Blogger getMember(long id);
    Blogger getMemberByEmail(String email);
    List<Blogger> getMembers();
    int postMember(Blogger blogger);
    int putMember(Blogger blogger);
    int deleteMember(Blogger blogger);
}
