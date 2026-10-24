package ru.mfa.rbpo2026.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mfa.rbpo2026.dto.UserCreateRequest;
import ru.mfa.rbpo2026.entity.ApplicationUser;
import ru.mfa.rbpo2026.enums.ApplicationUserRole;
import ru.mfa.rbpo2026.repository.ApplicationUserRepository;

@Service
@RequiredArgsConstructor
public class ApplicationUserService {

    private final ApplicationUserRepository userRepository;
    private final PasswordEncoder encoder;

    @Transactional
    public ApplicationUser create(UserCreateRequest request) {
        var user = new ApplicationUser();
        user.setEmail(request.email());
        user.setPasswordHash(encoder.encode(request.password()));
        user.setRole(ApplicationUserRole.USER);
        return userRepository.saveAndFlush(user);
    }

}
