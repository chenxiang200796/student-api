package com.hnufe.studentapi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;



public class MysqlStudentDao {
    private static final String URL="jdbc:mysql://localhost:3306/student_db?"+
            "useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8";
    public static ArrayList<Student>findAll()throws Exception{
        ArrayList<Student>list=new ArrayList<>();
        //连接数据库
        Connection conn= DriverManager.getConnection(URL,"root","123456");

        //创建Statement对象，用于执行SQL语句
        Statement st=conn.createStatement();
        //执行SQL语句，返回结果集
        ResultSet rs=st.executeQuery("SELECT id,name,sex,phone FROM student");
        while(rs.next()){
            Student s=new Student(rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("sex"),
                    rs.getString("phone")
            );
            list.add(s);
        }
        rs.close();
        st.close();
        conn.close();
        return list;
    }
    public static void insert(Student s) throws Exception{
        Connection conn=DriverManager.getConnection(URL,"root","123456");
        String sql="INSERT INTO student (id,name,sex,phone) VALUES (?,?,?,?);";//SQL语句存储了一段文字，用于向数据库中插入数据
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,s.getId());
        ps.setString(2,s.getName());
        ps.setString(3,s.getSex());
        ps.setString(4,s.getPhone());//这里的123分别代表第1个、第2个、第3个问号
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
    public static void deleteById(String id) throws Exception{
        Connection conn=DriverManager.getConnection(URL,"root","123456");
        String sql="DELETE FROM student WHERE id=?";//SQL语句存储了一段文字，用于向数据库中删除数据
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,id);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
    public static Student findById(String id) throws Exception{
        Connection conn=DriverManager.getConnection(URL,"root","123456");
        String sql="SELECT id,name,sex,phone FROM student WHERE id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,id);
        ResultSet rs=ps.executeQuery();//结果集返回到rs里
        if(rs.next()){
            Student stu=new Student(rs.getString("id"),rs.getString("name"),rs.getString("sex"),rs.getString("phone"));
            rs.close();
            ps.close();
            conn.close();
            return stu;
        }
        rs.close();
        ps.close();
        conn.close();
        return null;
    }


}

