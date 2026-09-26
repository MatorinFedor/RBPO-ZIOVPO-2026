package ru.mfa.rbpo2026.entity;

import lombok.Data;

@Data
public class Student {

    private String name;
    private String email;
    private Group group;
    private Course additionalCourse;

}
