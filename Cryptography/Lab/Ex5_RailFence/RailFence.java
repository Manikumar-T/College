
import java.util.Scanner;
public class RailFence {
        //banner to print the information
        public static void printbanner() {
            System.out.println("'"
            + "*******************************************************\n" +
    "     IT1681 - Cryptography and  Networks Security Laboratory\n" +
    "\n" +
    "	Roll Number : 20UIT020\n" +
    "	Name        :T.MANIKUMAR\n" +
    "	Ex. No.	    : 05\n" +
    "	Ex. Name    : Implementation of Rail fence Cipher	\n" +

    "*******************************************************\n" +
    "\n");
        }
    static int depth;static String text,ciphertext="",plaintext="";
   static char matrix[][];
    //Linear function used to do the all linear operation in the matrix eg(dash,print,encrypt)    
    public static void  Linear(String opt){
        int index=0;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < text.length(); j++) {

                if(opt.equals("dash"))
                     matrix[i][j]='-';
                if(opt.equals("print"))
                    System.out.print(matrix[i][j]);
                if(opt.equals("encrypt"))
                    if(matrix[i][j]!='-')
                        ciphertext+=matrix[i][j];
                if(opt.equals("decrypt"))
                    if(matrix[i][j]=='*')
                        matrix[i][j]=text.charAt(index++);

            }
            if(opt.equals("print"))
                System.out.println();
            
        }
        ciphertext=ciphertext.toUpperCase();
        plaintext=plaintext.toLowerCase();

    }
    //Ziczac function used to do the all ziczac operation in the matrix eg(astric,decrypt,encrypt) 
    public static void ziczac(String opt) {

        char state='d';int row=0;
        for (int col = 0; col < text.length(); col++) {
            //It is used to switch the state
            if(row==0)
                state= 'd';
            else if(row == (depth-1))
                state= 'u';
            //It is used to do the downword operation

            if(state=='d') {
            //matrix[row++][col]=(opt=='e')?text.charAt(col):'*';
                if(opt.equals("encrypt"))
                    matrix[row++][col]=text.charAt(col);
                if(opt.equals("astric"))
                    matrix[row++][col]='*';
                if(opt.equals("decrypt"))
                    plaintext+=matrix[row++][col];
            }
            //It is used to do the upword operation
            if(state =='u') {
                //matrix[row--][col]=opt=='e'?text.charAt(col):'*';
                if(opt.equals("encrypt"))
                    matrix[row--][col]=text.charAt(col);
                if(opt.equals("astric"))
                    matrix[row--][col]='*';
                if(opt.equals("decrypt"))
                    plaintext+=matrix[row--][col];
            }
        }
        ciphertext=ciphertext.toUpperCase();
        plaintext=plaintext.toLowerCase();
    }
    
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printbanner();
        String options="Rail Fence\n---------------------\n1.Encryption\n2.Decryption\n3.Exit\n";        
        int choice;
         do {
            //Get the choice from the user
            System.out.println(options+"Enter your Choice: ");
            choice = sc.nextInt();sc.nextLine();
            switch (choice) {
                case 1:case 2:
                    System.out.println("Enter the "+(choice==1?"plain":"cipher")+" text: ");
                    text=sc.nextLine();
                    System.out.println("the text "+ text);
                    if(text.matches("[a-zA-Z\\s*]+")) {
                        System.out.println("Enter the key: ");
                        String str=sc.next();
                        if(str.matches("[0-9]+")) {
                            depth =Integer.parseInt(str);
                            matrix=new char[depth][text.length()];
                            if (choice==1) {
                                //encryption process
                                Linear("dash");
                                ziczac("encrypt");
                                Linear("print");
                                Linear("encrypt");
                                System.out.println("Cipher Text :"+ciphertext);
                            } else {
                                Linear("dash");
                                //Linear("print");
                                ziczac("astric");
                                Linear("print");
                                System.out.println();
                                Linear("decrypt");
                                Linear("print");
                                ziczac("decrypt");
                                System.out.println("plain Text: "+plaintext);
                            }
                        }else
                            System.out.println("Sorry,input must be a positive Number");
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
