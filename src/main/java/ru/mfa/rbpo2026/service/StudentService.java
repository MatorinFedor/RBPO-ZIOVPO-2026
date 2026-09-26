package ru.mfa.rbpo2026.service;

import org.springframework.stereotype.Service;
import ru.mfa.rbpo2026.entity.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private final Map<String, Student> students = new HashMap<>();

    public Student getStudent(String name) {
        return students.get(name);
    }

    public void addStudent(Student student) {
        students.put(student.getName(), student);
    }

    public void deleteStudent(String name) {
        students.remove(name);
    }

}
