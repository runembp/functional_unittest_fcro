package com.example.demo.data;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentData implements CommandLineRunner
{
    private final StudentRepository studentRepository;

    public StudentData(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        Student s1 = new Student("Student Mogens",20);
        Student s2 = new Student("Ella Vuffi",21);
        Student s3 = new Student("Frederik Meizner",22);
        Student s4 = new Student("Christina BartXXX",23);
        Student s5 = new Student("Rune Petersen",24);
        Student s6 = new Student("lenOVO",25);

        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);
        studentRepository.save(s4);
        studentRepository.save(s5);
        studentRepository.save(s6);
    }
}
