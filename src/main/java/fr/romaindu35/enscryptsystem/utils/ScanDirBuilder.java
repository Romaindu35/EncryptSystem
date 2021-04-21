package fr.romaindu35.enscryptsystem.utils;

import java.io.File;

public class ScanDirBuilder {

    private File input_directory;
    private File output_directory;
    private Boolean activated = false;
    private Filter filter = new Filter();
    private String convertExtension = "";

    /**
     *
     * @param input_directory : directory where are the files to crypt/decrypt
     * @param output_directory : directory where are the results of crypt/decrypt
     * @param activated : boolean to know if ScanDir is active
     */
    public ScanDirBuilder(File input_directory, File output_directory, Boolean activated) {
        this.input_directory = input_directory;
        this.output_directory = output_directory;
        this.activated = activated;
    }

    /**
     *
     * @param filter : object filter to filter files
     * @return : instance of class
     */
    public ScanDirBuilder addFilterList(Filter filter) {
        this.filter = filter;
        return this;
    }

    /**
     *
     * @param convertExtension : if the files must be changed, specify the extension here
     * @return : instance of class
     */
    public ScanDirBuilder convertTo(String convertExtension) {
        this.convertExtension = convertExtension;
        return this;
    }

    /**
     * Function to build ScanDirBuilder and return ScanDir
     * @return : ScanDir instance
     */
    public ScanDir build() {
        return new ScanDir(input_directory, output_directory, activated, filter, convertExtension);
    }

}
