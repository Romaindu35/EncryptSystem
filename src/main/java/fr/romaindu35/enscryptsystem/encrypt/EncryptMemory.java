package fr.romaindu35.enscryptsystem.encrypt;

import fr.romaindu35.enscryptsystem.utils.Utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class EncryptMemory {

    private File inputFile;
    private Keys keys;
    private CipherMod cipherMod;

    public EncryptMemory(File inputFile, Keys keys, CipherMod cipherMod) {
        this.inputFile = inputFile;
        this.keys = keys;
        this.cipherMod = cipherMod;
    }

    public File loadInMemory() {
        try {
            File temp = File.createTempFile(inputFile.getName().split("\\.")[0], "." + inputFile.getName().split("\\.")[1]);
            temp.deleteOnExit();

            Utils.crypt(inputFile, temp, keys, cipherMod);

            return temp;

        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IOException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
