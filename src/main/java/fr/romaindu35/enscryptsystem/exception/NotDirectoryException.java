package fr.romaindu35.enscryptsystem.exception;

import fr.romaindu35.enscryptsystem.utils.Directory;

public class NotDirectoryException extends Exception {
    public NotDirectoryException(Directory directory) {
        System.out.println("The file : " +directory.getName() +
                ", who has for path " + directory.getAbsolutePath() + " is not a folder");
    }
}
