import java.security.*;

public class TestMain {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        TestPublicKeyGen keys1 = new TestPublicKeyGen(1024);
        keys1.createKeys();
        System.out.println(keys1.getPrivateKey());
    }
}
