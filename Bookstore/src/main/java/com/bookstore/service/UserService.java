package com.bookstore.service;

import com.bookstore.domain.security.PasswordResetToken;
import com.bookstore.domain.User;

public interface UserService {
    PasswordResetToken getPasswordResetToken(final String token);

    void createPasswordResetTokenForUser(final User user, final String token);

   User  findByUsername(String username);
   User  findByEmail(String email);
}
