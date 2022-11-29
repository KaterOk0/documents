package by.st.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static by.st.model.Permission.QUERIES_READ;
import static by.st.model.Permission.QUERIES_WRITE;
import static by.st.model.Permission.SETTINGS_READ;
import static by.st.model.Permission.SETTINGS_WRITE;

public enum Role {
    USER(Set.of(QUERIES_READ, SETTINGS_READ)),
    ADMIN(Set.of(QUERIES_READ, QUERIES_WRITE, SETTINGS_READ, SETTINGS_WRITE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
