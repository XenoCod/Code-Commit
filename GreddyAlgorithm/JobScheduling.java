package Codes.GreddyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Job{
    char id;
    int deadline, profit;
    public Job(char c,int d, int p){
        id=c;
        deadline=d;
        profit=p;
    }
}

public class JobScheduling {
    static void jobSchdule(ArrayList<Job> arr, int d){
        Collections.sort(arr, (a,b)->b.profit-a.profit);
        boolean res[]= new boolean[d];
        char jobs[]= new char[d];
        for(int i=0;i< arr.size();i++){
            for(int j=Math.min(d-1, arr.get(i).deadline-1);j>=0;j--){
                if(!res[j]){
                    res[j]=true;
                    jobs[j]=arr.get(i).id;
                    break;
                }
            }
        }
        for(int i=0;i<jobs.length;i++)
            System.out.print(jobs[i]+" " );

    }
    public static void main(String[] args) {
        ArrayList <Job> arr= new ArrayList<>();

        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));
        int d=3;
        jobSchdule(arr,d);

    }
}
