package twopointer_0721;
import java.io.*;
import java.util.*;

public class Main_백준_2003_수들의합2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int cnt = 0;
		int idx = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=idx; i<N; i++) {
			int sum = 0;
			for(int j=i; j<N; j++) {
				sum += arr[j];
				if(sum == M) {
					idx++;
					cnt++;
					break;
				} else if(sum > M) {
					idx++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}
