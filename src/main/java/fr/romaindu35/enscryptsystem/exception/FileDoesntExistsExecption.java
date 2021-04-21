package fr.romaindu35.enscryptsystem.exception;

import java.io.File;

public class FileDoesntExistsExecption extends Exception {
    public FileDoesntExistsExecption(File file) {
        System.out.println("The file : " + file.getName() +
                ", which has for absolute path " + file.getAbsolutePath() + " don't exist.");
    }
}
