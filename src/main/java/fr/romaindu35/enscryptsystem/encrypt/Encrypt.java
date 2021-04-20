package fr.romaindu35.enscryptsystem.encrypt;

import fr.romaindu35.enscryptsystem.utils.ScanDir;
import fr.romaindu35.enscryptsystem.utils.Utils;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

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
                            crypt(listFile, new File(outputFile.getPath() + "/" +
                                    listFile.getName().subSequence(0, listFile.getName().lastIndexOf(".")) + extension));
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
            Utils.crypt(file, fileTo, keys, cipherMod);

        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IOException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
}
