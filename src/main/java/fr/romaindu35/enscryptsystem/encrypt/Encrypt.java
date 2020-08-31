package fr.romaindu35.enscryptsystem.encrypt;

import fr.romaindu35.enscryptsystem.utils.ScanDir;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Encrypt {

    private File inputFile;
    private File outputFile;
    private Keys keys;
    private CipherMod cipherMod;
    private ScanDir scanDir;
    private String extension;

    protected Encrypt(File inputFile, File outputFile, Keys keys, CipherMod cipherMod, ScanDir scanDir) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.keys = keys;
        this.cipherMod = cipherMod;
        this.scanDir = scanDir;
        this.extension = scanDir.getConverExtension();
    }

    public void launch() {
        if (!scanDir.isActivated())
            crypt(inputFile, outputFile);
        else {
            for (File listFile : inputFile.listFiles()) {
                if (!scanDir.getFilter().getExtensionUse().isEmpty()) {
                    for(String strings : scanDir.getFilter().getExtensionUse()){
                        if (listFile.getName().contains(strings)) {
                            crypt(listFile, new File(outputFile.getPath() + "/" + listFile.getName() + extension));
                        }
                    }
                } else {
                    crypt(listFile, new File(outputFile.getPath() + "/" + listFile.getName()));
                }
            }


        }
    }

    private void crypt(File file, File fileTo) {
        try {
            Key secretKey = new SecretKeySpec(keys.getKey().getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMod.getEncryptMod(), secretKey);

            FileInputStream inputStream = new FileInputStream(file);
            byte[] inputBytes = new byte[(int) file.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(fileTo);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IOException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
}
