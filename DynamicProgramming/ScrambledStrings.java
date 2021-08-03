package Codes.DynamicProgramming;

import java.util.HashMap;

public class ScrambledStrings {
    static HashMap <String, Boolean> hmap= new HashMap<>();
   
    static boolean scrambleStrings(String a, String b){
        if(a.equals(b))
            return true;
        if(a.length()<=1)
            return false;
        StringBuilder key=new StringBuilder(a);
        key.append("_");
        key.append(b);
        if(hmap.containsKey(key.toString()))
            return hmap.get(key.toString());
        boolean flag=false;
        int n=a.length();
        for(int k=1;k<=n-1;k++){
            boolean c1= scrambleStrings(a.substring(0,k), b.substring(n-k)) && scrambleStrings(a.substring(k), b.substring(0, n-k));
            boolean c2= scrambleStrings(a.substring(0, k), b.substring(0, k)) && scrambleStrings(a.substring(k), b.substring(k));
            if(c1|| c2){
                flag=true;
                break;
            }

        }
        hmap.put(key.toString(), flag);
        return flag;




    }
    public static void main(String[] args) {
        String a="great", b="rgeat";


        if(a.length()==0 && b.length()==0)
            System.out.println("Scrambled and Empty");
        else
            System.out.println(scrambleStrings(a, b));
    }
}
