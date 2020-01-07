package com.practice.threads.deadlock;

/**
 * Created by IntelliJ IDEA.
 * User: Anand Ram
 * Date: Mar 17, 2010
 * Time: 4:26:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Account
{
    private String name;
    private String accountNumber;
    private float balance;

    public Account(String name, String acNumber, float bal)
    {
        this.name = name;
        this.accountNumber = acNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public float getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public float debit(float amount)
    {
        this.balance = this.balance - amount;
        return balance;
    }

    public float credit(float amount)
    {
        this.balance = this.balance + amount;
        return balance;
    }

    public String toString()
    {
        return "(" ; 
    }
}
