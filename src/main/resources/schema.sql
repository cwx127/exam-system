CREATE TABLE IF NOT EXISTS users (
    user_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    role VARCHAR(20) NOT NULL,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS question (
    question_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(500) NOT NULL,
    option_a VARCHAR(200) NOT NULL,
    option_b VARCHAR(200) NOT NULL,
    option_c VARCHAR(200) NOT NULL,
    option_d VARCHAR(200) NOT NULL,
    answer VARCHAR(10) NOT NULL,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS exam (
    exam_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    exam_name VARCHAR(100) NOT NULL,
    duration INTEGER NOT NULL,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS exam_question (
    exam_id INTEGER NOT NULL,
    question_id INTEGER NOT NULL,
    PRIMARY KEY (exam_id, question_id)
);

CREATE TABLE IF NOT EXISTS score (
    score_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    user_id INTEGER NOT NULL,
    exam_id INTEGER NOT NULL,
    score INTEGER NOT NULL,
    submit_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS score_log (
    log_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    score_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    exam_id INTEGER NOT NULL,
    score INTEGER NOT NULL,
    operation VARCHAR(50) NOT NULL,
    operation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX IF NOT EXISTS idx_users_username ON users(username);
CREATE INDEX IF NOT EXISTS idx_question_content ON question(content);
CREATE INDEX IF NOT EXISTS idx_score_user_id ON score(user_id);
CREATE INDEX IF NOT EXISTS idx_score_exam_id ON score(exam_id);
CREATE INDEX IF NOT EXISTS idx_exam_question_exam_id ON exam_question(exam_id);

CREATE VIEW IF NOT EXISTS v_exam_scores AS
SELECT 
    s.score_id,
    u.username,
    e.exam_name,
    s.score,
    s.submit_time
FROM score s
JOIN users u ON s.user_id = u.user_id
JOIN exam e ON s.exam_id = e.exam_id
ORDER BY s.submit_time DESC;

CREATE VIEW IF NOT EXISTS v_exam_details AS
SELECT 
    eq.exam_id,
    e.exam_name,
    e.duration,
    eq.question_id,
    q.content
FROM exam_question eq
JOIN exam e ON eq.exam_id = e.exam_id
JOIN question q ON eq.question_id = q.question_id;
