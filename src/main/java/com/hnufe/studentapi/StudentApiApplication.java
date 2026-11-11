package com.hnufe.studentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;




@SpringBootApplication//有了这一行main里面的SpringApplication.run才知道要干什么，且决定扫描范围
@RestController
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
    @GetMapping("/students/{id}")
    public Student getOne(@PathVariable String id) throws Exception{
        return MysqlStudentDao.findById(id);
    }
    @PostMapping("/students")
    public String add(@RequestBody Student s) throws Exception{
        MysqlStudentDao.insert(s);
        return "添加成功"+s;
    }
    @DeleteMapping("/students/{id}")
    public String delete(@PathVariable String id) throws Exception{
        MysqlStudentDao.deleteById(id);
        return "删除成功"+id;
    }

}