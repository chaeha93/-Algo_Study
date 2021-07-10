import java.io.*;
import java.util.*;

public class Main_백준_9663_NQueen_1 {
	
	private static int N, ans;
	private static int[] col;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N+1]; // 어차피 한 줄에 다같이 놓을 수 없다. => 열 번호만 저장!
		setQueen(0);
		System.out.println(ans);
	}

	private static void setQueen(int row) {
		if(!isAvailable(row)) { // 그 자리에 놓아질 수 없다.
			return;
		}
		if(row == N) { // 다 놓아짐
			ans++;
			return;
		}
		// 자식노드를 만들어 검사
		for(int i=1; i<=N; i++) {
			col[row+1] = i;
			setQueen(row+1);
		}
		
	}

	private static boolean isAvailable(int row) {
		// 열의 번호가 같거나 대각선에 위치한 경우 false
		for(int i=1; i<row; i++) {
			if(col[i] == col[row] || Math.abs(col[i]-col[row]) == row-i) {
				return false;
			}
		}
		return true;
	}
}