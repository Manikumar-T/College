import java.util.*;

import javax.crypto.*;
import javax.crypto.spec.*;

public class DES {
    //banner to print the information
    public static void printbanner() {
        System.out.println("'"
        + "*******************************************************\n" +
"     IT1681 - Cryptography and  Networks Security Laboratory\n" +
"\n" +
"	Roll Number : 20UIT020\n" +
"	Name        :T.MANIKUMAR\n" +
"	Ex. No.	    : 07\n" +
"	Ex. Name    : Apply DES algorithm for practical Application	\n" +
"*******************************************************\n" +
"\n");
    }
    public static  void  encryptDecrypt(String text) throws Exception {

        byte[]textbyte = text.getBytes();
        //Generating Key
        KeyGenerator Mygenerator = KeyGenerator.getInstance("DES");
        SecretKey DESKey = Mygenerator.generateKey();
        //initializing crypto algorithm
        Cipher myCipher = Cipher.getInstance("DES");
        //setting encryption mode
        myCipher.init(Cipher.ENCRYPT_MODE, DESKey);
        byte[] myEncryptedBytes=myCipher.doFinal(textbyte);
        System.out.println("Cipher Text: "+ new String(myEncryptedBytes));

        //setting decryption mode
        myCipher.init(Cipher.DECRYPT_MODE, DESKey);
        byte[] myDecryptedBytes=myCipher.doFinal(myEncryptedBytes);
        System.out.println("Decrypted Text: "+ new String(myDecryptedBytes));
    }

    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        printbanner();
        System.out.println("Enter the password: ");
        String passwd = sc.next();
        if(passwd.length()>=8)
            encryptDecrypt(passwd);
        else    
            System.out.println("Invalid password");
    }   
}
