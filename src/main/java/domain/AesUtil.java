package domain;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AesUtil {
    private final String ALGO = "AES/GCM/NoPadding";
    private final SecretKey key;
    private final int KEY_SIZE = 128;
    private final int T_LEN = 128;
    private final Cipher encryptionCipher;

    public AesUtil() throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.encryptionCipher = Cipher.getInstance(ALGO);
        this.key = KeyGenerator.getInstance("AES").generateKey();
    }

    public String encrypt(String text) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = encryptionCipher.doFinal(text.getBytes());
        return encode(encVal);
    }

    public String decrypt(String text) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Cipher decryptionCipher = Cipher.getInstance(ALGO);
        GCMParameterSpec spec = new GCMParameterSpec(T_LEN, encryptionCipher.getIV());
        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decVal = decryptionCipher.doFinal(decode(text));
        return new String(decVal);
    }

    public byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    public String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
}
