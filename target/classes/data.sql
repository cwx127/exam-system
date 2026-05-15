INSERT INTO users (username, password, role) VALUES ('admin', 'admin', 'ADMIN');
INSERT INTO users (username, password, role) VALUES ('student', 'student', 'STUDENT');

INSERT INTO question (content, option_a, option_b, option_c, option_d, answer) VALUES 
('Java中哪个关键字用于继承？', 'extends', 'implements', 'inherits', 'derive', 'A'),
('Java中以下哪个不是基本数据类型？', 'int', 'String', 'boolean', 'double', 'B'),
('Spring Boot的默认端口号是？', '8080', '8081', '8000', '3000', 'A'),
('SQL中用于查询数据的关键字是？', 'SELECT', 'UPDATE', 'INSERT', 'DELETE', 'A'),
('以下哪个是Java的面向对象特性？', '封装', '函数式编程', '指针', '全局变量', 'A'),
('HTTP状态码200表示？', '成功', '未找到', '服务器错误', '重定向', 'A'),
('MySQL中主键约束的关键字是？', 'PRIMARY KEY', 'UNIQUE', 'FOREIGN KEY', 'NOT NULL', 'A'),
('Java中ArrayList和LinkedList的主要区别是？', '底层实现不同', '都一样', '大小不同', '线程安全', 'A'),
('Spring中依赖注入的方式有几种？', '3种', '2种', '1种', '4种', 'A'),
('RESTful API中用于创建资源的HTTP方法是？', 'POST', 'GET', 'PUT', 'DELETE', 'A');
