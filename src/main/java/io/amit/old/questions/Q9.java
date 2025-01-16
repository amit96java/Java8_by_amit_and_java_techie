package io.amit.old.questions;

/**
 * Definition: High-level modules should not depend on low-level modules.
 * Both should depend on abstractions.
 */


// Abstraction
interface MessageService {
    void sendMessage(String message);
}

// Low-level module
class EmailService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Email sent: " + message);
    }
}

// High-level module, even if EmailService is replaced by SmsService but there is no
// modification need in Notification class because it is using Abstraction.
class Notification {
    private MessageService service;

    public Notification(MessageService service) {
        this.service = service;
    }

    public void notify(String message) {
        service.sendMessage(message);
    }
}


// Main method to demonstrate dependency injection
public class Q9 {

    public static void main(String[] args) {
        MessageService service = new EmailService();
        Notification notification = new Notification(service);
        notification.notify("Hello, World!");
    }
}
