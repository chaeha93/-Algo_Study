import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_11404_플로이드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // n개의 도시
		int[][] arr = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i == j) continue;
				arr[i][j] = 10000001; // 100,000 * 100 + 1
			}
		}
		int m = Integer.parseInt(br.readLine()); // m개의 버스
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); // 버스의 시작 도시
			int b = Integer.parseInt(st.nextToken()); // 도착 도시
			int c = Integer.parseInt(st.nextToken()); // 한 번 타는데 필요한 비용
			if(arr[a][b] > c) {
				arr[a][b] = c; 
			}
		}
		for(int k=1; k<=n; k++) { // 경유지
			for(int i=1; i<=n; i++) { // 출발지
				if(i == k) continue;
				for(int j=1; j<=n; j++) { // 도착지
					if(i==j || j==k) continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(arr[i][j] >= 10000001) {
					arr[i][j] = 0;
				}
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
