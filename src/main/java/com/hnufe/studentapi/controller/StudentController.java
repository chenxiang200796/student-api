package com.hnufe.studentapi.controller;
import com.hnufe.studentapi.entity.Student;
import com.hnufe.studentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public ArrayList<Student> findAll() throws Exception{
        return service.findAll();
    }
    @GetMapping("/students/{id}")
    public Student getOne(@PathVariable String id) throws Exception{
        return service.findById(id);
    }
    @PostMapping("/students")
    public String add(@RequestBody Student s){
        try{
            service.insert(s);
            return "添加成功"+s;
        }catch(IllegalArgumentException e){
            return"参数错误:" + e.getMessage();
        }catch(Exception e){
            return "系统错误:"+e.getMessage();
        }
    }
    @DeleteMapping("/students/{id}")
    public String delete(@PathVariable String id) throws Exception{
        service.deleteById(id);
        return "删除成功"+id;
    }
}
