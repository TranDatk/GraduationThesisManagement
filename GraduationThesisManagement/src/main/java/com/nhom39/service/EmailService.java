package com.nhom39.service;

import java.util.Map;

public interface EmailService {
    public void sendMail(String subject, String [] to, Map<String, Object> model, int type);
}
