package com.adi.spring.data.jpa.repository;

import com.adi.spring.data.jpa.entity.Guardian;
import com.adi.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("alex@gmail.com")
                .name("Alex")
                .mobile("a4667547")
                .build();
        Student student = Student.builder()
                .emailId("adi2@gmail.com")
                .firstName("Adi")
                .lastName("moja")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList =
                studentRepository.findByFirstName("Adi");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList =
                studentRepository.findByFirstNameContaining("Ad");
        System.out.println(studentList);
    }
    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList =
                studentRepository.findByGuardianName("Alex");
        System.out.println(studentList);
    }

    @Test
    public void findByLastNameNotNull(){
        List<Student> studentList =
                studentRepository.findByLastNameNotNull();
        System.out.println(studentList);
    }

    @Test
    public void findByEmailAdress(){
        Student student =
                studentRepository.getStudentByEmailAdress("adi@gmail.com");
        System.out.println(student);
    }

    @Test
    public void findNameByEmail(){
        System.out.println(studentRepository.
                getStudentFirstNameByEmailAdress("adi@gmail.com"));
    }

    @Test
    public void findByEmailAdressNative(){
        Student student = studentRepository.
                getStudentByEmailAdressNative("adi@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("Adi1","adi@gmail.com");
    }

    @Test
    public void deleteStudentNameByEmailId(){
        studentRepository.deleteStudentByEmailId("adi@gmail.com");

    }
    }