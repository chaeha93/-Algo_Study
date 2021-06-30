import java.io.*;
import java.util.*;

public class Main_백준_14241_슬라임합치기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 슬라임의 개수
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); // 내림차순 -> 높은 슬라임의 점수부터 뽑기 위해서
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
	
		int score = 0;
		while(!pq.isEmpty()) {
			int num1 = pq.poll();
			if(pq.isEmpty()) break; // pq에 홀수개가 남아 pq가 비어있을 수 있기 때문
			int num2 = pq.poll();
			int sum = num1 + num2;
			score += (num1 * num2);
			pq.add(sum);
		}
		
		System.out.println(score);
	}
}
