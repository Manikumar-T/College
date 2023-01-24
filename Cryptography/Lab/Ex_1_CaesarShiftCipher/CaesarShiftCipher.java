 import java.util.*;

 class CaesarCipher {
    //Encryption using caesar cipher
    static String Encrypt(String p) {
        p=p.toLowerCase();
        String c="";int temp,k=3;
        for(int i : p.toCharArray()) {
            i=i-97;
            temp =((i+k)%26)+65;
            c+=(char)temp;
        }
      
        return c;
    }
     //Decryption using caesar cipher
    static String Decrypt(String c) {
        String p="";int temp,k=3;
        for(int i : c.toCharArray()) {
            i=i-65;
            temp =(i-k)>=0?((i-k)%26)+97:26+(i-k)+97;
            p+=(char)temp;
        }
        
        return p;
    }
 }
 class ShiftCipher {
     //Encryption using shift cipher
     static String Encrypt(String p,int k) {
        p=p.toLowerCase();
        String c="";int temp;
        for(int i : p.toCharArray()) {
            i=i-97;
            temp =((i+k)%26)+65;
            c+=(char)temp;
        }
        
        return c;
    }
     //Decryption using Shift cipher
    static String Decrypt(String c,int k) {
        String p="";int temp;
        for(int i : c.toUpperCase().toCharArray()) {  
            i=i-65;
            temp =(i-k)>=0?((i-k)%26)+97:26+(i-k)+97;
            p+=(char)temp;
        }
        
        return p;
    }
 }
 class CaesarShiftCipher {
    
   
    public static void main(String args[]) {
        System.out.println("'"
        + "*******************************************************\n" +
"     IT1681 - Cryptography and  Networks Security Laboratory\n" +
"\n" +
"	Roll Number : 20UIT020\n" +
"	Name        : T.Manikumar\n" +
"	Ex. No.	    : 01\n" +
"	Ex. Name    : Implementation of Caesar Cipher and shift Cipher	\n" +
"	Date        : 13.01.2023\n" +
"*******************************************************\n" +
"\n" +
"	------- ------- --------\n'");
        String menu1="\tMENU\n\t----\n1.caesar cipher\n2.Shift cipher\n3.Exit\nEnter your choice:",menu2="\t\tMENU\n\t\t----\n\t1.Encryption\n\t2.Decryption\n\tEnter your choice:";
            Scanner sc = new Scanner(System.in);
            int choice1,choice2;
            do {
                    System.out.println(menu1);
                    choice1=sc.nextInt();
                    switch(choice1) {
                        case 1:
                            System.out.print(menu2);
                            choice2=sc.nextInt();
                            switch (choice2) {
                                case 1:
                                    System.out.println("Enter the plain text:");
                                    System.out.println("Cipher text:"+CaesarCipher.Encrypt(sc.next()));
                                    break;
                                case 2:
                                    System.out.println("Enter the cipher text:");
                                    System.out.println("plain text:"+CaesarCipher.Decrypt(sc.next()));
                                    
                                    break;
                                default:
                                    System.out.println("Invalid input");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.print(menu2);
                            choice2=sc.nextInt();
                            switch (choice2) {
                                case 1:
                                    System.out.println("Enter the plain text:");
                                    String ptext = sc.next();
                                    System.out.println("Enter the key:");
                                    int k1 = sc.nextInt();
                                    System.out.println("Cipher text:"+((k1>=0 && k1<=25)?ShiftCipher.Encrypt(ptext,k1):"Sorry, Key value exceeds the limit"));
                                    
                                    break;
                                case 2:
                                    System.out.println("Enter the cipher text:");
                                    String ctext = sc.next();
                                    System.out.println("Enter the key:");
                                    int k2 = sc.nextInt();
                                    System.out.println("plain text:"+((k2>=0 && k2<=25)?ShiftCipher.Decrypt(ctext,k2):"Sorry, Key value exceeds the limit"));
                                    
                                    break;
                                default:
                                    System.out.println("Invalid input");
                                    
                            }
                            break;
                        case 3:
                            System.out.println("Bye....");
                            break;
                        default:
                            System.out.println("Invalid input");
                            
                    }
            }while(choice1!=3);
    }
 }
