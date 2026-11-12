package com.hnufe.studentapi;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service

public class StudentService {
    public ArrayList<Student> findAll() throws Exception{
        return MysqlStudentDao.findAll();
    }
    public Student findById(String id) throws Exception{
        return MysqlStudentDao.findById(id);
    }
    public void insert(Student s) throws Exception{
        MysqlStudentDao.insert(s);
    }
    public void deleteById(String id) throws Exception{
        MysqlStudentDao.deleteById(id);
    }
}
