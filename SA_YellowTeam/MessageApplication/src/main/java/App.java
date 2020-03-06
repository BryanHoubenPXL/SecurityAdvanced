import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class App {
    public static void main(String[] args) throws
            NoSuchAlgorithmException,
            InvalidKeyException,
            NoSuchPaddingException,
            IOException {
        KeyToFile k = new KeyToFile();

        //generate a public/private keypair using TestPublicKeyGen
        RSAKeyGen keys1 = new RSAKeyGen(1024);
        keys1.createKeys();
        k.convert("C:\\Users\\hoube\\IdeaProjects\\securityAdvanced\\SA_YellowTeam\\MessageApplication\\src\\main\\resources\\AS_Keys\\publicKey.txt", keys1.getPublicKey().getEncoded());
        k.convert("C:\\Users\\hoube\\IdeaProjects\\securityAdvanced\\SA_YellowTeam\\MessageApplication\\src\\main\\resources\\AS_Keys\\privateKey.txt", keys1.getPrivateKey().getEncoded());


        //generate a blowfish key
        BlowfishKeyGen blowKey = new BlowfishKeyGen();
        k.convert("C:\\Users\\hoube\\IdeaProjects\\securityAdvanced\\SA_YellowTeam\\MessageApplication\\src\\main\\resources\\S_Keys\\symKey.txt", blowKey.getSecretKey().getEncoded());
        //System.out.println(blowKey.getSecretKey());

        new GUI();

    }
}
