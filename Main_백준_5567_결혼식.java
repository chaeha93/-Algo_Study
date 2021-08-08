package implementation_0804;
import java.io.*;
import java.util.*;

public class Main_백준_5567_결혼식 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<Integer>();
		int n = Integer.parseInt(br.readLine()); // 상근이의 동기의 수
		boolean[][] arr = new boolean[n+1][n+1];
		boolean[] isSelected = new boolean[n+1];
		int M = Integer.parseInt(br.readLine());
		for (int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = true;
			if(a == 1 && !isSelected[b]) {
				stack.push(b); // 상근이의 친구들 먼저 stack에 담기
				isSelected[b] = true;
			}
		}
		
		while(!stack.isEmpty()) { // 상근이의 친구의 친구들
			int p = stack.pop();
			for(int i=2; i<=n; i++) {
				if(arr[p][i] && !isSelected[i]) {
					isSelected[i] = true;
				}
			}
		}
		
		int cnt = 0;
		for(int i=2; i<=n; i++) {
			if(isSelected[i]) cnt++;
		}
		
		System.out.println(cnt);
	}

}
