package edu.study.book.chapter16;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String accountNo;
    private double balance;
    private final ReentrantLock lock;

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
        lock = new ReentrantLock();
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account accounts = (Account) o;
        return Double.compare(accounts.balance, balance) == 0 && Objects.equals(accountNo, accounts.accountNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNo, balance);
    }

    public synchronized void draw1(double drawAmount) {
        if (getBalance() >= drawAmount) {
            System.out.println(Thread.currentThread().getName() + " " + drawAmount);
            setBalance(getBalance() - drawAmount);
        } else {
            System.out.println("不足");
        }
    }

    public synchronized void draw2(double drawAmount) {
        lock.lock();
        try {
            if (getBalance() >= drawAmount) {
                System.out.println(Thread.currentThread().getName() + " " + drawAmount);
                setBalance(getBalance() - drawAmount);
            } else {
                System.out.println("不足");
            }
        } finally {
            lock.unlock();
        }
    }

}
