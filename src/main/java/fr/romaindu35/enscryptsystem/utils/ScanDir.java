package fr.romaindu35.enscryptsystem.utils;

public class ScanDir {

    private boolean activated;
    private Filter filter;

    protected ScanDir(Boolean activated, Filter filter) {
        this.activated = activated;
        this.filter = filter;
    }

    public boolean isActivated() {
        return activated;
    }

    public Filter getFilter() {
        return filter;
    }
}
