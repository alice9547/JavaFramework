package iducs.springboot.blog.controller;

import iducs.springboot.blog.service.BloggerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BloggerController.class)
class BloggerControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    BloggerService bloggerService;

    @Test
    public void signinform() throws Exception {
        mvc.perform(get("/bloggers/signin-form")).andExpect(status().isOk());
    }
    /*
    @Test
    public void signin() throws Exception {
        Member bloggers = new Member();
        bloggers.setEmail("induk@induk.ac.kr");
        bloggers.setEmail("cometrue");
        mvc.perform(post("/bloggers/signin")).andExpect(status().isOk());
        //verify(memberService).getMemberByEmail(bloggers.getEmail());
    }
*/
}