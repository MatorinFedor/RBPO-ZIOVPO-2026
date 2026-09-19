package ru.mfa.rbpo2026.entity;


import lombok.Data;

import java.util.List;

@Data
public class Group {

    private String name;
    private List<Student> students;
    private List<Course> courses;

}
