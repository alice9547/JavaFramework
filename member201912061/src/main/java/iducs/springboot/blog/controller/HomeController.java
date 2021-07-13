package iducs.springboot.blog.controller;

import iducs.springboot.blog.domain.Blogger;
import iducs.springboot.blog.service.MemberServiceUsingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@Controller // Spring Web MVC 컨트롤러
// @EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
// @RestController //Restuful 웹 서비스 컨트롤러
public class HomeController {
    MemberServiceUsingDAO memberService;
    @Autowired // Spring Framework 가 주입함.
    public HomeController(MemberServiceUsingDAO memberService) {
        this.memberService = memberService; // 오른쪽 memberService 객체는 등록된 객체를 주입
    }

    @GetMapping("")  // url : http://<server_ip>:<port>/
    public String gohome(HttpServletRequest request, HttpServletResponse response){
        return "main/index"; //index.html 파일을 view or 텝플릿으로 사용함
    }

    @GetMapping("/test/{email}")  //url주소
    public String goTest(@PathVariable("email") String email, Model model) throws SQLException {
        Blogger blogger = memberService.getMemberByEmail(email);
        model.addAttribute("message", blogger.getEmail()+ ":" + blogger.getName());
        return "errors/message";
    }

    @GetMapping("/thtext")  //url주소
    public String gothText(){
        return "th-text"; // th-text.html 파일을 view or 텝플릿으로 사용함
    }

    @RequestMapping("/apis")
    public String api() {
        return "api.html";
    }
}
