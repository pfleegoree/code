package com.bookstore.utility;

import com.bookstore.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MailConstructor {
    @Autowired
    private Environment env;

    public SimpleMailMessage constructResetTokenMail(
            String contextPath, Locale locale, String token, User user, String password
    ){
        String url = contextPath = "/newUser?token="+token;
        String message = "\nPlease click on this link to verify your personal information ";
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("Elena's Bookstore = new User");
        email.setText(url+message);
        email.setFrom(env.getProperty("support.email"));

        return email;
    }


}
