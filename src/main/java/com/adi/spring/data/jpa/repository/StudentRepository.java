package com.adi.spring.data.jpa.repository;

import com.adi.spring.data.jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
     List<Student> findByFirstName(String firstName);
     List<Student> findByFirstNameContaining(String name);
     List<Student> findByLastNameNotNull();
     List<Student> findByGuardianName(String name);

     //Jpql
     @Query("select s from Student s where s.emailId = ?1")
     Student getStudentByEmailAdress(String emailId);
     @Query("select s.firstName from Student s where s.emailId = ?1")
     String getStudentFirstNameByEmailAdress(String emailId);

     //Native Named Param
     @Query(value = "SELECT * FROM schooldb.tbl_student s where s.email_adress = :emailId",
     nativeQuery = true)
     Student getStudentByEmailAdressNative(@Param("emailId") String emailId);

     @Modifying
     @Transactional
     @Query(value = "update tbl_student set first_name =?1 where email_adress = ?2 ",
     nativeQuery = true)
     int updateStudentNameByEmailId( String firstName, String emailId);

     @Modifying
     @Transactional
     @Query(value = "delete from tbl_student where email_adress = ?1 ",
             nativeQuery = true)
     int deleteStudentByEmailId(String emailId);

}
