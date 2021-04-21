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
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Utils {

    /**
     * Function to crypt/decrypt file
     * @param input_file : input file
     * @param output_file : output file
     * @param keys : keys to encode/decode
     * @param cipherMod : if file must be crypt/decrypt
     * @throws NoSuchAlgorithmException : exception thrown if error
     * @throws NoSuchPaddingException : exception thrown if error
     * @throws InvalidKeyException : exception thrown if error
     * @throws IOException : exception thrown if error
     * @throws IllegalBlockSizeException : exception thrown if error
     * @throws BadPaddingException : exception thrown if error
     */
    public static void crypt(File input_file, File output_file, Keys keys, CipherMod cipherMod) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        if (!Files.exists(output_file.toPath()))
            output_file.getParentFile().mkdirs();

        Key secretKey = new SecretKeySpec(keys.getKey().getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(cipherMod.getEncryptMod(), secretKey);

        FileInputStream inputStream = new FileInputStream(input_file);
        byte[] inputBytes = new byte[(int) input_file.length()];
        inputStream.read(inputBytes);

        byte[] outputBytes = cipher.doFinal(inputBytes);

        FileOutputStream outputStream = new FileOutputStream(output_file);
        outputStream.write(outputBytes);

        inputStream.close();
        outputStream.close();
    }

}
