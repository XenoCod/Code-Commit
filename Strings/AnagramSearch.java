package Codes.Strings;

public class AnagramSearch {
    static boolean anagramSearch(String text, String target){
        int textCount[]= new int[256];
        int targetCount[]= new int [256];
        for(int i=0;i< target.length();i++){
            textCount[text.charAt(i)]++;
            targetCount[target.charAt(i)]++;
        }
        for(int i=target.length();i<text.length();i++){
            if(areSame(textCount, targetCount))
                return true;

            textCount[text.charAt(i)]++;
            textCount[text.charAt(i- target.length())]--;

        }
        return false;

    }
    static boolean areSame(int a[], int b[]){
        for(int i =0; i<256;i++)
            if (a[i]!=b[i])
                return false;
        return  true;
    }
    public static void main(String[] args) {
        String s="geeksforgeeks";
        String target="frog";
        System.out.println(anagramSearch(s, target));
    }
}
