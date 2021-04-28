import java.io.*;
import java.util.*;

public class Main_백준_1937_욕심쟁이판다 {
	
	private static int N;
	private static int[][] map;
	private static int[][] distance;
	public static int[] di = {-1, 0, 1, 0}; // 상우하좌
	public static int[] dj = {0, 1, 0, -1}; // 상우하좌
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		distance = new int[N][N]; // 메모이제이션		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int day = dfs(i, j);
				max = Math.max(day, max);

			}
		}
		System.out.println(max);
	}

	private static int dfs(int x, int y) {
		if(distance[x][y] != 0) return distance[x][y];
		distance[x][y] = 1;
	
		for(int d=0; d<4; d++) {
			int ni = x + di[d];
			int nj = y + dj[d];
			if(ni<0 || ni>=N || nj<0 || nj>=N || map[x][y] >= map[ni][nj]) continue;
			distance[x][y] = Math.max(distance[x][y], dfs(ni, nj)+1);
			dfs(ni, nj);
		}
		return distance[x][y];
	}
}
