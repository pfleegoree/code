package com.adminportal.service;

import com.adminportal.domain.User;
import com.adminportal.domain.security.PasswordResetToken;
import com.adminportal.domain.security.UserRole;

import java.util.Set;

public interface UserService {
    PasswordResetToken getPasswordResetToken(final String token);

    void createPasswordResetTokenForUser(final User user, final String token);

   User  findByUsername(String username);
   User  findByEmail(String email);

   User createUser(User user, Set<UserRole> UserRoles)throws Exception;

   User save(User user);
}
