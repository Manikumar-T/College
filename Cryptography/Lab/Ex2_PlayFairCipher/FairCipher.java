import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FairCipher {
    
    public static ArrayList<String> preProcessText(String msg) {

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
    public static String[] genKey(String Ori_key) {
        String keymat[]= new String[5];
        String key="";
        int prv_count=0,count=0,j=0;
        for (int i = 0; i <91 ; i++) {
            //System.out.println(i);
            //System.out.println("key: "+key+" i: "+(i-1));
            
            if(i<Ori_key.length() && key.indexOf(Ori_key.charAt(i))==-1 ) {
                if((Ori_key.charAt(i)=='I' ||  Ori_key.charAt(i)=='J') && (key.indexOf('I')>-1 || key.indexOf('J')>-1)) {
                   // System.out.println("in I and J check");
                    continue;
                }
                key+=Ori_key.charAt(i);count++;
                continue;

            }else if(i==Ori_key.length()) {
                i=64;
                continue;
            }

            if(key.indexOf((char)i)==-1 && i>=65) {
                if(((char)i=='I' ||  (char)i=='J') && (key.indexOf('I')>-1 || key.indexOf('J')>-1)) {
                    //System.out.println("in I and J check");
                    continue;
                }
                key+=(char)i;count++;
            }
            
        } 
        //split the entier string into String arrays 
        String temp="";
        for (int i = 0; i < key.length(); i++) {
                    temp+=key.charAt(i);
                    if((i+1)%5==0 && i!=0) {
                            keymat[j++]=temp;
                            temp="";
                    }
        }
        System.out.println(Arrays.toString(keymat));
        return keymat;
             
        
    }
    public static void Encryption(String plaintext , String key)
    {
         
         ArrayList<String>text = preProcessText(plaintext);
         String keymat[]=genKey(key.toUpperCase()),ciphertext="";
         
        
        for (int i = 0; i <text.size(); i++) {
            char char1=text.get(i).charAt(0),char2=text.get(i).charAt(1);
             System.out.println("first char: "+char1+" second char: "+char2);
            for (int j = 0; j < 5; j++) {
            //Rule 1
            int index1=keymat[j].indexOf(char1), index2= keymat[j].indexOf(char2);
            if(index1>-1 &&index2>-1){
                ciphertext+=keymat[j].charAt((index1+1)%5)+""+keymat[j].charAt((index2+1)%5);
            }
            System.out.println("Cipher text: "+ciphertext);
            }
           
            
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the plain text: ");
        // String text = sc.nextLine();
        // //System.out.println(Arrays.toString(preportext.toArray()));
        // System.out.println("Enter the key value:");
        // String key = sc.nextLine();
       
        //Encryption(text,key);
        Encryption("cryptography".toUpperCase(),"secure");
    }
}
