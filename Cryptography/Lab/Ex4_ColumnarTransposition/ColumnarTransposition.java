import java.util.*;

/**
 * ColumnarTransposition
 */
public class ColumnarTransposition {
    public static void printbanner() {
        System.out.println("'"
        + "*******************************************************\n" +
"     IT1681 - Cryptography and  Networks Security Laboratory\n" +
"\n" +
"	Roll Number : 20UIT020\n" +
"	Name        :T.MANIKUMAR\n" +
"	Ex. No.	    : 04\n" +
"	Ex. Name    : Implementation of Columnar Transposition Cipher	\n" +
"	Date        : 3.02.2023\n" +
"*******************************************************\n" +
"\n" +
"	------- ------- --------\n");
    }
    //Function to find the Alphabet order and retrun the order arrays
    public static int[] alphaOrder(String key) {
        int len=key.length();key = key.toUpperCase();
        int[] temp = new int[len],order=new int[len];
        for (int i = 0; i < len; i++) 
            temp[i]=key.charAt(i);
        
       Arrays.sort(temp);
        for (int i = 0; i < len; i++) 
            order[key.indexOf((char)temp[i])]=i+1;
        
        return order;
        
    }
    //function to print the 2x2 matrix
    public static void printMatrix(char[][] matrix)  {
        
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                
                    System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    //function to Encrypt the plain text and print the cipher text
    public static void Encrypt(String pt,String key) {
            int col=key.length(),row = (pt.length()%col!=0)?(pt.length()/col)+2:pt.length()+1,index=0;
            pt=pt.replaceAll(" ","_").toUpperCase()+("*".repeat(pt.length()%col == 0?0:col - pt.length()%col));String cipher="";
            char[][] matrix = new char[row][col];
    loop:   for (int i = 0; i <row; i++) {
                for (int j = 0; j <col ; j++) {
                    matrix[i][j]=pt.charAt(index++);
                    if (index == pt.length()) {
                        break loop;
                    }
                }
            }
            for (int i : alphaOrder(key)) {
                for (int j = 0; j < row; j++) {
                    cipher+=(matrix[j][i-1]=='_')?" ":matrix[j][i-1];
                }
            }
            System.out.println("Encryption Matrix");
            printMatrix(matrix);
            System.out.println("cipher text:"+cipher);
            
            
    }
    //function to Decrypt the cipher text and print the plain text
    public static void Decrypt(String ct , String key) {
        int index=0,row=ct.length()/key.length(),col=key.length();ct=ct.replaceAll(" ", "_");
        String pt="";char matrix[][] = new char[row][col];
    loop: for (int i : alphaOrder(key)) {
            for (int j = 0; j < row; j++) {
                matrix[j][i-1]=ct.charAt(index++);
                    if (index == ct.length()) {
                        break loop;
                    }
            }
        }
        for (int i = 0; i <row; i++) {
            for (int j = 0; j <col ; j++) {
                pt += (matrix[i][j]=='_')?" " :matrix[i][j]=='*'?"":matrix[i][j];
                
            }
        }
        System.out.println("Decryption Matrix");
        printMatrix(matrix);
        System.out.println("plain Text:"+(pt.toLowerCase()));
    } 
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        printbanner();
        String options="Columnat Transposition\n---------------------\n1.Encryption\n2.Decryption\n3.Exit\n",text,key;        
        int choice;
         do {
            //Get the choice for the user
            System.out.println(options+"Enter your Choice: ");
            choice = sc.nextInt();sc.nextLine();
            switch (choice) {
                case 1:case 2:
                    System.out.println("Enter the "+(choice==1?"plain":"cipher")+" text: ");
                    text=sc.nextLine();
                    if(text.matches("[a-zA-Z]+")) {
                        System.out.println("Enter the key: ");
                        key=sc.next();
                        if(key.matches("[a-zA-Z]+"))
                            if (choice==1) {
                                Encrypt(text, key);
                            } else {
                                Decrypt(text, key);
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
    }
}