package implementation_0901;
import java.io.*;
import java.util.*;

public class Main_백준_3254_김밥21개 {
	
	private static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		arr = new int[8][7]; // 0, 0은 쓰지 않음
		int cnt = 0;
		String s = "ss";
		ex:for(int t=1; t<=21; t++) {
			cnt++;
			st = new StringTokenizer(br.readLine(), " ");
			int sk = Integer.parseInt(st.nextToken()); // 상근이가 맞춘 줄
			int ji = Integer.parseInt(st.nextToken()); // 지은이가 맞춘 줄
			for(int i=1; i<=6; i++) {
				if(arr[sk][i] == 0) {
					arr[sk][i] = 1; // 상근 => 1
					if(cnt >= 4 && check(1, sk, i)) {
						s = "sk ";
						break ex;
					}
					break;
				}
			}
			
			for(int i=1; i<=6; i++) {
				if(arr[ji][i] == 0) {
					arr[ji][i] = 2; // 지은 => 2
					if(cnt >= 4 && check(2, ji, i)) {
						s = "ji ";
						break ex;
					}
					break;
				}
			}
		}
		sb.append(s);
		if(!s.equals("ss")) {
			sb.append(cnt);
		}
		System.out.println(sb);
	}

	private static boolean check(int num, int r, int c) {
		int cnt = 0;
		// 가로 검사
		for(int i=1; i<=6; i++) {
			if(arr[r][i] == num) {
				cnt++;
			} else {
				cnt = 0;
			}
			if(cnt >= 4) return true;
		}
		
		// 세로 검사
		cnt = 0;
		for (int i=1; i<=7; i++) {
			if(arr[i][c] == num) {
				cnt++;
			} else {
				cnt = 0;
			}
			if(cnt >= 4) return true;
		}
		
		// 대각선 검사
		cnt = 0;
		for(int i=-3; i<=3; i++) {
			if(r+i<=0 || r+i>7 || c+i<=0 || c+i>6) {
				cnt = 0;
				continue;
			}
			if(arr[r+i][c+i] == num) {
				cnt++;
			} else {
				cnt = 0;
			}
			if(cnt >= 4) return true;
				
		}
		cnt = 0;
		for(int i=-3; i<=3; i++) {
			if(r+i<=0 || r+i>7 || c+(i*-1)<=0 || c+(i*-1)>6) {
				cnt = 0;
				continue;
			}
			if(arr[r+i][c+(i*-1)] == num) {
				cnt++;
			} else {
				cnt = 0;
			}
			if(cnt >= 4) return true;
				
		}
		return false;
	}
}
