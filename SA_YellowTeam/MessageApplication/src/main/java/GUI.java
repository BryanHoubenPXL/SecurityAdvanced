import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class GUI {


    public GUI() {

        //hoofdframe
        JFrame guiFrame = new JFrame();
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("message App");
        guiFrame.setSize(500, 500);

        //1 panel met tekstvak en sendknop
        JPanel textPanel = new JPanel();
        final JTextField textArea = new JTextField();
        textArea.setColumns(10);
        JButton sendButton = new JButton("Send");
        textPanel.add(textArea, BorderLayout.WEST);
        textPanel.add(sendButton, BorderLayout.EAST);
        guiFrame.add(textPanel, BorderLayout.NORTH);

        //sendknop eventlistener
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("start");
                String msg = textArea.getText();
                try {
                    //writeMessageToFile(msg, "src\\main\\resources\\msg.txt");
                    System.out.println("Creating keypair");
                    RSAKeyGen keys1 = new RSAKeyGen(1024);
                    keys1.createKeys();
                    System.out.println("Keypair created");
                    System.out.println("Encrypting data");
                    EncryptData encryptor = new EncryptData();
                    encryptor.encrypt(msg, keys1.getPublicKey(), keys1.getPrivateKey());
                    System.out.println("Data encrypted");


                } catch (NoSuchAlgorithmException e1) {
                    e1.printStackTrace();
                } catch (NoSuchPaddingException e1) {
                    e1.printStackTrace();
                } catch (BadPaddingException e1) {
                    e1.printStackTrace();
                } catch (IllegalBlockSizeException e1) {
                    e1.printStackTrace();
                } catch (InvalidKeyException e1) {
                    e1.printStackTrace();
                }
            }
        });

        //centreert gui
        guiFrame.setLocationRelativeTo(null);


        guiFrame.setVisible(true);

    }

    //write naar een txt file. Dit is om te testen en mag niet voorkomen in het uiteindelijke programma
    public void writeMessageToFile(String msg, String path) throws IOException {
        File f = new File(path);

        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        writer.write(msg);
        writer.flush();
        writer.close();
    }




}

