package by.st.security;

import by.st.model.Role;
import by.st.model.Status;
import by.st.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getLogin(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                Status.ACTIVE.equals(user.getStatus()),
                mapToGrantedAuthorities(List.of(user.getRole()))
        );
    }

    private static List<SimpleGrantedAuthority> mapToGrantedAuthorities(List<Role> roles) {
        return roles.stream().map(Role::getAuthorities).flatMap(Collection::stream).collect(Collectors.toList());
    }
}
