
public class RailFence {
    static int depth;static String text,ciphertext="",plaintext="";
   static char matrix[][];

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
                        matrix[i][j]=ciphertext.charAt(index++);

            }
            if(opt.equals("print"))
                System.out.println();
            
        }
        ciphertext=ciphertext.toUpperCase();
        plaintext=plaintext.toLowerCase();

    }
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
        //Scanner sc = new Scanner(System.in);
        text="manikumar";
        depth = 3;
        matrix=new char[depth][text.length()];
        //encryption process
        Linear("dash");
        //Linear("print");
        ziczac("encrypt");
        //Linear("print");
        Linear("encrypt");
        System.out.println("Cipher Text :"+ciphertext);
        //decryption
        text=ciphertext;
        Linear("dash");
        Linear("print");
        ziczac("astric");
        Linear("print");
        Linear("decrypt");
        Linear("print");
        ziczac("decrypt");
        System.out.println("plain Text: "+plaintext);

        

    }
}
