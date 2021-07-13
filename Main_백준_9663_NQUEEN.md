## 9663_NQUEEN

1. 어차피 한 줄에 다 같이 놓을 수 없으므로 1차원 배열 col을 이용해 열 번호만 저장
2. 다음 줄에 순서대로 isAvailable()을 확인하며 1번 칸부터 N번 칸까지 놓아본다.
3. 만약 열 번호가 끝까지 갔다면, 경우의 수 하나 증가

```
import java.io.*;
import java.util.*;

public class Main_백준_9663_NQueen {
	
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
```
