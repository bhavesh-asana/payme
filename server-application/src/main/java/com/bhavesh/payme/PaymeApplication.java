package com.bhavesh.payme;

import com.bhavesh.payme.mailer.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class PaymeApplication {
    @Autowired
    private SendMail sendMail;

    public static void main(String[] args) {

        SpringApplication.run(PaymeApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail(){
        sendMail.sendEmail("hello@bhavesh-asana.com",
                "This is a subject",
                "This is a body");
    }

}
