package adhoc_0714;
import java.io.*;
import java.util.*;

public class Main_백준_18242_네모네모시력검사 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		ArrayList<int[] > list = new ArrayList<int[] >(); // 모서리 좌표를 담는 list
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = s.charAt(j);
				if(list.isEmpty() && arr[i][j] == '#') {
					list.add(new int[] {i, j});
				}
			}
		}
		
		int[] p = list.get(0);
		// 우상 모서리
		for(int j=M-1; j>p[1]; j--) {
			if(arr[p[0]][j] == '#') {
				list.add(new int[] {p[0], j});
				break;
			}
		}
		// 좌하 모서리
		for(int i=N-1; i>p[0]; i--) {
			if(arr[i][p[1]] == '#') {
				list.add(new int[] {i, p[1]});
				break;
			}
		}
			
		// 우좌 모서리
		p = list.get(2);
		for(int j=M-1; j>p[1]; j--) {
			if(arr[p[0]][j] == '#') {
				list.add(new int[] {p[0], j});
				break;
			}
		}
		
		// LEFT
		int[] p1 = list.get(0);
		int[] p2 = list.get(2);
		for(int i=p1[0]; i<p2[0]; i++) {
			if(arr[i][p1[1]] == '.') {
				System.out.println("LEFT");
				System.exit(0);
			}
		}
		// UP
		p2 = list.get(1);
		for(int j=p1[1]; j<p2[1]; j++) {
			if(arr[p1[0]][j] == '.') {
				System.out.println("UP");
				System.exit(0);
			}
		}
		// RIGHT
		p1 = list.get(1);
		p2 = list.get(3);
		for(int i=p1[0]; i<p2[0]; i++) {
			if(arr[i][p1[1]] == '.') {
				System.out.println("RIGHT");
				System.exit(0);
			}
		}
		// DOWN
		p1 = list.get(2);
		for(int j=p1[1]; j<p2[1]; j++) {
			if(arr[p1[0]][j] == '.') {
				System.out.println("DOWN");
				System.exit(0);
			}
		}
	}

}
