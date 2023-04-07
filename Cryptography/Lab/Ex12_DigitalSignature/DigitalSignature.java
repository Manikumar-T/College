
import java.security.*;

import java.util.Scanner;

import jakarta.xml.bind.DatatypeConstants;

public class DigitalSignature {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        //Get the message from the user
        System.out.println("Enter the message to Send:");
        String msg = sc.next();
        byte msg_byte[] = msg.getBytes();
        SecureRandom sr = new SecureRandom();
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048,sr);
        KeyPair key = kpg.generateKeyPair();
        PrivateKey kr = key.getPrivate();
        PublicKey ku = key.getPublic();
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(kr);
        sign.update(msg_byte);
        System.out.println("Signature Genrated");
        byte output[]=sign.sign();
        //System.out.println(DatatypeConverter.printHexBinary(output));
        //System.out.println(DatatypeConstants.printHexBinary(output));

        sign.initVerify(ku);
        System.out.println("Enter the recieved msg:");
        sign.update(sc.next().getBytes());
        boolean verify=sign.verify(output);
        if(verify) {
            System.out.println("Valid Signature");
            System.out.println("Verification Status:"+verify);
        }else{
            System.out.println("InValid Signature");
            System.out.println("Verification Status:"+verify);
        }

        
    }
}
