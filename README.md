# 在线考试系统

基于 Spring Boot + MyBatis 的简易在线考试系统，支持题库管理、试卷发布、在线答题、自动判分。

## 技术栈

| 层级 | 技术 |
|------|------|
| 后端框架 | Spring Boot 2.7.18 |
| ORM | MyBatis + MyBatis-Spring-Boot-Starter |
| 数据库 | H2（内存模式，开发用）/ MySQL 8.0 |
| 前端 | 原生 HTML + CSS + JavaScript |
| 构建工具 | Maven |
| JDK | 17 |

## 功能模块

### 管理员端（`/admin.html`）
- 用户管理：添加/删除用户，设置角色（管理员 / 考生）
- 题库管理：添加/删除题目（单选题，含 A/B/C/D 四个选项）
- 试卷管理：选择题目组成试卷，设定考试时长
- 成绩管理：查看所有考生的成绩记录

### 考生端（`/student.html`）
- 参加考试：在线作答，倒计时自动提交
- 查看成绩：查看本人的历史成绩

### 登录页（`/index.html`）
- 登录验证，按角色跳转至对应页面
- 自助注册（默认考生角色）

## 快速开始

```bash
# 1. 克隆项目
git clone https://github.com/cwx127/exam-system.git
cd exam-system

# 2. 编译运行
mvn spring-boot:run

# 3. 访问
# 登录页面：http://localhost:8080
# H2 控制台：http://localhost:8080/h2-console
```

## 默认账号

| 角色 | 用户名 | 密码 |
|------|--------|------|
| 管理员 | admin | admin |
| 考生 | student | student |

## 项目结构

```
src/main/java/com/example/exam/
├── config/          # CORS 跨域配置
├── controller/      # REST API 控制器
│   ├── UserController.java      # 用户接口
│   ├── QuestionController.java  # 题库接口
│   ├── ExamController.java      # 试卷接口
│   └── ScoreController.java     # 成绩接口
├── entity/          # 实体类
├── mapper/          # MyBatis Mapper 接口
├── service/         # 业务层接口及实现
└── ExamApplication.java

src/main/resources/
├── mapper/          # MyBatis XML 映射文件
├── static/          # 前端页面（index / admin / student）
├── schema.sql       # 数据库表结构
├── data.sql         # 初始测试数据
└── application.yml  # 应用配置
```

## API 概览

| 资源 | 方法 | 路径 | 说明 |
|------|------|------|------|
| 用户 | POST | `/api/user/login` | 登录 |
| 用户 | GET | `/api/user/list` | 用户列表 |
| 用户 | POST | `/api/user/add` | 添加用户 |
| 用户 | DELETE | `/api/user/delete/{id}` | 删除用户 |
| 题目 | GET | `/api/question/list` | 题库列表 |
| 题目 | POST | `/api/question/add` | 添加题目 |
| 题目 | DELETE | `/api/question/delete/{id}` | 删除题目 |
| 试卷 | GET | `/api/exam/list` | 试卷列表 |
| 试卷 | POST | `/api/exam/add` | 创建试卷 |
| 试卷 | DELETE | `/api/exam/delete/{id}` | 删除试卷 |
| 试卷 | GET | `/api/exam/{id}/questions` | 获取试卷题目 |
| 成绩 | POST | `/api/score/submit` | 提交答卷 |
| 成绩 | GET | `/api/score/user/{userId}` | 个人成绩 |
| 成绩 | GET | `/api/score/list` | 全部成绩 |

## 切换 MySQL

application.yml 中修改数据源配置：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/exam_db?useSSL=false&serverTimezone=UTC
    username: root
    password: your_password
    driver-class-name: com.mysql.cj.jdbc.Driver
```

同时将 schema.sql 和 data.sql 中的 `H2` 特有语法调整为标准 MySQL 语法。
