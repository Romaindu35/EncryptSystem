package fr.romaindu35.enscryptsystem.utils;

import java.io.File;

public class Files extends File {


    public Files(String pathname) {
        super(pathname);
    }

    public boolean exists(Boolean showInformation) {
        File file = new File(this.getPath());

        return exists(file, showInformation);
    }

    public static boolean exists(File toVerify) {
        return exists(toVerify, false);
    }

    public static boolean exists(File file, Boolean showInformation) {
        if (showInformation) {
            if (file.exists())
                System.out.println("The file : " + file.getName() + ", which has for absolute path " + file.getAbsolutePath() + " exist.");
            else
                System.out.println("The file : " + file.getName() + ", which has for absolute path " + file.getAbsolutePath() + " don't exist.");
        }
        if (file.exists())
            return true;
        return false;
    }
}
