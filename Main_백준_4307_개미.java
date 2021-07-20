package adhoc_0714;
import java.io.*;
import java.util.*;

public class Main_백준_4307_개미 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int l = Integer.parseInt(st.nextToken()); // 막대의 길이
			int n = Integer.parseInt(st.nextToken()); // 개미의 수
			int min = 0;
			int max = 0;
			for(int i=0; i<n; i++) {
				int num = Integer.parseInt(br.readLine()); // 개미의 위치
				int right = l-num;
				if(num <= right) {
					min = Math.max(min, num);
					max = Math.max(max, right);
				} else {
					min = Math.max(min, right);
					max = Math.max(max, num);
				}
			}
			sb.append(min).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
