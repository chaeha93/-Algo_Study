package graphtheory_0908;
import java.io.*;
import java.util.*;

public class Main_백준_10026_적록색약 {

	private static int N;
	private static char[][] map;
	public static boolean[][] visited;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		int non_rgw = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, map[i][j], 0);
					non_rgw++;
				}
			}
		}

		// visited 배열 false로 초기화
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				visited[i][j] = false;
			}
		}
		
		int rgw = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, map[i][j], 1);
					rgw++;
				}
			}
		}
		sb.append(non_rgw).append(" ").append(rgw);
		System.out.println(sb);
	}

	private static void bfs(int i, int j, char c, int num) { // 좌표(i, j), 비교값 c, 적록색약 구분 번호
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { i, j });
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int[] p = queue.poll();

			for (int d = 0; d < 4; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];
				if (ni < 0 || ni >= N || nj < 0 || nj >= N || visited[ni][nj]) continue;
				if (num == 0 && map[ni][nj] == c) { //적록색약 아니고, 같은 구역이라면
					queue.offer(new int[] { ni, nj });
					visited[ni][nj] = true;
				} else if(num == 1) { // 적록색약이면
					if(map[ni][nj] == c || (c == 'R' && map[ni][nj]=='G') || (c == 'G' && map[ni][nj]=='R')) {
						queue.offer(new int[] {ni, nj});
						visited[ni][nj] = true;
					}
				}
			}
		}
	}
}
