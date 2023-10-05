package com.uber.emailservice.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uber.emailservice.adapters.EmailSenderGateway;
import com.uber.emailservice.core.EmailSenderUserCase;

@Service
public class EmailSenderService implements EmailSenderUserCase {

  private final EmailSenderGateway emailSenderGateway;

  @Autowired
  public EmailSenderService(EmailSenderGateway emailGateway) {
    this.emailSenderGateway = emailGateway;
  }

  @Override
  public void sendEmail(String to, String subject, String body) {
    emailSenderGateway.sendEmail(to, subject, body);
  }

}
