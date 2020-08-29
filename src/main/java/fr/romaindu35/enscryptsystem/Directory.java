package fr.romaindu35.enscryptsystem;

import fr.romaindu35.enscryptsystem.exception.FileDoesntExistsExecption;
import fr.romaindu35.enscryptsystem.exception.LengthKeyIncompatibleException;
import fr.romaindu35.enscryptsystem.exception.NotDirectoryException;

import java.io.File;

public class Directory extends File {

    private Directory directory;

    public Directory(String pathname) throws NotDirectoryException, FileDoesntExistsExecption {
        super(pathname);
        if (!this.exists())
            throw new FileDoesntExistsExecption(this);
        if (!this.isDirectory())
            throw new NotDirectoryException(this);
    }
}
