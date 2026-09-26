package ru.mfa.rbpo2026.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mfa.rbpo2026.entity.Student;
import ru.mfa.rbpo2026.service.StudentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    // /students?name=student1
    @GetMapping
    public ResponseEntity<Student> getStudent(
            @RequestParam String name,
            @RequestHeader(value = "X-Request-ID") String requestId
    ) {
        var student = studentService.getStudent(name);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Request-ID", requestId);

        return ResponseEntity.ok()
                .headers(headers)
                .body(student);
    }

    @PostMapping
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // /students/by-name/student1
    @DeleteMapping("by-name/{name}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String name) {
        studentService.deleteStudent(name);
        return ResponseEntity.noContent().build();
    }

}
