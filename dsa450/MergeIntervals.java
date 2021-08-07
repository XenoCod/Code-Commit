package Codes.dsa450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    static int[][] mergeIntevals(int [][] intervals){
        if(intervals.length<=1) return intervals;


        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int []> res= new ArrayList<>();
        int [] newInterval= intervals[0];
        for(int [] interval: intervals){
            if(interval[0]<=newInterval[1]) newInterval[1]=Math.max(newInterval[1], interval[1]);
            else{
                newInterval= interval;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);




    }
    public static void main(String[] args) {
        int arr[][]={{1,3},{2,6}, {8, 10}, {15, 18} };
        int res[][]= mergeIntevals(arr);
        for(int [] interval:res){
            System.out.println(interval);
        }
    }
}
