package SSAFY_study;

import java.io.*;
import java.util.*;

public class Main_백준_11399_ATM {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 사람의 수
		int[] arr = new int[N];
		int[] output = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i=1; i<=N; i++) {
			output[i] = output[i-1] + arr[i-1];
		}
		int ans = 0;
		for(int i=1; i<=N; i++) {
			ans += output[i];
		}
		System.out.println(ans);
	}
}
