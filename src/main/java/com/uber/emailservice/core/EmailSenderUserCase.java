package com.uber.emailservice.core;

//contract to be implemented in the applcation package
//define bussines logic to be applied
public interface EmailSenderUserCase {
  void sendEmail(String to, String subject, String body);
}
