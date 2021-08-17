package implementation_0804;
import java.io.*;
import java.util.*;

public class Main_백준_3190_뱀 {
	
	public static int[] di = {0, 1, 0, -1}; // 우하좌상
	public static int[] dj = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Queue<int[] > tail = new LinkedList<int[] >();
		int[][] map = new int[N+1][N+1];
		int K = Integer.parseInt(br.readLine());
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = -1; // 사과의 위치는 -1
		}
		int L = Integer.parseInt(br.readLine());
		int[][] snake_dir = new int[L][2];
		for(int l=0; l<L; l++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			snake_dir[l][0] = a;
			if(c == 'D') { // 오른쪽
				snake_dir[l][1] = 1;
			} else { // 왼쪽
				snake_dir[l][1] = -1;
			}
		}
		
		int i = 1;
		int j = 1;
		int time = 0;
		int time_index = 0;
		int dir = 0;
		tail.offer(new int[] {1, 1});
		
		while(true) {
			time++;
			int ni = i + di[dir];
			int nj = j + dj[dir];
			if(ni < 1 || ni > N || nj < 1 || nj > N || map[ni][nj] == 1) {
				break; // 뱀이 벽 또는 자신의 몸과 부딪힘
			} else if(map[ni][nj] == -1) { // 이동한 칸에 사과가 있다면
				map[ni][nj] = 1; // 사과를 먹고 뱀 자리로 만듦
			} else { // 이동한 칸에 사과가 없다면
				map[ni][nj] = 1;
				int[] p = tail.poll();
				map[p[0]][p[1]] = 0;
			}
			tail.offer(new int[] {ni, nj});
			i = ni;
			j = nj;
			if(time_index < L && time == snake_dir[time_index][0]) { // 뱀의 방향을 바꿔야 함
				dir = (dir + snake_dir[time_index][1]) % 4;
				if(dir == -1) dir = 3;
				time_index++;
			}
		}
		System.out.println(time);
	}

}
