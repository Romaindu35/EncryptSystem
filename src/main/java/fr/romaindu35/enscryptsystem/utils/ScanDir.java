package fr.romaindu35.enscryptsystem.utils;

import java.io.File;
import java.nio.file.Files;

public class ScanDir {

    private File input_directory;
    private File output_directory;
    private boolean activated;
    private Filter filter;
    private String converExtension = "";

    protected ScanDir(File input_directory, File output_directory, Boolean activated, Filter filter, String convertExtension) throws IllegalArgumentException {
        if (!Files.isDirectory(input_directory.toPath()) && !Files.isDirectory(output_directory.toPath()))
            throw new IllegalArgumentException();

        this.input_directory = input_directory;
        this.output_directory = output_directory;
        this.activated = activated;
        this.filter = filter;
        this.converExtension = convertExtension;
    }

    public File getInput_directory() {
        return input_directory;
    }

    public File getOutput_directory() {
        return output_directory;
    }

    public boolean isActivated() {
        return activated;
    }

    public Filter getFilter() {
        return filter;
    }

    public String getConverExtension() {
        return converExtension;
    }
}
