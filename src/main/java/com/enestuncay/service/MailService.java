package com.enestuncay.service;

import com.enestuncay.todolist.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {


    @Autowired
    private JavaMailSender mailSender;

    public void registerMail(String mail , String key)
    {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("javamailsender24@gmail.com");
        email.setTo(mail);
        email.setSubject("Üyeliği Tamamla");
        email.setText("Üyeliği tamamlamak için aşağıdaki linke tıklayınız\n\n"
                + LoginController.url + "/reg/" + key);

        mailSender.send(email);
    }

}
