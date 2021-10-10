package nosubject_1006;

import java.io.*;
import java.util.*;

public class Main_백준_17276_배열돌리기 {
	
	private static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(d>=0) {
				int num = d / 45;
				while(num > 0) {
					num--;
					arr = clockwiseTurn(arr);
				}
			} else {
				int num = Math.abs(d) / 45;
				while(num > 0) {
					num--;
					arr = counterclockwiseTurn(arr);
				}
			}

			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static int[][] counterclockwiseTurn(int[][] arr) {
		int[][] ans = new int[n][n];
		
		int r = 0;
		int c = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(j == n/2) {
					ans[r++][c++] = arr[i][j];
				}
				if(i == j) {
					ans[n/2][j] = arr[i][j];
				} else if(i == n/2) {
					ans[n-1-j][j] = arr[i][j];
				} else if(i+j == n-1) {
					ans[i][n/2] = arr[i][j];
				} else if(j != n/2) {
					ans[i][j] = arr[i][j];
				}
 			}
		}
		return ans;
	}

	private static int[][] clockwiseTurn(int[][] arr) {
		int[][] ans = new int[n][n];
		
		for(int i=0; i<n; i++) {
			int r = 0;
			int c = 0;
			for(int j=0; j<n; j++) {
				if(i==n/2) {
					ans[r++][c++] = arr[i][j];
				}
				if(i == j) {
					ans[i][n/2] = arr[i][j];
				} else if(j == n/2) {
					ans[i][n-i-1] = arr[i][j];
				} else if(i+j == n-1) {
					ans[n/2][j] = arr[i][j];
				} else if(i!=n/2) {
					ans[i][j] = arr[i][j];
				}
			}
		}
		return ans;
	}
}
