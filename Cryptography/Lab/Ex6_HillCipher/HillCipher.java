import java.util.*;
public class HillCipher {
    public static void printbanner() {
        System.out.println("'"
        + "*******************************************************\n" +
"     IT1681 - Cryptography and  Networks Security Laboratory\n" +
"\n" +
"	Roll Number : 20UIT020\n" +
"	Name        :T.MANIKUMAR\n" +
"	Ex. No.	    : 03\n" +
"	Ex. Name    : Implementation of Vigenere Cipher	\n" +
"*******************************************************\n" +
"\n");
    }
    static int keymatrix[][],inversmatrix[][],msgmatrix[][],n,resultmatrix[][];
    static String key,msg;
    public static void kInvers() {
        int detofk;
        if (keymatrix.length==2) {
            detofk= keymatrix[0][0]*keymatrix[1][1]-keymatrix[0][1]*keymatrix[1][0];
        }else {
            detofk= keymatrix[0][0]*(keymatrix[1][1]*keymatrix[2][2]-keymatrix[1][2]*keymatrix[2][1])
                    -keymatrix[0][1]*(keymatrix[1][0]*keymatrix[2][2]-keymatrix[2][0]*keymatrix[1][2])
                    +keymatrix[0][2]*(keymatrix[1][0]*keymatrix[2][1]-keymatrix[1][1]*keymatrix[2][0]);
        }
        detofk=detofk<0?detofk+26 : detofk;
        
       // return detofk;
        int i=1;
        while ((detofk*i++)%26!=1);
        detofk=i-1;
        //System.out.println(detofk= i-1);
        if (keymatrix.length==2) {
            inversmatrix[0][0]=keymatrix[1][1];
            inversmatrix[0][1]=-keymatrix[0][1];
            inversmatrix[1][0]=-keymatrix[1][0];
            inversmatrix[1][1]=keymatrix[0][0];
        }else {
           inversmatrix[0][0] = +((keymatrix[1][1]*keymatrix[2][2])-(keymatrix[1][2]*keymatrix[2][1]));
           inversmatrix[0][1] = -((keymatrix[0][1]*keymatrix[2][2])-(keymatrix[0][2]*keymatrix[2][1]));
           inversmatrix[0][2] = +((keymatrix[0][1]*keymatrix[1][2])-(keymatrix[0][2]*keymatrix[1][1]));
           inversmatrix[1][0] = -((keymatrix[1][0]*keymatrix[2][2])-(keymatrix[1][2]*keymatrix[2][0]));
           inversmatrix[1][1] = +((keymatrix[0][0]*keymatrix[2][2])-(keymatrix[0][2]*keymatrix[2][0]));
           inversmatrix[1][2] = -((keymatrix[0][0]*keymatrix[1][2])-(keymatrix[0][2]*keymatrix[1][0]));
           inversmatrix[2][0] = +((keymatrix[1][0]*keymatrix[2][1])-(keymatrix[1][1]*keymatrix[2][0]));
           inversmatrix[2][1] = -((keymatrix[0][0]*keymatrix[2][1])-(keymatrix[0][1]*keymatrix[2][0]));
           inversmatrix[2][2] = +((keymatrix[0][0]*keymatrix[1][1])-(keymatrix[0][1]*keymatrix[1][0]));

        }
        for (i = 0; i < keymatrix.length; i++) {
            for (int j = 0; j < keymatrix.length; j++) {
                inversmatrix[i][j]=inversmatrix[i][j]<0?((inversmatrix[i][j]*detofk)%26)+26:(inversmatrix[i][j]*detofk)%26;
            }
            System.out.println();
        }
    }
    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
    }
    public static void genMsgMatrix() {
        msg=msg.toLowerCase();
        int index=0;
        //System.out.println("row:"+msgmatrix.length+"column:"+msgmatrix[0].length);
        for (int i = 0; i < msgmatrix[0].length; i++) {
            for (int j = 0; j < msgmatrix.length; j++) {
                msgmatrix[j][i] = (msg.charAt(index++)-97)%26;
            }
        }
    }
    
    public static void genKeyMatrix() {
        keymatrix = new int[n][n];
        inversmatrix = new int[n][n];
        key = key.toLowerCase();
        int index=0;

        for (int i = 0; i < keymatrix.length; i++) {
            for (int j = 0; j < keymatrix.length; j++) {
                keymatrix[i][j] = (key.charAt(index++)-97)%26;
            }
        }
    }
    public static String encrypt() {
        String ciphertext="";
        genMsgMatrix();
        System.out.println();
        genKeyMatrix();
        printMatrix(keymatrix);
        int sum=0;
        for (int i = 0; i < keymatrix.length; i++) {
            for (int j = 0; j < msgmatrix[0].length; j++) {
                sum=0;
                for (int k = 0; k < msgmatrix.length; k++) {
                    sum+=keymatrix[i][k] * msgmatrix[k][j];
                }
                resultmatrix[i][j]=sum%26;
            }
        }
        System.out.println("result matrix");
        printMatrix(resultmatrix);
        for (int i = 0; i < resultmatrix[0].length; i++) {
            for (int j = 0; j < resultmatrix.length; j++) {
                ciphertext+=(char)(resultmatrix[j][i]+65);
            }
        }
        return ciphertext;
    }
    public static String decrypt() {
        String plaintext="";
        genMsgMatrix();
        genKeyMatrix();
        printMatrix(keymatrix);
        kInvers();
        printMatrix(inversmatrix);
        int sum=0;
        for (int i = 0; i < inversmatrix.length; i++) {
            for (int j = 0; j < msgmatrix[0].length; j++) {
                sum=0;
                for (int k = 0; k < msgmatrix.length; k++) {
                    sum+=inversmatrix[i][k] * msgmatrix[k][j];
                }
                resultmatrix[i][j]=sum%26;
            }
        }
        System.out.println("result matrix");
        printMatrix(resultmatrix);
        for (int i = 0; i < resultmatrix[0].length; i++) {
            for (int j = 0; j < resultmatrix.length; j++) {
                plaintext+=(char)(resultmatrix[j][i]+97);
            }
        }
        return plaintext;
    }
    public static void init(String msgloc,String keyloc) {
        if(msgloc.length()%2==0 && keyloc.length()%2==0) {
            n=2;
            msgmatrix = new int[2][msgloc.length()/2];
            resultmatrix = new int[2][msgloc.length()/2];
            msg=msgloc;
            key=keyloc;
        }else if(msgloc.length()%3==0 && keyloc.length()%3==0) { 
            n=3;
            msgmatrix  = new int[3][msgloc.length()/3];
            resultmatrix  = new int[3][msgloc.length()/3];
            msg=msgloc;
            key=keyloc;
        }else{
            System.out.println("Sorry,Square Matrix is not able to Generate");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        printbanner();
        String options="Hill Cipher\n----------------\n1.Encryption\n2.Decryption\n3.Exit\n",text,key;        
        int choice;
         do {
            //Get the choice for the user
            System.out.println(options+"Enter your Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:case 2:
                    System.out.println("Enter the "+(choice==1?"plain":"cipher")+" text: ");
                    msg=sc.next();
                    if(msg.matches("[a-zA-Z]+")) {
                        System.out.println("Enter the key: ");
                        key=sc.next();
                        if(key.matches("[a-zA-Z]+")) {
                            init(msg, key);
                            if(choice==1) 
                                System.out.println(encrypt());
                            else
                                System.out.println(decrypt());
                        }
                        else
                            System.out.println("Sorry,input mus be a word");
                    }else
                        System.out.println("Sorry,input must be a word");    
                    break;
                case 3:
                    System.out.println("Bye..");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while(choice!=3);






        {// int row  = sc.nextInt(),col = sc.nextInt();
        // keymatrix = new int[row][col];
        // inversmatrix = new int[row][col];
        // for (int i = 0; i < keymatrix.length; i++) {
        //     for (int j = 0; j < keymatrix.length; j++) {
        //         System.out.print("matrix["+i+"]["+j+"]=");
        //         keymatrix[i][j]=sc.nextInt();
        //     }
        //     System.out.println();
        // }
        // kInvers();
        // printMatrix(keymatrix);
        //System.out.println(kInvers());
        }

    }
}
