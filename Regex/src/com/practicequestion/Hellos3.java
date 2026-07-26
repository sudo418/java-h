package com.practicequestion;

interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class UpiPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI.");
    }
}

class CashPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Cash.");
    }
}

public class Hellos3 {
    public static void main(String[] args) {
        Payment p;

        p = new CreditCardPayment();
        p.pay(5000);

        p = new UpiPayment();
        p.pay(1500);

        p = new CashPayment();
        p.pay(200);
    }
}