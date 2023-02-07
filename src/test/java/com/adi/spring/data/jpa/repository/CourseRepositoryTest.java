package com.adi.spring.data.jpa.repository;

import com.adi.spring.data.jpa.entity.Course;
import com.adi.spring.data.jpa.entity.Student;
import com.adi.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses =
                courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher =Teacher.builder()
                .firstName("Marian")
                .lastName("Alexandru")
                .build();
        Course course =Course.builder()
                .title("Python")
                .credit(7)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public  void findAllPagination(){
        Pageable findPageWithThreeRecords =
                 PageRequest.of(0,3);
        Pageable secondPageWithTwoRwcords =PageRequest.of(1,2);

        List<Course> courses = courseRepository
                .findAll( findPageWithThreeRecords)
                .getContent();
        Long totalElements = courseRepository
                .findAll( findPageWithThreeRecords)
                .getTotalElements();
        int totalPages =courseRepository
                .findAll(findPageWithThreeRecords)
                .getTotalPages();
        System.out.println("Courses"+courses);
        System.out.println("Total elements"+totalElements);
        System.out.println("Total pages"+totalPages);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(0,2, Sort.by("title"));

        Pageable sortByCreditDesc =
                PageRequest.of(0,2,Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0,2,Sort.by("title","credit").descending());

        List<Course> courses =courseRepository.findAll(sortByTitleAndCreditDesc).getContent();
        System.out.println(courses);
    }
    @Test
    public  void findByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);
        List<Course> courses =
                courseRepository.findByTitleContaining("R", firstPageTenRecords).getContent();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher =Teacher
                .builder()
                .firstName("Miron")
                .lastName("Mihai")
                .build();
        Student student =Student
                .builder()
                .firstName("Paul")
                .lastName("Rece")
                .emailId("paul@gmail.com")
                .build();
        Course course =Course
                .builder()
                .title("Ai")
                .credit(5)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}