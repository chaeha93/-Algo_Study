import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_9084_동전 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 동전의 가지 수
			int[] coin = new int[N+1]; // 동전 배열
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<=N; i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}
			int money = Integer.parseInt(br.readLine());
			int[] D = new int[money+1];
			D[0] = 1;
			for(int i=1; i<=N; i++) { // 첫번째 코인부터 판단
				for(int k=coin[i]; k<=money; k++) {
					D[k] += D[k-coin[i]];
				}
			}
			sb.append(D[money]).append("\n");
		}
		System.out.println(sb);
	}

}
