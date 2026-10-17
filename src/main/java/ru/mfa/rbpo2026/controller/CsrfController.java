package ru.mfa.rbpo2026.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mfa.rbpo2026.dto.CsrfTokenResponse;

@RestController
public class CsrfController {

    @GetMapping("/csrf-token")
    public ResponseEntity<CsrfTokenResponse> csrf(CsrfToken csrfToken) {
        var response = new CsrfTokenResponse(
                csrfToken.getHeaderName(), csrfToken.getToken());
        return ResponseEntity.ok(response);
    }

}
