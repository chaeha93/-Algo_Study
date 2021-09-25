package _0915;
import java.io.*;
import java.util.*;

public class Main_백준_16918_봄버맨 {
	
	public static int[] di = {-1, 1, 0, 0};
	public static int[] dj = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		char[][] arr = new char[R][C];
		Queue<int[] > queue = new LinkedList<int[] >();
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = s.charAt(j);
				if(arr[i][j] == 'O') {
					queue.offer(new int[] {i, j});
				}
			}
		}
		
		int time = 1;
		while(time < N) {
			// 모든 칸에 폭탄을 설치
			time++;
			for(int i=0; i<R; i++) {
				Arrays.fill(arr[i], 'O');				
			}
			if(time == N) break;
			
			// 기존 폭탄이 터져야함
			time++;
			while(!queue.isEmpty()) {
				int[] p = queue.poll();
				arr[p[0]][p[1]] = '.';
				
				for(int d=0; d<4; d++) {
					int ni = p[0] + di[d];
					int nj = p[1] + dj[d];
					if(ni<0 || ni >= R || nj < 0 || nj>=C || arr[ni][nj] == '.') continue;
					arr[ni][nj] = '.';
				}
			}
			if(time == N) break;
			// 살아남은 자리 다시 큐에
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(arr[i][j] == 'O') {
						queue.offer(new int[] {i, j});
					}
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
