
public class RailFence {
    static int depth;static String ptext;
   static char matrix[][];

    public static void  ArrayOpt(char opt){
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < ptext.length(); j++) {

                if(opt == 'i')
                     matrix[i][j]='-';
                else
                    System.out.print(matrix[i][j]);
            }
            if(opt!='i')
                System.out.println();
            
        }

    }
    public static void ziczacMapper(char opt) {
        ArrayOpt('i');
        char state='d';int row=0;
        for (int col = 0; col < ptext.length(); col++) {
            //It is used to switch the state
            if(row==0)
                state= 'd';
            else if(row == (depth-1))
                state= 'u';
            //It is used to do the downword operation
            if(state=='d')

                if(opt=='e')
                    matrix[row++][col]=ptext.charAt(col);
                else
                    matrix[row++][col]='*';
            //It is used to do the upword operation
            if(state =='u')

                if(opt=='e')
                    matrix[row--][col]=ptext.charAt(col);
                else
                    matrix[row--][col]='*';

        }
    }
   
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        ptext="cryptography";
        depth = 3;
        matrix=new char[depth][ptext.length()];

        //RailFence rf = new RailFence(depth, ptext);
        
        ziczacMapper('e');
        ArrayOpt('p');
    }
}
