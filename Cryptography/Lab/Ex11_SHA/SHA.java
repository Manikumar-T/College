import java.util.*;
import javax.security.*;
import java.math.*;
import java.security.MessageDigest;

public class SHA {
        //banner to print the information
        public static void printbanner() {
            System.out.println("'"
            + "*******************************************************\n" +
    "     IT1681 - Cryptography and  Networks Security Laboratory\n" +
    "\n" +
    "	Roll Number : 20UIT020\n" +
    "	Name        :T.MANIKUMAR\n" +
    "	Ex. No.	    : 11\n" +
    "	Ex. Name    : Calculate The Message Digest Of A Text Using The SHA-1 Algorithm	\n" +
    "*******************************************************\n");
        }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        printbanner();
        //Get the value for the user
        System.out.println("Enter the message: ");
        String msg = sc.next();
        //Create the instance for the SHA-1
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        //Get the message digest as byte
        byte[] mDigest = md.digest(msg.getBytes());
        BigInteger bi = new BigInteger(1,mDigest);
        //convert the Hexadecimal
        String hash = bi.toString(16);
        while (hash.length()<32) {
            hash="0"+hash;
        }
        //print the message
        System.out.println("The hash value for the given message "+msg+" is \n"+hash);
    }
}
