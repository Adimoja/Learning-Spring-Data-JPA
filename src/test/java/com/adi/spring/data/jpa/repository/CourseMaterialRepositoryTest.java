package com.adi.spring.data.jpa.repository;

import com.adi.spring.data.jpa.entity.Course;
import com.adi.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void  saveCourseMaterial(){
        Course course = Course.builder()
                .title(".net")
                .credit(5)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("abcd")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterials =
                courseMaterialRepository.findAll();
        System.out.println(courseMaterials);   //Avem in CourseMaterial fetch = FechType.Lazy si ne va afisa doar
                                                // materialele cursului,nu si cursul in sine,daca vrem sa
                                                    //  afiseze si cursul fetch =FetchType.Eager

    }

}