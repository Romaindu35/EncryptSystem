package fr.romaindu35.enscryptsystem.encrypt;

import fr.romaindu35.enscryptsystem.exception.LengthKeyIncompatibleException;

import java.util.Random;

public class Keys {

    private String key;

    public Keys() {
        this.key = "kfvxrfqq9s8sp4ve";
    }

    public Keys(String key) throws LengthKeyIncompatibleException {
        if (key.length() != 16)
            throw new LengthKeyIncompatibleException(key.length());
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
