package edu.study.book.chapter10;

public class AuctionException extends Exception{
    public AuctionException() {
    }

    public AuctionException(String message) {
        super(message);
    }

    public AuctionException(String message, Throwable cause) {
        super(message, cause);
    }
}
