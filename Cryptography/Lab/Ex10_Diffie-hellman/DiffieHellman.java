import java.util.Scanner;
import java.math.*;
/**
 * DiffieHellman
 */
public class DiffieHellman {
          //banner to print the information
          public static void printbanner() {
            System.out.println("'"
            + "*******************************************************\n" +
    "     IT1681 - Cryptography and  Networks Security Laboratory\n" +
    "\n" +
    "	Roll Number : 20UIT020\n" +
    "	Name        :T.MANIKUMAR\n" +
    "	Ex. No.	    : 10\n" +
    "	Ex. Name    : Implement The Diffie-Hellman Key Exchange Algorithm For A Given Problem	\n" +
    "*******************************************************\n"
    );
        }
    public static int public_key(int Prime,int Gen,int private_key) {

        return (int)Math.pow(Gen,private_key)%Prime;
    }
    public static int share_secret(int Prime,int public_key,int private_key) {

        return (int)Math.pow(public_key ,private_key)%Prime;
    }

    public static void main(String[] args) {
        printbanner();
        Scanner sc  = new Scanner(System.in);
        int Prime, Gen, sender_private, receiver_private, sender_public, receiver_public,sender_secret, receiver_secret;
            
        System.out.println("Enter the Prime Number: ");
        Prime = sc.nextInt();
        System.out.println("Enter the Generator Number: ");
        Gen = sc.nextInt();
        System.out.println("Enter the Sender Private Key: ");
        sender_private = sc.nextInt();
        System.out.println("Enter the Receiver Private Key: ");
        receiver_private = sc.nextInt();
        System.out.println("Sender Public Key: "+(sender_public=public_key(Prime, Gen, sender_private)));
        System.out.println("Receiver Public Key: "+(receiver_public=public_key(Prime, Gen, receiver_private)));

        System.out.println("Shared Secret key for Sender: "+(sender_secret=share_secret(Prime, receiver_public,sender_private)));
        System.out.println("Shared Secret key for Receiver: "+(receiver_secret=share_secret(Prime, sender_public,receiver_private)));

        System.out.println(sender_secret==receiver_secret?"Secret key is successfully shared":"Secret key is not shared");
        sc.close();
        



    }
}