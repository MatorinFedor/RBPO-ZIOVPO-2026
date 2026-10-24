package ru.mfa.rbpo2026.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {

    READ("read"),
    MODIFICATION("modify");

    private final String authority;

}
