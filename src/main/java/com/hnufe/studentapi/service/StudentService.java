package com.hnufe.studentapi.service;
import com.hnufe.studentapi.dao.MysqlStudentDao;
import com.hnufe.studentapi.entiey.Student;
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
        if(s.getId()==null||s.getId().trim().isEmpty()){
            throw new IllegalArgumentException("学号不能为空");
        }
        if(s.getName()==null||s.getName().trim().isEmpty()){
            throw new IllegalArgumentException("姓名不能为空");
        }
        if(dao.findById(s.getId())!=null){
            throw new IllegalArgumentException("学号已存在"+s.getId());
        }
        dao.insert(s);
    }
    public void deleteById(String id) throws Exception{
        dao.deleteById(id);
    }
}
