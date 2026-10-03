package ru.mfa.rbpo2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mfa.rbpo2026.entity.Group;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {

}
