package com.topicosesp.emailservice.core.cases;

public interface EmailSenderUseCase {
    void sendEmail(String toEmail, String subject, String body);
}
