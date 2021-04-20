package SSAFY_study;

import java.io.*;
import java.util.*;

public class Main_백준_15686_치킨배달 {
	
	private static int[][] distance;
	private static int M, house, chicken;
	public static int ans = Integer.MAX_VALUE;
	public static int[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		numbers = new int[M];
		house = 0; // 집의 개수
		chicken = 0; // 치킨집의 개수
		List<int[] > list = new ArrayList<int[] >();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) ++house;
				else if(map[i][j] == 2) {
					++chicken;
					list.add(new int[] {i, j});
				}
			}
		}
		distance = new int[house][chicken]; // 치킨 거리 담을 배열
		int index = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					for(int k=0; k<chicken; k++) {
						int[] p = list.get(k);
						distance[index][k] = Math.abs(i-p[0]) + Math.abs(j-p[1]);
					}
					index++;
				}
			}
		}
		selectChicken(0, 0);
		System.out.println(ans);
	}

	private static void selectChicken(int cnt, int start) {
		if(cnt == M) {
		//	System.out.print(Arrays.toString(numbers) + " ");
			computeDistance();
			return;
		}
		for(int i=start; i<chicken; i++) {
			numbers[cnt] = i;
			selectChicken(cnt+1, i+1);
		}
		
	}

	private static void computeDistance() {
		int result = 0;
		for(int i=0; i<house; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0; j<M; j++) {
				if(min > distance[i][numbers[j]]) min = distance[i][numbers[j]];
			}
			result += min;		
		}
		ans = Math.min(ans, result);
	//	System.out.print(ans + "\n");
	}
}
