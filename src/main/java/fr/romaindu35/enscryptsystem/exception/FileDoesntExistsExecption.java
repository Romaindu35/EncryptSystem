package fr.romaindu35.enscryptsystem.exception;

import java.io.File;

public class FileDoesntExistsExecption extends Exception {
    public FileDoesntExistsExecption(File file) {
        System.out.println("Le fichier : " + file.getName() +
                ", qui a pour chemin absolu " + file.getAbsolutePath() + " n'existe pas.");
    }
}
