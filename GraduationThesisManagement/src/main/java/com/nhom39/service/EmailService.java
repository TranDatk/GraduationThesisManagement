package com.nhom39.service;

import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface EmailService {
      public void sendMail(String subject, String [] to, Map<String, Object> model, int type);
}
