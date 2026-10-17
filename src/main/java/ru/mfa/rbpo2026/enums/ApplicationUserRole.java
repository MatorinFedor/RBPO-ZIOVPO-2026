package ru.mfa.rbpo2026.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public enum ApplicationUserRole {

    USER(Set.of(Permission.READ)),
    ADMIN(Set.of(Permission.READ, Permission.MODIFICATION));

    private final Set<Permission> permissions;

    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (var permission : permissions) {
            authorities.add(new SimpleGrantedAuthority(permission.getAuthority()));
        }
        authorities.add(new SimpleGrantedAuthority("ROLE_" + name()));
        return authorities;
    }

}
