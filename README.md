# 学生信息管理系统 - Spring Boot 接口版
在线地址：http://203.195.214.195:8080/students

基于 Spring Boot + MySQL 的 REST API，提供学生信息的查询接口。

## 接口

| 方法 | 路径 | 说明 |
|---|---|---|
| GET | `/students` | 查询全部学生 |
| GET | `/students/{id}` | 按学号查询单个学生 |

## 技术栈

- Java 21
- Spring Boot 3.3.4
- MySQL 8.0
- JDBC（`PreparedStatement` 参数化查询）

## 如何运行

1. 安装 MySQL 8.0，创建数据库 `student_db`，并建表：

   ```sql
   CREATE TABLE student (
     id    VARCHAR(20) PRIMARY KEY COMMENT '学号',
     name  VARCHAR(50) NOT NULL        COMMENT '姓名',
     sex   CHAR(1)                     COMMENT '性别',
     phone VARCHAR(20)                 COMMENT '电话'
   );
   ```

2. 修改 `src/main/resources/application.yml` 里的数据库地址、用户名、密码
3. 用 IntelliJ IDEA 打开项目，运行 `StudentApiApplication`
4. 浏览器访问 `http://localhost:8080/students`

## 返回示例

```json
[
  {"id":"20250401","name":"张三","sex":"男","phone":"13900000000"},
  {"id":"202505210420","name":"陈祥","sex":"男","phone":"13900000000"}
]
```

## 项目结构

```
src/main/java/com/hnufe/studentapi/
├── StudentApiApplication.java   # 启动类 + 接口
├── Student.java                 # 学生实体
└── MysqlStudentDao.java         # 数据库访问

src/main/resources/
└── application.yml              # 端口、数据库配置
```

## 待改进

- [ ] 拆分为 Controller / Service / Dao 三层
- [ ] 补充新增（POST）、删除（DELETE）接口
- [ ] 数据库密码改用环境变量，不写进代码
- [ ] 增加统一异常处理，查不到学生返回 404
- [ ] 部署到云服务器
