import java.io.*;
import java.util.*;

public class Main_백준_1261_알고스팟 {

	public static int[] di = { -1, 0, 1, 0 }; // 상우하좌
	public static int[] dj = { 0, 1, 0, -1 }; // 상우하좌
	private static int M, N;
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j - 1) - '0';

			}
		}
		int ans = bfs();
		System.out.println(ans);
	}

	private static int bfs() {
		int ans = 0;
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		boolean[][] visited = new boolean[N+1][M+1];
		queue.offer(new Point(1, 1, 0));
		visited[1][1] = true;
		
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (p.x == N && p.y == M) {
				ans = p.cnt;
				break;
			}

			for (int d = 0; d < 4; d++) {
				int ni = p.x + di[d];
				int nj = p.y + dj[d];
				if (ni < 1 || ni > N || nj < 1 || nj > M || visited[ni][nj]) continue;

				if (map[ni][nj] == 0) {
					queue.offer(new Point(ni, nj, p.cnt));
				} else if (map[ni][nj] == 1) { // 벽을 부숴야함
					queue.offer(new Point(ni, nj, p.cnt+1));
				}
				visited[ni][nj] = true;
			}
		}
		return ans;
	}
}

class Point implements Comparable<Point> {

	int x, y, cnt;
	
	public Point(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt; // 벽을 부순 횟수
	}

	@Override
	public int compareTo(Point o) {
		return this.cnt - o.cnt; // 오름차순
	}

}
