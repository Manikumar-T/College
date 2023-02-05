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
        //System.out.println("preprocessed Text:"+Arrays.toString(preprotext.toArray()));
        return preprotext;
    }
    public static String[] genKey(String Ori_key) {
        String keymat[]= new String[5];
        String key="";
        int j=0;
        for (int i = 0; i <91 ; i++) {
            //System.out.println(i);
            //System.out.println("key: "+key+" i: "+(i-1));
            
            if(i<Ori_key.length() && key.indexOf(Ori_key.charAt(i))==-1 ) {
                if((Ori_key.charAt(i)=='I' ||  Ori_key.charAt(i)=='J') && (key.indexOf('I')>-1 || key.indexOf('J')>-1)) {
                   // System.out.println("in I and J check");
                    continue;
                }
                key+=Ori_key.charAt(i);
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
                key+=(char)i;
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
    public static String Encryption(String plaintext , String key)
    {
         
         ArrayList<String>text = preProcessText(plaintext.toUpperCase());
         String keymat[]=genKey(key.toUpperCase()),ciphertext="";
         
        String coloumntext="";int index1,index2;
        text:for (int i = 0; i <text.size(); i++) {
            
            char char1=text.get(i).charAt(0),char2=text.get(i).charAt(1);
            //change the i or j based on the key matrx
                char1= (char1=='J' || char1=='I')?keymat[i%5].indexOf('J')>-1?'J':keymat[i%5].indexOf('I')>-1?'I':char1:char1;
                char2= (char2=='J' || char2=='I')?keymat[i%5].indexOf('J')>-1?'J':keymat[i%5].indexOf('I')>-1?'I':char2:char2;
             System.out.println("first char: "+char1+" second char: "+char2);
            //j for row 
             for (int j = 0; j < 5; j++) {
             coloumntext="";
            //For Rule 1
             index1=keymat[j].indexOf(char1); index2= keymat[j].indexOf(char2);
            if(index1>-1 && index2>-1){
                ciphertext+=keymat[j].charAt((index1+1)%5)+""+keymat[j].charAt((index2+1)%5);
                continue text;
            }
            
            //For Rule 2
            for(int k=0; k<5; k++) coloumntext+=keymat[k].charAt(j);
            index1=coloumntext.indexOf(char1); index2= coloumntext.indexOf(char2);
            if(index1>-1 &&index2>-1){
                ciphertext+=coloumntext.charAt((index1+1)%5)+""+coloumntext.charAt((index2+1)%5);
                continue text;
            }
            
            
            
        }
        //For Rule 3
            for (int k = 0; k < 5; k++) {
                index1=keymat[k].indexOf(char1);
                if(index1>-1) {
                    for (int k2 = 0; k2 < 5; k2++) {
                        index2=keymat[k2].indexOf(char2);
                        if(index2>-1) {
                                ciphertext+=keymat[k].charAt(index2)+""+keymat[k2].charAt(index1);
                                continue text;
                        }
                    }
                }
            }
            
        }
        return ciphertext;
    }
    public static String Decryption(String ciphertext , String key)
    {
         
         ArrayList<String>text = preProcessText(ciphertext.toUpperCase());
         String keymat[]=genKey(key.toUpperCase()),plaintext="";
         
        String coloumntext="";int index1,index2;
        text:for (int i = 0; i <text.size(); i++) {
            
            char char1=text.get(i).charAt(0),char2=text.get(i).charAt(1);
            //change the i or j based on the key matrx
                char1= (char1=='J' || char1=='I')?keymat[i%5].indexOf('J')>-1?'J':keymat[i%5].indexOf('I')>-1?'I':char1:char1;
                char2= (char2=='J' || char2=='I')?keymat[i%5].indexOf('J')>-1?'J':keymat[i%5].indexOf('I')>-1?'I':char2:char2;
             System.out.println("first char: "+char1+" second char: "+char2);
            //j for row 
             for (int j = 0; j < 5; j++) {
             coloumntext="";
            //For Rule 1
             index1=keymat[j].indexOf(char1); index2= keymat[j].indexOf(char2);
            if(index1>-1 && index2>-1){
                plaintext+=keymat[j].charAt((index1-1)<0?(index1-1)+5:(index1-1))+""+keymat[j].charAt((index2-1)<0?(index2-1)+5:(index2-1));
                continue text;
            }
            
            //For Rule 2
            for(int k=0; k<5; k++) coloumntext+=keymat[k].charAt(j);
            index1=coloumntext.indexOf(char1); index2= coloumntext.indexOf(char2);
            if(index1>-1 &&index2>-1){
                plaintext+=coloumntext.charAt((index1-1)<0?(index1-1)+5:(index1-1))+""+coloumntext.charAt((index2-1)<0?(index2-1)+5:(index2-1));
                continue text;
            }
            
            
            
        }
        //For Rule 3
            for (int k = 0; k < 5; k++) {
                index1=keymat[k].indexOf(char1);
                if(index1>-1) {
                    for (int k2 = 0; k2 < 5; k2++) {
                        index2=keymat[k2].indexOf(char2);
                        if(index2>-1) {
                                plaintext+=keymat[k].charAt(index2)+""+keymat[k2].charAt(index1);
                                continue text;
                        }
                    }
                }
            }
            
        }
        return plaintext.toLowerCase();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plain text: ");
        String text = sc.nextLine();
        
        System.out.println("Enter the key value:");
        String key = sc.nextLine();
       
        System.out.println("Decrypted text: "+Decryption(Encryption("cryptography","pet"),"secure"));
    }
}
