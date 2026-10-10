package ru.mfa.rbpo2026.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mfa.rbpo2026.dto.GroupDto;
import ru.mfa.rbpo2026.service.GroupService;

import java.util.UUID;


@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService service;

    @GetMapping("/{id}")
    public ResponseEntity<GroupDto> get(@PathVariable UUID id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}/courses/{courseId}")
    public ResponseEntity<GroupDto> add(@PathVariable UUID id, @PathVariable UUID courseId) {
        return ResponseEntity.ok(service.addCourse(id, courseId));
    }

    @DeleteMapping("/{id}/courses/{courseId}")
    public ResponseEntity<GroupDto> remove(@PathVariable UUID id, @PathVariable UUID courseId) {
        return ResponseEntity.ok(service.removeCourse(id, courseId));
    }
}
