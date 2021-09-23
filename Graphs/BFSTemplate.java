package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTemplate {

	private static int countIsland(char grid[][]) {
		int m = grid.length, n = grid[0].length;

		Queue<int[]> q = new LinkedList<>();
		int dirs[][] = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

		boolean visited[][] = new boolean[m][n];

		int islands = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					visited[i][j] = true;
					q.add(new int[] { i, j });
					islands++;
					bfs(grid, visited, q, dirs);
				}
			}
		}
		return islands;
	}

	static private void bfs(char grid[][], boolean visited[][], Queue<int[]> q, int dirs[][]) {
		int m = grid.length, n = grid[0].length;

		while (!q.isEmpty()) {
			int curr[] = q.poll();
			for (int dir[] : dirs) {
				int x = curr[0] + dir[0];
				int y = curr[1] + dir[1];

				// bounary checks
				if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == '0')
					continue;

				visited[x][y] = true;
				q.add(new int[] { x, y });

			}
		}
	}

	public static void main(String[] args) {
		char grid[][] = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

		System.out.println(countIsland(grid));
	}

}
