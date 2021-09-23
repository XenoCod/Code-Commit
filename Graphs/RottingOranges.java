package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	private static int getRotten(int grid[][]) {
		int m= grid.length, n=grid[0].length;
		
		Queue<int []> q= new LinkedList<>();
		int fresh_count=0, times=0;
		for(int i=0; i<m;i++) {
			for(int j=0; j<n;j++) {
				if(grid[i][j] == 1) fresh_count++;
				else if (grid[i][j] == 2) q.add(new int [] {i, j});
			}
		}
		
		if(fresh_count ==0) return 0; //if no of fresh organes is 0 then the time taken would be zero
		int dirs[][]= {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		
		while(!q.isEmpty()) {
			times++;
			int size=q.size();
			for(int i=0; i<size; i++) {
				int [] curr= q.poll();
				for(int dir[] :dirs) {
					int x= curr[0] + dir[0];
					int y= curr[1] + dir[1];
					
					//Boundary condition
					if(x < 0 || y<0 || x >=m || y>=n || grid[x][y] == 0 || grid[x][y] == 2) continue;
					
					grid[x][y]= 2;//make it rotten
					q.add(new int[] {x,y});
					fresh_count--;
				}
			}
		}
		
		return fresh_count == 0 ? times-1 : -1;

	}

	public static void main(String[] args) {
		int grid[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(getRotten(grid));
	}

}
