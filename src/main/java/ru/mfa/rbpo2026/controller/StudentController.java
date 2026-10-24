package ru.mfa.rbpo2026.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.mfa.rbpo2026.dto.StudentCreateRequest;
import ru.mfa.rbpo2026.dto.StudentDto;
import ru.mfa.rbpo2026.service.StudentService;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping
    @PreAuthorize("hasAuthority('read')")
    public ResponseEntity<List<StudentDto>> find(@RequestParam("name") String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('read')")
    public ResponseEntity<StudentDto> get(@PathVariable UUID id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('modify')")
    public ResponseEntity<StudentDto> create(@RequestBody StudentCreateRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}/group/{groupId}")
    @PreAuthorize("hasAuthority('modify')")
    public ResponseEntity<StudentDto> move(@PathVariable UUID id, @PathVariable UUID groupId) {
        return ResponseEntity.ok(service.moveToGroup(id, groupId));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('modify')")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
