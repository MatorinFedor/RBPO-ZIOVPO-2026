package ru.mfa.rbpo2026.dto;

import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class CourseDto {
    private UUID id;
    private String name;
    private String description;
    private List<UUID> groupIds;
}
