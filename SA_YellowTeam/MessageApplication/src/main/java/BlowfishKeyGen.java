import javax.crypto.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class BlowfishKeyGen {
    private KeyGenerator keyGenerator;
    private SecretKey secretKey;
    //private Cipher cipher;

    public BlowfishKeyGen() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        this.keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(128);
        this.secretKey = keyGenerator.generateKey();


        //this.cipher = Cipher.getInstance("Blowfish");
        //cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    }

    /*public Cipher getCipher() {
        return cipher;
    }*/

    public SecretKey getSecretKey() {
        return secretKey;
    }
}
