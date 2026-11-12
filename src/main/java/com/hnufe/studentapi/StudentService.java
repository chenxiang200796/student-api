package com.hnufe.studentapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service//表示这个类是一个业务类，也称为业务逻辑层

public class StudentService {
    @Autowired//自动注入Spring容器中的MysqlStudentDao对象
    private MysqlStudentDao dao;
    public ArrayList<Student> findAll() throws Exception{
        return dao.findAll();
    }
    public Student findById(String id) throws Exception{
        return dao.findById(id);
    }
    public void insert(Student s) throws Exception{
        dao.insert(s);
    }
    public void deleteById(String id) throws Exception{
        dao.deleteById(id);
    }
}
