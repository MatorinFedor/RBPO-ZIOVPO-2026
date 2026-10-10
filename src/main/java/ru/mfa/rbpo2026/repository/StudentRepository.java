package ru.mfa.rbpo2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mfa.rbpo2026.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    @Query("SELECT s FROM Student s WHERE s.name = :name")
    List<Student> findByNameQuery(@Param("name") String name);

    List<Student> findByName(String name);

}
