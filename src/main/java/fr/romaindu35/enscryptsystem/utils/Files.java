package fr.romaindu35.enscryptsystem.utils;

import java.io.File;

public class Files extends File {


    public Files(String pathname) {
        super(pathname);
    }

    public boolean exists(Boolean afficheInforamtion) {
        File file = new File(this.getPath());

        return exists(file, afficheInforamtion);
    }

    public static boolean exists(File aVerifier) {
        return exists(aVerifier, false);
    }

    public static boolean exists(File fichier, Boolean afficheInforamtion) {
        if (afficheInforamtion) {
            if (fichier.exists())
                System.out.println("Le fichier : " + fichier.getName() + ", qui a pour chemin absolu " + fichier.getAbsolutePath() + " existe.");
            else
                System.out.println("Le fichier : " + fichier.getName() + ", qui a pour chemin absolu " + fichier.getAbsolutePath() + " n'existe pas.");
        }
        if (fichier.exists())
            return true;
        return false;
    }
}
