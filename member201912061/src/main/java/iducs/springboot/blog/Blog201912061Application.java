package iducs.springboot.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
/*
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
*/
public class Blog201912061Application {

    public static void main(String[] args) {

        SpringApplication.run(Blog201912061Application.class, args);
    }

}
