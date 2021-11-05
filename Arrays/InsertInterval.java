import java.util.*;

class InsertInterval{

	private static int[][] insertIntervals(int [][] intervals, int [] newInterval){
		int[] maxInterval= newInterval;
        List<int[]> list= new ArrayList<>();
        
        for(int curr[]: intervals){
            
            //Case 1 when the curr interval apperas after then add the past and upadte
            if(curr[0] > maxInterval[1]){
                list.add(maxInterval);
                maxInterval= curr;
            }
            
            //Case 2 : when there is an overlap
            else if(curr[1] >= maxInterval[0]){
                maxInterval= new int[]{Math.min(curr[0], maxInterval[0]), Math.max(curr[1], maxInterval[1])};
            }
            
            //Case 3 when there is no interval and the max comes after curr
            else list.add(curr);
        }
        
        list.add(maxInterval);
        
        return list.toArray(new int[list.size()][2]);
	}


	public static void main(String[] args) {

// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

		int intervals[][]={{1,2},{3,5},{6,7},{8,10}, {12, 16}};
		int newInterval[]={4, 8};

		intervals=insertIntervals(intervals, newInterval);
		for(int i[]: intervals){
					System.out.println(i[0] +" "+ i[1]);
		}

	}
}