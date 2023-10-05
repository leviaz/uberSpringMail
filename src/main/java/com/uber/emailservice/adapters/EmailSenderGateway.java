package com.uber.emailservice.adapters;

//contract to be implemented in the applcation package to be extended by external services
public interface EmailSenderGateway {
  void sendEmail(String to, String subject, String body);
}
