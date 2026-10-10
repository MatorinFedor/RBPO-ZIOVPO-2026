package ru.mfa.rbpo2026.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.mfa.rbpo2026.dto.StudentCreateRequest;
import ru.mfa.rbpo2026.dto.StudentDto;
import ru.mfa.rbpo2026.entity.Student;
import ru.mfa.rbpo2026.entity.StudentProfile;
import ru.mfa.rbpo2026.repository.CourseRepository;
import ru.mfa.rbpo2026.repository.GroupRepository;
import ru.mfa.rbpo2026.repository.StudentRepository;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository students;
    private final GroupRepository groups;
    private final CourseRepository courses;
    private final DtoMapper mapper;

    @Transactional(readOnly = true)
    public List<StudentDto> findByName(String name) {
        return students.findByName(name).stream().map(mapper::toDto).toList();
    }

    @Transactional(readOnly = true)
    public StudentDto get(UUID id) {
        return mapper.toDto(requireStudent(id));
    }

    @Transactional
    public StudentDto create(StudentCreateRequest dto) {
        var group = groups.findById(dto.getGroupId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Группа не найдена"));
        var student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail() == null || dto.getEmail().isBlank() ? null : dto.getEmail());
        student.setGroup(group);
        group.getStudents().add(student);

        if (dto.getAdditionalCourseId() != null) {
            student.setAdditionalCourse(courses.findById(dto.getAdditionalCourseId())
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Курс не найден")));
        }

        var profile = new StudentProfile();
        profile.setStudentNumber(dto.getStudentNumber());
        student.setProfile(profile);
        profile.setStudent(student);
        return mapper.toDto(students.save(student));
    }

    @Transactional
    public StudentDto moveToGroup(UUID studentId, UUID groupId) {
        var student = requireStudent(studentId);
        var group = groups.findById(groupId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Группа не найдена"));
        if (!student.getGroup().getId().equals(groupId)) {
            student.getGroup().getStudents().remove(student);
            student.setGroup(group);
            group.getStudents().add(student);
        }
        return mapper.toDto(student);
    }

    @Transactional
    public void delete(UUID id) {
        students.delete(requireStudent(id));
    }

    private Student requireStudent(UUID id) {
        return students.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Студент не найден"));
    }
}
