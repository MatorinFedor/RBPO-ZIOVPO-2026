package ru.mfa.rbpo2026.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class StudentProfileDto {
    private UUID id;
    private String studentNumber;
}
