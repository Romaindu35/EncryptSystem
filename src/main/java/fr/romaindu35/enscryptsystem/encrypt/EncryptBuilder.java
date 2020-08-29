package fr.romaindu35.enscryptsystem.encrypt;

import fr.romaindu35.enscryptsystem.exception.LengthKeyIncompatibleException;

import javax.crypto.Cipher;
import java.io.File;

public class EncryptBuilder {

    private File inputFile;
    private File outputFile;
    private Keys keys = new Keys();
    private CipherMod cipherMod = CipherMod.ENCRYPT_MODE;
    private boolean scanDir = false;

    /**
     *
     * @param inputFile : file that will be encrypted
     * @param outputFile : file destination once encrypted
     */
    public EncryptBuilder(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    /**
     *
     * @param keys : take a new Keys : Allows you to define an encryption key
     * @return : the instance of the class
     */
    public EncryptBuilder setKeys(Keys keys) {
        this.keys = keys;
        return this;
    }

    /**
     *
     * @param cipherMod : Takes a Cipher and allows to define the encryption mode: encrypt or decrypter
     * @return : the instance of the class
     */
    public EncryptBuilder setCipherMod(CipherMod cipherMod) {
        this.cipherMod = cipherMod;
        return this;
    }

    public EncryptBuilder scanDir(Boolean scanDir) {
        this.scanDir = scanDir;
        return this;
    }
    /**
     *
     * @return : Return an Encrypt object from the EncryptBuilder parameters
     */
    public Encrypt build() {
        return new Encrypt(inputFile, outputFile, keys, cipherMod, scanDir);
    }

}
