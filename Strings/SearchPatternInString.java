package Codes.Strings;


public class SearchPatternInString {
    static void patternSearch(String s, String pat){
        int n=s.length();
        int m=pat.length();

        for(int i=0;i<=n-m;){
            int j;
            for(j=0;j<m;j++)
                if(s.charAt(i+j)!=pat.charAt(j))
                    break;
            if(j==m)
                System.out.print(i+" ");
            if (j==0)
                i++;
            else
                    i+=j;
        }

    }
    public static void main(String[] args) {
        String s="AAAAAAA";
        String pat="AAA";
        patternSearch(s,pat);
    }
}
