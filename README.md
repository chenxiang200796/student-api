# 学生信息管理系统 - Spring Boot 接口版

> 🌐 **在线演示**：<http://203.195.214.195:8080/students>
>
> 📦 **源码**：<https://github.com/chenxiang200796/student-api>

基于 Spring Boot + MySQL 的 REST API，实现学生信息的增删查。

## 接口

| 方法 | 路径 | 说明 |
|---|---|---|
| `GET` | `/students` | 查询全部学生 |
| `GET` | `/students/{id}` | 按学号查询单个学生 |
| `POST` | `/students` | 新增学生 |
| `DELETE` | `/students/{id}` | 按学号删除学生 |

### 新增请求示例

`POST /students`，`Content-Type: application/json`

```json
{"id":"20250402","name":"李四","sex":"女","phone":"13800000002"}
```

## 技术栈

- Java 21 / Spring Boot 3.3.4
- MySQL 8.0 + JDBC（`PreparedStatement` 参数化查询，防 SQL 注入）
- 三层架构：Controller / Service / Dao，`@Autowired` 依赖注入
- Maven 打包为可执行 jar，部署在云服务器

## 项目结构

```
src/main/java/com/hnufe/studentapi/
├── StudentApiApplication.java      # 启动类
├── controller/
│   └── StudentController.java      # 接口层：接收请求、返回响应
├── service/
│   └── StudentService.java         # 业务层：参数校验、学号查重
├── dao/
│   └── MysqlStudentDao.java        # 数据层：JDBC 操作数据库
└── entity/
    └── Student.java                # 实体：对应 student 表

src/main/resources/
└── application.yml                 # 端口、数据库配置
```

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

## 部署

- 云服务器：Ubuntu 22.04 LTS，2 核 2G
- 环境：JDK 21 + MySQL 8.0
- 流程：`mvn package` 打包 → `scp` 上传 → `nohup java -jar` 后台运行
- 云防火墙放行 8080 端口（3306 不对公网开放）

## 待改进

- [ ] 数据库密码改用环境变量，不写进代码
- [ ] 参数错误时返回 400、查不到返回 404（目前统一返回 200 + 文本提示）
- [ ] 增加接口鉴权（JWT），避免任何人都能调用写接口
- [ ] 引入 MyBatis 替代手写 JDBC，减少重复代码
- [ ] 增加接口文档（Knife4j / Swagger）
- [ ] 配置 systemd，实现服务器重启后自动拉起
