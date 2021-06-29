package io.githgub.nicoladaniello.books.security;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        if (rawPassword.toString().isEmpty()) return rawPassword.toString();
        return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(12));
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword.isEmpty() && rawPassword.toString().isEmpty()) return true;
        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
    }
}
