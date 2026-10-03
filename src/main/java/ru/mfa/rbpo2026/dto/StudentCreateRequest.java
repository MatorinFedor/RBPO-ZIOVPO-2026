package ru.mfa.rbpo2026.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class StudentCreateRequest {

    private String name;
    private String email;
    private UUID groupId;
    private UUID additionalCourseId;
    private String studentNumber;

}
