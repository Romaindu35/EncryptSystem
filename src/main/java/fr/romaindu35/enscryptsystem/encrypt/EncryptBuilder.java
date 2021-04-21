package fr.romaindu35.enscryptsystem.encrypt;

import fr.romaindu35.enscryptsystem.exception.LengthKeyIncompatibleException;
import fr.romaindu35.enscryptsystem.utils.ScanDir;

import javax.crypto.Cipher;
import java.io.File;

public class EncryptBuilder {

    private File inputFile;
    private File outputFile;

    private ScanDir scanDir;

    private Keys keys = new Keys();
    private CipherMod cipherMod = CipherMod.ENCRYPT_MODE;

    private Encrypt.Type type;

    /**
     *
     * @param inputFile : file that will be encrypted
     * @param outputFile : file destination once encrypted
     */
    public EncryptBuilder(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.type = Encrypt.Type.FILE;
    }

    /**
     *
     * @param scanDir : object ScanDir create by ScaDirBuilder
     */
    public EncryptBuilder(ScanDir scanDir) {
        this.scanDir = scanDir;
        this.type = Encrypt.Type.DIR;
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

    /**
     *
     * @return : Return an Encrypt object from the EncryptBuilder parameters
     */
    public Encrypt build() {
        if (type == Encrypt.Type.FILE)
            return new Encrypt(inputFile, outputFile, keys, cipherMod);
        else
            return new Encrypt(scanDir, keys, cipherMod);
    }

}
