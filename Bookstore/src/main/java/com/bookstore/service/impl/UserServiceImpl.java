package com.bookstore.service.impl;

import com.bookstore.domain.User;
import com.bookstore.domain.security.PasswordResetToken;
import com.bookstore.domain.security.UserRole;
import com.bookstore.repository.PasswordResetTokenRepository;
import com.bookstore.repository.RoleRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;



@Service
public class UserServiceImpl implements UserService{

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public PasswordResetToken getPasswordResetToken(final String token) {
        return passwordResetTokenRepository.findByToken(token);
    }

    @Override
    public void createPasswordResetTokenForUser(final User user, final String token) {
        // Find an existing token for the user
        PasswordResetToken existingToken = passwordResetTokenRepository.findByUser(user);

        if (existingToken != null) {
            existingToken.setToken(token);
            existingToken.setExpiryDate(PasswordResetToken.calculateExpiryDate(PasswordResetToken.getExpiration()));
            passwordResetTokenRepository.save(existingToken);
        } else {
            PasswordResetToken newToken = new PasswordResetToken(token, user);
            newToken.setExpiryDate(PasswordResetToken.calculateExpiryDate(PasswordResetToken.getExpiration()));
            passwordResetTokenRepository.save(newToken);
        }

    }
    @Override
    public User  findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    @Override
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception{
        User localUser = userRepository.findByUsername(user.getUsername());

        if(localUser != null) {
           LOG.info("user {} already exists. Nothing will be done", user.getUsername());
        } else {
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);

            localUser = userRepository.save(user);
        }

        return localUser;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


}
