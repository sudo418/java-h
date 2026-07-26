package com.practicequestion;

interface Notification {
    void sendMessage();
}

abstract class MessageService {
    void connectServer() {
        System.out.println("Connecting to server...");
    }
}

class EmailNotification extends MessageService implements Notification {
    @Override
    public void sendMessage() {
        connectServer();
        System.out.println("Email sent.");
    }
}

class SMSNotification extends MessageService implements Notification {
    @Override
    public void sendMessage() {
        connectServer();
        System.out.println("SMS sent.");
    }
}

class WhatsAppNotification extends MessageService implements Notification {
    @Override
    public void sendMessage() {
        connectServer();
        System.out.println("WhatsApp message sent.");
    }
}

public class Hellos6 {
    public static void main(String[] args) {
        Notification n;

        n = new EmailNotification();
        n.sendMessage();

        n = new SMSNotification();
        n.sendMessage();

        n = new WhatsAppNotification();
        n.sendMessage();
    }
}