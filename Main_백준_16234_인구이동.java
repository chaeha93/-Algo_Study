package simulation_0609;

import java.io.*;
import java.util.*;

public class Main_백준_16234_인구이동 {

	private static int N, L, R;
	private static int[][] population;
	private static boolean[][] visited;
	public static int[] di = { -1, 1, 0, 0 }; // 상하좌우
	public static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		population = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int day = 0;
		int cnt = 0;
		while (true) {
			visited = new boolean[N][N]; // 국경 연합 해제 후 시작
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			if (cnt == N * N)
				break;
			day++;
			cnt = 0;
		}
		System.out.println(day);
	}

	private static void bfs(int r, int c) {
		List<int[]> list = new ArrayList<int[]>();
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { r, c });
		int sum = 0;

		while (!queue.isEmpty()) {
			int[] p = queue.poll();

			for (int d = 0; d < 4; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];
				if (0 > ni || ni >= N || 0 > nj || nj >= N || visited[ni][nj])
					continue;
				int sub = Math.abs(population[p[0]][p[1]] - population[ni][nj]);
				if (L <= sub && sub <= R && !visited[ni][nj]) {
					queue.offer(new int[] { ni, nj });
					list.add(new int[] { ni, nj });
					sum += population[ni][nj];
					visited[ni][nj] = true;
				}
			}
		}

		// 인구 이동
		int size = list.size();
		if (list.size() <= 1)
			return;
		int people = sum / list.size();
		for (int[] p : list) {
			population[p[0]][p[1]] = people;
		}
	}
}