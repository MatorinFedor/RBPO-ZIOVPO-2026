package ru.mfa.rbpo2026.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mfa.rbpo2026.dto.CourseDto;
import ru.mfa.rbpo2026.service.CourseService;

import java.util.UUID;


@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService service;

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> get(@PathVariable UUID id) {
        return ResponseEntity.ok(service.get(id));
    }
}
