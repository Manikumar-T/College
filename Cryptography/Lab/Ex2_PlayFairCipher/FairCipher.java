import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FairCipher {
    public static ArrayList<String> preProcesText(String msg) {

        ArrayList<String>preprotext = new ArrayList<String>();
        String temp="";
        char prev,cor;int i=1;
        while( i < msg.length()) {
            temp+=prev=msg.charAt(i-1);
            cor=msg.charAt(i);
            
            if(prev == cor) {
                preprotext.add(temp+"x");
        
                if(i == msg.length()-1) {
                    preprotext.add(msg.charAt(i)+"x");
            }
                i++;
            }else {
                preprotext.add(temp+cor);
                if(i == msg.length()-2) 
                        preprotext.add(msg.charAt(i+1)+"x");
                
                i+=2;
                }
                temp="";
      
        }
        return preprotext;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plain text: ");
        ArrayList<String> preportext = preProcesText(sc.next());
        System.out.println(Arrays.toString(preportext.toArray()));        
    }
}
