package ru.mfa.rbpo2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mfa.rbpo2026.entity.ApplicationUser;

import java.util.Optional;
import java.util.UUID;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, UUID> {

    Optional<ApplicationUser> findByEmail(String email);

}
