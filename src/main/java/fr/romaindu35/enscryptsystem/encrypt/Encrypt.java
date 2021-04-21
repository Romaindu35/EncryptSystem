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

    private ScanDir scanDir;
    private String extension;

    private Keys keys;
    private CipherMod cipherMod;

    private Encrypt.Type type;

    protected Encrypt(File inputFile, File outputFile, Keys keys, CipherMod cipherMod) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.keys = keys;
        this.cipherMod = cipherMod;

        this.type = Encrypt.Type.FILE;
    }

    protected Encrypt(ScanDir scanDir, Keys keys, CipherMod cipherMod) {
        this.keys = keys;
        this.cipherMod = cipherMod;
        this.scanDir = scanDir;
        this.extension = scanDir.getConverExtension();
        this.inputFile = scanDir.getInput_directory();
        this.outputFile = scanDir.getOutput_directory();

        this.type = Encrypt.Type.DIR;
    }

    public void run() {
        if (type == Type.FILE)
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

    enum Type {
        FILE,
        DIR
    }
}
