package com.hnufe.studentapi;
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
    @GetMapping("/student/{id}")
    public Student getOne(@PathVariable String id) throws Exception{
        return service.findById(id);
    }
    @PostMapping("/student")
    public String add(@RequestBody Student s)throws Exception{
        service.insert(s);
        return "添加成功"+s;
    }
    @DeleteMapping("/student/{id}")
    public String delete(@PathVariable String id) throws Exception{
        service.deleteById(id);
        return "删除成功"+id;
    }
}
