import java.util.ArrayList;
import java.util.Arrays;

public class FairCipher {
    
    public static void main(String[] args) {
        ArrayList<String>preprotext = new ArrayList<String>();
        String msg = "tree",temp= "";
        char prev,cor;int i=1;
        while( i < msg.length()) {
            temp+=prev=msg.charAt(i-1);
            cor=msg.charAt(i);
            //System.out.println("prev: "+prev+" cor:"+cor);
            if(prev == cor) {
                preprotext.add(temp+"x");
                //System.out.println(" "+i);
                if(i == msg.length()-1) {
                    preprotext.add(msg.charAt(i)+"x");
            }
                i++;
            }else {
                preprotext.add(temp+cor);
                if(i == msg.length()-2) {
                        preprotext.add(msg.charAt(i+1)+"x");
                }
                i+=2;
            }

            
            temp="";
      
        }
        
        System.out.println("Pre Processed text: "+Arrays.toString(preprotext.toArray()));
    }
}
