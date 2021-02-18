package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    public static int getLongestName(Student s1, Student s2) {
        Integer nameLength = s1.getName().length();
        return nameLength.compareTo(s2.getName().length());
    }

    public static int compareAge(Student s1, Student s2)
    {
        Integer student1Age = s1.getAge();
        return student1Age.compareTo(s2.getAge());
    }

    public static int getOldestStudent(Student s1, Student s2)
    {
        Integer student1Age = s1.getAge();
        return student1Age.compareTo(s2.getAge());
    }
}
