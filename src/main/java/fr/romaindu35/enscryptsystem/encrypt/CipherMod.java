package fr.romaindu35.enscryptsystem.encrypt;

import javax.crypto.Cipher;

public enum  CipherMod {



    ENCRYPT_MODE(Cipher.ENCRYPT_MODE),
    DECRYPT_MODE(Cipher.DECRYPT_MODE);

    private int mod;

    /**
     *
     * @param encryptMode : Assigns the mod type to the mod variable: ENCRYPT_MOD or DECRYPT_MOD
     */
    CipherMod(int encryptMode) {
        this.mod = encryptMode;
    }

    /**
     *
     * @return : returns an int according to the chosen mod: ENCRYPT_MOD or DECRYPT_MOD
     */
    public int getEncryptMod() {
        return this.mod;
    }
}
