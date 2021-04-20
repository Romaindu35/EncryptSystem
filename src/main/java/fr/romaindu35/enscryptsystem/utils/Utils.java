package fr.romaindu35.enscryptsystem.utils;

import fr.romaindu35.enscryptsystem.encrypt.CipherMod;
import fr.romaindu35.enscryptsystem.encrypt.Keys;

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

public class Utils {

    public static void crypt(File file, File temp, Keys keys, CipherMod cipherMod) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        Key secretKey = new SecretKeySpec(keys.getKey().getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(cipherMod.getEncryptMod(), secretKey);

        FileInputStream inputStream = new FileInputStream(file);
        byte[] inputBytes = new byte[(int) file.length()];
        inputStream.read(inputBytes);

        byte[] outputBytes = cipher.doFinal(inputBytes);

        FileOutputStream outputStream = new FileOutputStream(temp);
        outputStream.write(outputBytes);

        inputStream.close();
        outputStream.close();
    }

}
