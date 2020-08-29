package fr.romaindu35.enscryptsystem.encrypt;

import fr.romaindu35.enscryptsystem.exception.LengthKeyIncompatibleException;

import javax.crypto.Cipher;
import java.io.File;

public class EncryptBuilder {

    private File inputFile;
    private File outputFile;
    private Keys keys = new Keys();
    private CipherMod cipherMod = CipherMod.ENCRYPT_MODE;

    public EncryptBuilder(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public EncryptBuilder setKeys(Keys keys) {
        this.keys = keys;
        return this;
    }

    public EncryptBuilder setCipherMod(CipherMod cipherMod) {
        this.cipherMod = cipherMod;
        return this;
    }

    public Encrypt build() {
        return new Encrypt(inputFile, outputFile, keys, cipherMod);
    }

}
