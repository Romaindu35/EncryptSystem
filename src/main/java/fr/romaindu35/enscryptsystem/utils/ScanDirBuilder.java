package fr.romaindu35.enscryptsystem.utils;

public class ScanDirBuilder {

    private Boolean activated = false;
    private Filter filter = new Filter();
    private String converExtension = "";

    public ScanDirBuilder(Boolean activated) {
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
        return new ScanDir(activated, filter, converExtension);
    }

}
