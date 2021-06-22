import java.util.Scanner;

public class PowerSet {
    static void powerSet(String s){
        int n=s.length();
        int size= (int) Math.pow(2,n);//Since there can be only 2^n subset where nis the lenght og the element
        for(int counter=0;counter<size;counter++){
            for(int j=0;j<n;j++){
                if((counter& (1<<j))!=0)
                    System.out.print(s.charAt(j));

            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the string");
        String s=sc.nextLine();
        powerSet(s);
    }
}