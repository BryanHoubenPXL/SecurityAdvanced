import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import javax.crypto.*;

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

    public void writeToFile(String path, byte[] key) throws IOException {
        File filePath = new File(path);

        FileOutputStream outputStream = new FileOutputStream(filePath);
        outputStream.write(key);
        outputStream.flush();
        outputStream.close();
    }

}
