import java.util.*;
public class ColumnarTransposition {
    //banner to print the information
    public static void printbanner() {
        System.out.println("'"
        + "*******************************************************\n" +
"     IT1681 - Cryptography and  Networks Security Laboratory\n" +
"\n" +
"	Roll Number : 20UIT020\n" +
"	Name        :T.MANIKUMAR\n" +
"	Ex. No.	    : 04\n" +
"	Ex. Name    : Implementation of Columnar Transposition Cipher	\n" +
"	Date        : 10.02.2023\n" +
"*******************************************************\n" +
"\n");
    }
    //Function to find the Alphabet position and retrun the position arrays
    public static int[] alphaposition(String key) {
        int len=key.length();key = key.toUpperCase();
        int[] temp = new int[len],position=new int[len];
        for (int i = 0; i < len; i++) 
            temp[i]=key.charAt(i);
        
       Arrays.sort(temp);
       for (int i = 0; i < len; i++){ 
        //position[key.indexOf((char)temp[i])]=i+1;
        position[i]=key.indexOf((char)temp[i]);
        key=key.replaceFirst((char)temp[i]+"", "_");
    }
        System.out.println("The position:"+Arrays.toString(position));
        return position;
        
    }
    //function to print the matrix
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
             int col=key.length(),row = (pt.length()%col!=0)?(pt.length()/col)+1:pt.length()/col,index=0;
            //fill the space with underscore and the filler character with asterisk
             pt=pt.replaceAll(" ","_").toUpperCase()+("*".repeat(pt.length()%col == 0?0:col - pt.length()%col));
            String cipher="";
            char[][] matrix = new char[row][col];
            //Loop to generate matrix from the plain text
    loop:   for (int i = 0; i <row; i++) {
                for (int j = 0; j <col ; j++) {
                    matrix[i][j]=pt.charAt(index++);
                    if (index == pt.length()) {
                        break loop;
                    }
                }
            }
            int[] position= alphaposition(key);
            //loop to generate the cipher text from the matrix
            for (int i:position) {
                for (int j = 0; j < row; j++) {
                    cipher+=(matrix[j][i]=='_')?" " :matrix[j][i]=='*'?"":matrix[j][i];
                }
            }
            System.out.println("Encryption Matrix");
            printMatrix(matrix);
            System.out.println("cipher text:"+cipher);
            
            
    }
    //function to Decrypt the cipher text and print the plain text
    public static void Decrypt(String ct , String key) {
        int col=key.length(),row = (ct.length()%col!=0)?(ct.length()/col)+1:ct.length()/col,index=0;
        ct=ct.replaceAll(" ", "_");
        String pt="";char matrix[][] = new char[row][col];
        int star = ct.length()%col == 0?0:col - ct.length()%col;
        for (int i = 1; i <= star; i++){matrix[row-1][col-i]='*';};
        
        //loop to generate the matrix from the cipher text
    loop: for (int i : alphaposition(key)) {
            for (int j = 0; j < row; j++) {
                matrix[j][i]=(matrix[j][i]=='*')?'*':ct.charAt(index++);
                    if (index == ct.length()) {
                        break loop;
                    }
            }
        }
        //loop to generate the plain text from the matrix
        for (int i = 0; i <row; i++) {
            for (int j = 0; j <col ; j++) {
                pt += (matrix[i][j]=='_')?" " :matrix[i][j]=='*'?"":matrix[i][j];
                
            }
        }
        System.out.println("Decryption Matrix");
        printMatrix(matrix);
        System.out.println("plain Text:"+(pt.toLowerCase()));
    } 
    //main function used to drive the other function
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        printbanner();
        String options="Row-Columnar Transposition\n---------------------\n1.Encryption\n2.Decryption\n3.Exit\n",text,key;        
        int choice;
         do {
            //Get the choice from the user
            System.out.println(options+"Enter your Choice: ");
            choice = sc.nextInt();sc.nextLine();
            switch (choice) {
                case 1:case 2:
                    System.out.println("Enter the "+(choice==1?"plain":"cipher")+" text: ");
                    text=sc.nextLine();
                    if(text.matches("[a-zA-Z\\s*]+")) {
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