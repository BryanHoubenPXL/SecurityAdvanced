import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.*;

public class TestMain {
    public static void main(String[] args) throws
            NoSuchAlgorithmException,
            InvalidKeyException,
            NoSuchPaddingException,
            IOException {

        //generate a public/private keypair using TestPublicKeyGen
        TestPublicKeyGen keys1 = new TestPublicKeyGen(1024);
        keys1.createKeys();
        keys1.writeKeyToFile("src\\main\\resources\\AS_Keys\\publicKey.txt", keys1.getPublicKey().getEncoded());
        keys1.writeKeyToFile("src\\main\\resources\\AS_Keys\\privateKey.txt", keys1.getPrivateKey().getEncoded());



        BlowfishKeyGen blowKey = new BlowfishKeyGen();
        blowKey.writeToFile("src\\main\\resources\\S_Keys\\symKey.txt", blowKey.getSecretKey().getEncoded());
        //System.out.println(blowKey.getSecretKey());

        new GuiTest();



    }
}
