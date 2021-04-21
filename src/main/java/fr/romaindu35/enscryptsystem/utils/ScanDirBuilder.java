package fr.romaindu35.enscryptsystem.utils;

import java.io.File;

public class ScanDirBuilder {

    private File input_directory;
    private File output_directory;
    private Boolean activated = false;
    private Filter filter = new Filter();
    private String converExtension = "";

    public ScanDirBuilder(File input_directory, File output_directory, Boolean activated) {
        this.input_directory = input_directory;
        this.output_directory = output_directory;
        this.activated = activated;
    }

    public ScanDirBuilder addFilterList(Filter filter) {
        this.filter = filter;
        return this;
    }

    public ScanDirBuilder convertTo(String converExtension) {
        this.converExtension = converExtension;
        return this;
    }

    public ScanDir build() {
        return new ScanDir(input_directory, output_directory, activated, filter, converExtension);
    }

}
