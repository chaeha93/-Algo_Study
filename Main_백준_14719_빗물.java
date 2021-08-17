package implementation_0804;
import java.io.*;
import java.util.*;

public class Main_백준_14719_빗물 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] arr = new int[W];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for(int i=1; i<W-1; i++) {
			int left = 0;
			int right = 0;
			// 왼쪽에서 가장 큰 값
			for(int j=0; j<i; j++) {
				left = Math.max(left, arr[j]);
			}
			// 오른쪽에서 가장 큰 값
			for(int k=i+1; k<W; k++) {
				right = Math.max(right, arr[k]);
			}
			
			int min = Math.min(left, right);
			cnt += min - arr[i] > 0 ? min-arr[i] : 0;
		}
		System.out.println(cnt);
	}

}
