package fr.romaindu35.enscryptsystem.encrypt;

import java.io.File;

public class EncryptMemoryBuilder {

    private File inputFile;
    private Keys keys = new Keys();
    private CipherMod cipherMod = CipherMod.DECRYPT_MODE;

    /**
     *
     * @param inputFile : file that will be encrypted
     */
    public EncryptMemoryBuilder(File inputFile) {
        this.inputFile = inputFile;
    }

    /**
     *
     * @param keys : take a new Keys : Allows you to define an encryption key
     * @return : the instance of the class
     */
    public EncryptMemoryBuilder setKeys(Keys keys) {
        this.keys = keys;
        return this;
    }

    /**
     *
     * @param cipherMod : Takes a Cipher and allows to define the encryption mode: encrypt or decrypter
     * @return : the instance of the class
     */
    public EncryptMemoryBuilder setCipherMod(CipherMod cipherMod) {
        this.cipherMod = cipherMod;
        return this;
    }

    /**
     *
     * @return : Return an EncryptMemory object from the EncryptMemoryBuilder parameters
     */
    public EncryptMemory build() {
        return new EncryptMemory(inputFile, keys, cipherMod);
    }

}
