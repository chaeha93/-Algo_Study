import java.io.*;
import java.util.*;

public class Main_백준_1715_카드정렬하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		int ans = 0;
		while (pq.size() > 1) { // 마지막 비교는 이미 카드 묶음끼리 다 비교한 후에 한 비교이기 때문에 size가 1이어도 ans에 더해지면 안된다.
			int n1 = pq.poll();
			int n2 = pq.poll();
			int sum = n1 + n2;
			ans += sum;
			pq.offer(sum);
		}
		System.out.println(ans);
	}

}
