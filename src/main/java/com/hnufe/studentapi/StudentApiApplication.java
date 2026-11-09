package com.hnufe.studentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;


@SpringBootApplication
@RestController//
public class StudentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApiApplication.class, args);
    }

    @GetMapping("/hi")
    public String hi() {
        return "你好，我是陈祥";
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }
    @GetMapping("/students")
    public ArrayList<Student> students() throws Exception{
        return MysqlStudentDao.findAll();
    }
}