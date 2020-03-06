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

        //generate a public/private keypair using TestPublicKeyGen
        RSAKeyGen keys1 = new RSAKeyGen(1024);
        keys1.createKeys();
        keys1.writeKeyToFile("C:\\Users\\hoube\\IdeaProjects\\securityAdvanced\\SA_YellowTeam\\MessageApplication\\src\\main\\resources\\AS_Keys\\publicKey.txt", keys1.getPublicKey().getEncoded());
        keys1.writeKeyToFile("C:\\Users\\hoube\\IdeaProjects\\securityAdvanced\\SA_YellowTeam\\MessageApplication\\src\\main\\resources\\AS_Keys\\privateKey.txt", keys1.getPrivateKey().getEncoded());


        //generate a blowfish key
        BlowfishKeyGen blowKey = new BlowfishKeyGen();
        blowKey.writeToFile("C:\\Users\\hoube\\IdeaProjects\\securityAdvanced\\SA_YellowTeam\\MessageApplication\\src\\main\\resources\\S_Keys\\symKey.txt", blowKey.getSecretKey().getEncoded());
        //System.out.println(blowKey.getSecretKey());

        new GUI();

    }
}
