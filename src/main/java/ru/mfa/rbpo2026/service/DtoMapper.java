package ru.mfa.rbpo2026.service;

import org.springframework.stereotype.Component;
import ru.mfa.rbpo2026.dto.CourseDto;
import ru.mfa.rbpo2026.dto.GroupDto;
import ru.mfa.rbpo2026.dto.StudentDto;
import ru.mfa.rbpo2026.dto.StudentProfileDto;
import ru.mfa.rbpo2026.entity.Course;
import ru.mfa.rbpo2026.entity.Group;
import ru.mfa.rbpo2026.entity.Student;
import ru.mfa.rbpo2026.entity.StudentProfile;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DtoMapper {

    public StudentDto toDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setGroupId(student.getGroup().getId());

        if (student.getAdditionalCourse() != null) {
            dto.setAdditionalCourseId(student.getAdditionalCourse().getId());
        }
        if (student.getProfile() != null) {
            dto.setProfile(toDto(student.getProfile()));
        }
        return dto;
    }

    public GroupDto toDto(Group group) {
        GroupDto dto = new GroupDto();
        dto.setId(group.getId());
        dto.setName(group.getName());

        List<UUID> studentIds = new ArrayList<>();
        for (Student student : group.getStudents()) {
            studentIds.add(student.getId());
        }
        dto.setStudentIds(studentIds);

        List<UUID> courseIds = new ArrayList<>();
        for (Course course : group.getCourses()) {
            courseIds.add(course.getId());
        }
        dto.setCourseIds(courseIds);
        return dto;
    }

    public CourseDto toDto(Course course) {
        CourseDto dto = new CourseDto();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());

        List<UUID> groupIds = new ArrayList<>();
        for (Group group : course.getGroups()) {
            groupIds.add(group.getId());
        }
        dto.setGroupIds(groupIds);
        return dto;
    }

    public StudentProfileDto toDto(StudentProfile profile) {
        StudentProfileDto dto = new StudentProfileDto();
        dto.setId(profile.getId());
        dto.setStudentNumber(profile.getStudentNumber());
        return dto;
    }

}
