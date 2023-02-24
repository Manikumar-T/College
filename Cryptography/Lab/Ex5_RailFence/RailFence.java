
public class RailFence {
    static int depth;static String text;
   static char matrix[][];

    public static void  ArrayOpt(char opt){
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < text.length(); j++) {

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
        for (int col = 0; col < text.length(); col++) {
            //It is used to switch the state
            if(row==0)
                state= 'd';
            else if(row == (depth-1))
                state= 'u';
            //It is used to do the downword operation
            if(state=='d')
            matrix[row++][col]=opt=='e'?text.charAt(col):'*';

            //It is used to do the upword operation
            if(state =='u')
                matrix[row--][col]=opt=='e'?text.charAt(col):'*';

        }
    }
   
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        text="cryptography";
        depth = 3;
        matrix=new char[depth][text.length()];

        
        
        ziczacMapper('e');
        ArrayOpt('p');
    }
}
