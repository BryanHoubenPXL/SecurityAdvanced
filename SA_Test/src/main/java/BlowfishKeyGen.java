import java.security.*;
import javax.crypto.*;

public class BlowfishKeyGen {
    private KeyGenerator keyGenerator;
    private SecretKey secretKey;
    private Cipher cipher;

    public BlowfishKeyGen() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        this.keyGenerator = KeyGenerator.getInstance("Blowfish");
        this.secretKey = keyGenerator.generateKey();
        this.cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    }

    public Cipher getCipher() {
        return cipher;
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

}
