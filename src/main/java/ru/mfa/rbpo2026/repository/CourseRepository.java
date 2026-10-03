package ru.mfa.rbpo2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mfa.rbpo2026.entity.Course;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {

}
