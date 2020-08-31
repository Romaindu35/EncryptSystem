package fr.romaindu35.enscryptsystem.utils;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    private Boolean onlyExtensionUse = false;
    private List<String> extensionUse = new ArrayList<>();

    public Filter() {

    }

    public Filter extensionUse(String extension) {
        this.extensionUse.add(extension);
        this.onlyExtensionUse = true;
        return this;
    }

    public Filter extensionUse(List<String> extension) {
        this.extensionUse = extension;
        this.onlyExtensionUse = false;
        return this;
    }

    public Boolean getOnlyExtensionUse() {
        return onlyExtensionUse;
    }

    public List<String> getExtensionUse() {
        return extensionUse;
    }

}
