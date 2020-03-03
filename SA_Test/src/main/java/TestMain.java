import javax.crypto.NoSuchPaddingException;
import java.security.*;

public class TestMain {
    public static void main(String[] args) throws
            NoSuchAlgorithmException,
            InvalidKeyException,
            NoSuchPaddingException {

        TestPublicKeyGen keys1 = new TestPublicKeyGen(1024);
        keys1.createKeys();
        System.out.println(keys1.getPrivateKey());

        BlowfishKeyGen blowKey = new BlowfishKeyGen();
        System.out.println(blowKey.getCipher());
        System.out.println(blowKey.getSecretKey());
    }
}
