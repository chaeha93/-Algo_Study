package datastructure_0825;
import java.io.*;

public class Main_백준_6198_옥상정원꾸미기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 빌딩의 개수
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		long cnt = 0;
		for(int idx=0; idx<N; idx++) {
			for(int i=idx+1; i<N; i++) {
				if(arr[i] < arr[idx]) cnt++;
				else break;
			}
		}
		System.out.println(cnt);
	}
}
