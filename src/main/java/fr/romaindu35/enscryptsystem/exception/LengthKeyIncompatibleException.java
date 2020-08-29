package fr.romaindu35.enscryptsystem.exception;

import fr.romaindu35.enscryptsystem.Directory;

public class LengthKeyIncompatibleException extends Exception {
    public LengthKeyIncompatibleException(int length) {
        System.out.println("La clé doit faire 16 caractére, elle en fait : " +length+ " caractère.");
    }
}
