package ru.mfa.rbpo2026.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.mfa.rbpo2026.dto.GroupDto;
import ru.mfa.rbpo2026.entity.Course;
import ru.mfa.rbpo2026.entity.Group;
import ru.mfa.rbpo2026.repository.CourseRepository;
import ru.mfa.rbpo2026.repository.GroupRepository;

import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groups;
    private final CourseRepository courses;
    private final DtoMapper mapper;

    @Transactional(readOnly = true)
    public GroupDto get(UUID id) {
        return mapper.toDto(requireGroup(id));
    }

    @Transactional
    public GroupDto addCourse(UUID groupId, UUID courseId) {
        var group = requireGroup(groupId);
        var course = requireCourse(courseId);
        group.getCourses().add(course);
        course.getGroups().add(group);
        return mapper.toDto(group);
    }

    @Transactional
    public GroupDto removeCourse(UUID groupId, UUID courseId) {
        var group = requireGroup(groupId);
        var course = requireCourse(courseId);
        group.getCourses().remove(course);
        course.getGroups().remove(group);
        return mapper.toDto(group);
    }

    private Group requireGroup(UUID id) {
        return groups.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Группа не найдена"));
    }

    private Course requireCourse(UUID id) {
        return courses.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Курс не найден"));
    }
}
