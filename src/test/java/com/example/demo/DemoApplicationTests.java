package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void getStudentCount()
    {
        var studentCount = studentRepository.count();
        assertEquals(6,studentCount);
    }

    @Test
    void getYoungestStudent()
    {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(student -> studentList.add(student));

        int youngestStudent = studentList.stream().min(StudentService::compareAge).get().getAge();

        assertNotEquals(10,youngestStudent);
        assertNotEquals(25,youngestStudent);
        assertEquals(20,youngestStudent);
    }

    @Test
    void getOldestStudent()
    {
        var studentList = new ArrayList<Student>();
        studentRepository.findAll().forEach(x -> studentList.add(x));

        var oldestStudent = studentList.stream().max(StudentService::compareAge).get().getAge();

        assertNotEquals(26,oldestStudent);
        assertNotEquals(18,oldestStudent);
        assertEquals(25,oldestStudent);
    }

    @Test
    void getLongestStudentName()
    {
        var studentList = new ArrayList<Student>();
        studentRepository.findAll().forEach(x -> studentList.add(x));

        var longestName = studentList.stream().max(StudentService::getLongestName).get().getName().length();

        assertNotEquals(3,longestName);
        assertNotEquals(50,longestName);
        assertEquals(17,longestName);
    }
}
