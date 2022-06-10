package edu.study.book.chapter16;

public class DrawThread extends Thread{
    private Account account;
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    public void run() {
        synchronized (account) {
            if (account.getBalance() >= drawAmount) {
                System.out.println(getName() + "  " + drawAmount);
                account.setBalance(account.getBalance() - drawAmount);
            } else {
                System.out.println("不足");
            }
        }
    }
}
