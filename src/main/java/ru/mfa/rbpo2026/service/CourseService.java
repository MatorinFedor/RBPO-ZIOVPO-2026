package ru.mfa.rbpo2026.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.mfa.rbpo2026.dto.CourseDto;
import ru.mfa.rbpo2026.repository.CourseRepository;

import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courses;
    private final DtoMapper mapper;

    @Transactional(readOnly = true)
    public CourseDto get(UUID id) {
        return courses.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Курс не найден"));
    }
}
