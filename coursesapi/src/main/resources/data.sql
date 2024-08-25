-- Create COURSE table
CREATE TABLE course (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description VARCHAR(255),
    credits INT
);

-- Create COURSE_INSTANCE table
CREATE TABLE course_instance (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_id BIGINT,
    semester VARCHAR(255),
    academic_year VARCHAR(255),
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES course(id)
);

-- Insert some sample data
INSERT INTO course (title, description, credits) VALUES
('Introduction to Programming', 'Learn the basics of programming.', 4),
('Data Structures', 'Introduction to data structures.', 3);

INSERT INTO course_instance (course_id, semester, academic_year) VALUES
(1, 'Fall', '2023-2024'),
(2, 'Spring', '2023-2024');
