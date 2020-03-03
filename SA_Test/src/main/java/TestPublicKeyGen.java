import java.security.*;
import javax.crypto.*;
import java.io.*;

public class TestPublicKeyGen {
    private KeyPairGenerator generator;
    private KeyPair keyPair;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public TestPublicKeyGen(int keyLength) throws NoSuchAlgorithmException {
        this.generator = KeyPairGenerator.getInstance("RSA");
        this.generator.initialize(keyLength);
    }

    public void createKeys() {
        this.keyPair = this.generator.generateKeyPair();
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
}


