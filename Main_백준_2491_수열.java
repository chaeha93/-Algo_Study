import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2491_수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean inc = false;
		boolean desc = false;
		int len = 1;
		int max = 1;
		
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				len++;
				max = Math.max(max, len);
				continue;
			} else if (arr[i] < arr[i + 1]) {
				inc = true;
				if (desc) {
					desc = false;
					len = 1;
					int l = i;
					while (l>=1 && arr[l] == arr[l-1]) {
						len++;
						l--;
					}
					max = Math.max(max, len);
				}
			} else {
				desc = true;
				if (inc) {
					inc = false;
					len = 1;
					int l = i;
					while (l>=1 && arr[l] == arr[l-1]) {
						len++;
						l--;
					}
					max = Math.max(max, len);
				}
			}
			if (inc) {
				len++;
			} else if (desc) {
				len++;
			}
			max = Math.max(max, len);
		}
		System.out.println(max);
	}
}
