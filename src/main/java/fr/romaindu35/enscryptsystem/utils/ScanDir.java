package fr.romaindu35.enscryptsystem.utils;

public class ScanDir {

    private boolean activated;
    private Filter filter;
    private String converExtension = "";

    protected ScanDir(Boolean activated, Filter filter, String convertExtension) {
        this.activated = activated;
        this.filter = filter;
        this.converExtension = convertExtension;
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
