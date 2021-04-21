package fr.romaindu35.enscryptsystem.utils;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    private Boolean onlyExtensionUse = false;
    private List<String> extensionUse = new ArrayList<>();

    public Filter() {

    }

    /**
     * function to set extension to use
     * @param extension : extension to use
     * @return : instance of the class
     */
    public Filter extensionUse(String extension) {
        this.extensionUse.add(extension);
        this.onlyExtensionUse = true;
        return this;
    }

    /**
     * function to set extensions to use
     * @param extension : list of extension to use
     * @return : instance of the class
     */
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
