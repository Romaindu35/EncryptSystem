package fr.romaindu35.enscryptsystem.exception;

public class LengthKeyIncompatibleException extends Exception {
    public LengthKeyIncompatibleException(int length) {
        System.out.println("La clé doit faire 16 caractére, elle en fait : " +length+ " caractère.");
    }
}
