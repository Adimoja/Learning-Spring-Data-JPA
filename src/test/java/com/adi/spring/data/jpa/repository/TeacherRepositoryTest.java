package com.adi.spring.data.jpa.repository;

import com.adi.spring.data.jpa.entity.Course;
import com.adi.spring.data.jpa.entity.Teacher;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course = Course.builder()
                .title("Mate")
                .credit(6)
                .build();

        Course course2 = Course.builder()
                .title("Programare")
                .credit(6)
                .build();

        Course course3 = Course.builder()
                .title("Analiza")
                .credit(6)
                .build();

        Teacher teacher =Teacher.builder()
                .firstName("Sorina")
                .lastName("Tataru")
                //.courses(List.of(course,course2,course3))
                .build();
        teacherRepository.save(teacher);
    }

}