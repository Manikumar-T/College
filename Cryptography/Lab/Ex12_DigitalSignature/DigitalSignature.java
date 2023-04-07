import java.security.*;
import java.util.Scanner;
import jakarta.xml.bind.DatatypeConstants;

public class DigitalSignature {
    public static void printbanner() {
        System.out.println("'"
        + "*******************************************************\n" +
"     IT1681 - Cryptography and  Networks Security Laboratory\n" +
"\n" +
"	Roll Number : 20UIT020\n" +
"	Name        : T.MANIKUMAR\n" +
"	Ex. No.	    : 12\n" +
"	Ex. Name    : Implementation of Digital signature Standard	\n" +
"*******************************************************\n");
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        printbanner();
        //Get the message from the user
        System.out.println("Enter the message to Send:");
        String msg = sc.next();
        //Convert the msg to the Bytes Arrays
        byte msg_byte[] = msg.getBytes();
        //Get the Random secret
        SecureRandom sr = new SecureRandom();
        //Create the instance for Generate the key pair using RSA
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        //initalize the random secret with key pair
        kpg.initialize(2048,sr);
        //Generate the key pair private and public key
        KeyPair key = kpg.generateKeyPair();
        PrivateKey kr = key.getPrivate();
        PublicKey ku = key.getPublic();
        //Create the instance using SHA 256 with RSA
        Signature sign = Signature.getInstance("SHA256withRSA");
        //initalize the private key for signature
        sign.initSign(kr);
        //Update the msg bytes for generate the sign
        sign.update(msg_byte);
        //Generate the sign
        System.out.println("Signature Generated");
        byte output[]=sign.sign();
        //Verify the sign with the public key
        sign.initVerify(ku);
        //Get the received messgae for the user
        System.out.println("Enter the received msg:");
        //Convert the msg into bytes and update the msg bytes to generate the sign
        sign.update(sc.next().getBytes());
        //compate the the msg with received msg sign
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
