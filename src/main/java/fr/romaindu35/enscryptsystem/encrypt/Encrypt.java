package fr.romaindu35.enscryptsystem.encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Encrypt {

    private File inputFile;
    private File outputFile;
    private Keys keys;
    private CipherMod cipherMod;
    private boolean scanDir;

    public Encrypt(File inputFile, File outputFile, Keys keys, CipherMod cipherMod, Boolean scanDir) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.keys = keys;
        this.cipherMod = cipherMod;
        this.scanDir = scanDir;
    }

    public void launch() {
        try {
            Key secretKey = new SecretKeySpec(keys.getKey().getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMod.getEncryptMod(), secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IOException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }

}
