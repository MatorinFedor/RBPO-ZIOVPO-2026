package ru.mfa.rbpo2026.dto;

import ru.mfa.rbpo2026.enums.ApplicationUserRole;

import java.util.UUID;

public record UserDto(UUID id, String email, ApplicationUserRole role) {

}
