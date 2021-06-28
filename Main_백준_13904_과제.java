import java.io.*;
import java.util.*;

public class Main_백준_13904_과제 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		List<int[] > list = new ArrayList<int[] >();
		int day_max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken()); // 과제 마감일까지 남은 일수
			int w = Integer.parseInt(st.nextToken()); // 과제의 점수
			list.add(new int[] {d, w});
			if(day_max < d) {
				day_max = d;
			}
		}
		
		int[] scheduler = new int[day_max]; // 계획표
		Collections.sort(list, new Comparator<int[]>() { // 점수 기준으로 내림차순 정렬

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1]; 
			}
			
		});
		int max = 0;
		for(int i=0; i<N; i++) {
			int[] p = list.get(i);
			for(int j=p[0]-1; j>=0; j--) {
				if(scheduler[j] == 0) {
					scheduler[j] = p[1];
					max += p[1];
					break;
				}
			}
		}
		System.out.println(max);
	}
}
