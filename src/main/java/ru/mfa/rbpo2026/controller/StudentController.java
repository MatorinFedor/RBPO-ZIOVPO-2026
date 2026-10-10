package ru.mfa.rbpo2026.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<StudentDto>> find(@RequestParam("name") String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> get(@PathVariable UUID id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> create(@RequestBody StudentCreateRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}/group/{groupId}")
    public ResponseEntity<StudentDto> move(@PathVariable UUID id, @PathVariable UUID groupId) {
        return ResponseEntity.ok(service.moveToGroup(id, groupId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
