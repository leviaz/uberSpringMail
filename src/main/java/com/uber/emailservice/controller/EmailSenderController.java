package com.uber.emailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uber.emailservice.application.EmailSenderService;
import com.uber.emailservice.core.EmailRequest;
import com.uber.emailservice.core.exceptions.EmailServiceException;

@RestController
@RequestMapping("/email")
public class EmailSenderController {
  private final EmailSenderService emailSenderService;

  @Autowired
  public EmailSenderController(EmailSenderService emailService) {
    this.emailSenderService = emailService;
  }

  @PostMapping("/send")
  public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
    try {
      this.emailSenderService.sendEmail(request.to(), request.subject(), request.body());
      return new ResponseEntity<>("email send sucessfully", HttpStatus.OK);
    } catch (EmailServiceException ex) {
      return new ResponseEntity<>("error while sending email", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
