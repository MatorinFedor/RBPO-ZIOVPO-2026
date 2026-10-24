package ru.mfa.rbpo2026.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mfa.rbpo2026.dto.UserCreateRequest;
import ru.mfa.rbpo2026.dto.UserDto;
import ru.mfa.rbpo2026.service.ApplicationUserService;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final ApplicationUserService userService;

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserCreateRequest request) {
        try {
            var user = userService.create(request);
            var response = new UserDto(user.getId(), user.getEmail(), user.getRole());
            return ResponseEntity.status(CREATED).body(response);
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.status(CONFLICT).build();
        }
    }

}
