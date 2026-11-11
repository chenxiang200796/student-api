package com.hnufe.studentapi;

import java.sql.*;

public class QueryTest {
    private static final String URL = "jdbc:mysql://localhost:3306/student_db?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8&allowPublicKeyRetrieval=true";
    public static void main(String[] args) throws Exception {
        String url ="jdbc:mysql://localhost:3306/student_db?" +
                "useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8&allowPublicKeyRetrieval=true";
        Connection conn = DriverManager.getConnection(url, "root", "123456");
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("SELECT id,name,sex,phone FROM student");
        while(rs.next()){
            System.out.println(rs.getString("name")+"\t"+rs.getString("phone"));
        }
        System.out.println(findById("202505210420"));
        rs.close();
        st.close();
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
