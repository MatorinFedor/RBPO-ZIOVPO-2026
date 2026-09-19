package ru.mfa.rbpo2026.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mfa.rbpo2026.entity.Student;
import ru.mfa.rbpo2026.service.StudentService;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/students", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<Student> getStudent(
            @RequestParam String name,
            @RequestHeader(value = "X-Request-id", required = false) String requestId
    ) {
        System.out.println(requestId);

        var student = studentService.getStudent(name);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var headers = new HttpHeaders();
        headers.add("X-Request-id", UUID.randomUUID().toString());

        return ResponseEntity.ok()
                .headers(headers)
                .body(student);
    }

    @PostMapping
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(CREATED).build();
    }

    @DeleteMapping("/by-name/{name}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String name) {
        studentService.deleteStudent(name);
        return ResponseEntity.noContent().build();
    }

}
