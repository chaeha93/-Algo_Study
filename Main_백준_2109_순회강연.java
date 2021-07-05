import java.io.*;
import java.util.*;

public class Main_백준_2109_순회강연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<int[] > pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
				
			}
			
		});
		int max_day = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {p, d});
			if(max_day < p) max_day = p;
		}
		
		int[] schedule = new int[max_day];
		int sum = 0;
		for(int i=0; i<n; i++) {
			int[] p = pq.poll();
			for(int j=p[1]-1; j>=0; j--) {
				if(schedule[j] == 0) {
					schedule[j] = p[1];
					sum += p[0];
					break;
				}
			}
		}
		System.out.println(sum);
	}

}
