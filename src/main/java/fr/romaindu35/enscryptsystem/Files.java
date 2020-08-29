package fr.romaindu35.enscryptsystem;

import java.io.File;

class Files extends File {


    public Files(String pathname) {
        super(pathname);
    }

    public boolean exists(Boolean afficheInforamtion) {
        File file = new File(this.getPath());
        if (afficheInforamtion && file.exists()) {
            System.out.println("Le fichier : " + file.getName() + ", qui a pour chemin absolu " + file.getAbsolutePath() + " existe.");
        }
        return super.exists();
    }

    public static boolean exists(File aVerifier) {
        if (aVerifier.exists())
            return true;
        return false;
    }

    public static boolean exists(File aVerifier, Boolean afficheInforamtion) {
        if (aVerifier.exists()) {
            if (afficheInforamtion)
                System.out.println("Le fichier : " + aVerifier.getName() + ", qui a pour chemin absolu " + aVerifier.getAbsolutePath() + " existe.");
            return true;
        }
        return false;
    }
}
