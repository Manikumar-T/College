public class FairCipher {
    public static void main(String[] args) {
        String msg = "today",preprotext = "";
        char prv,cor;int i=0;
        while (i<msg.length()) {
            cor = msg.charAt(i);
            prv = msg.charAt(i+1);
            if(cor == prv) {
                preprotext=cor+"x_";
                i+=1;    
            }else{
                preprotext=cor+(prv+"_");
                i+=2;
            }
            System.out.println(preprotext);

        }
    }
}
