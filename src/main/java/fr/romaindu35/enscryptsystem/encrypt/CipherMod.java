package fr.romaindu35.enscryptsystem.encrypt;

import javax.crypto.Cipher;

public enum  CipherMod {



    ENCRYPT_MODE(Cipher.ENCRYPT_MODE),
    DECRYPT_MODE(Cipher.DECRYPT_MODE);

    private int mod;

    CipherMod(int encryptMode) {
        this.mod = encryptMode;
    }

    public int getEncryptMod() {
        return this.mod;
    }
}
