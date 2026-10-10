package ru.mfa.rbpo2026.dto;

import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class GroupDto {
    private UUID id;
    private String name;
    private List<UUID> studentIds;
    private List<UUID> courseIds;
}
