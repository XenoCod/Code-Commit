package Codes.GreddyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

class Activity{
    int start, finish;
    Activity(int s, int f){
        start=s;
        finish=f;

    }
}

class MyCmp implements Comparator<Activity> {
    public int compare(Activity a1, Activity a2){
        return a1.finish-a2.finish;
    }
}

public class ActivitySelection {
    static int activitySelect(Activity arr[], int n){
        Arrays.sort(arr, new MyCmp());
        int res=1, prev=0;
        for(int i=1;i<n;i++){
            if(arr[i].start>=arr[prev].finish){
                res++;
                prev=i;
            }
        }
        return res;

    }
    public static void main(String[] args) {
        Activity arr[]={new Activity(12, 25),
                new Activity(10, 20),
                new Activity(20, 30)};
        int n=3;
        System.out.println(activitySelect(arr, n));

    }
}
