package fr.romaindu35.enscryptsystem.exception;

import fr.romaindu35.enscryptsystem.Directory;

public class NotDirectoryException extends Exception {
    public NotDirectoryException(Directory directory) {
        System.out.println("Le fichier : " +directory.getName() +
                ", qui à pour chemin d'accès " + directory.getAbsolutePath() + " n'est pas un dossier");
    }
}
