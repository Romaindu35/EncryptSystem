package fr.romaindu35.enscryptsystem.exception;

public class LengthKeyIncompatibleException extends Exception {
    public LengthKeyIncompatibleException(int length) {
        System.out.println("The key must be 16 characters long, it makes : " +length+ " character.");
    }
}
