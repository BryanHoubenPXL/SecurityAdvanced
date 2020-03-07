import java.io.*;
import java.security.*;
import javax.crypto.*;

public class EncryptData {
    private Cipher cipher;

    public EncryptData() throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
    }

    public void encrypt(String msg, PublicKey key, PrivateKey pKey) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        this.cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(msg.getBytes());
        System.out.println(msg);
        System.out.println(encrypted.toString());
        decrypt(encrypted.toString(), pKey);

    }

    public void decrypt(String encrypted, PrivateKey key) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        this.cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(encrypted.getBytes());
        System.out.println(decrypted.toString());
    }
}
