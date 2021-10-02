package nosubject_0915;
import java.io.*;
import java.util.*;

public class Main_백준_14891_톱니바퀴 {

	private static ArrayList[] gear;
	private static int[] dir;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		gear = new ArrayList[5];
		for (int i = 1; i <= 4; i++) {
			gear[i] = new ArrayList<Integer>();
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				gear[i].add(s.charAt(j) - '0');
			}
		}
		int K = Integer.parseInt(br.readLine()); // 회전 횟수
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			dir = new int[5];
			dir[num] = d;
			boolean[] havetoSpin = checkPole(num);
			for(int i=1; i<=4; i++) {
				if(havetoSpin[i]) {
					rotateGear(i, dir[i]);
				}
			}
		}
		
		int ans = 0;
		if((int)gear[1].get(0) == 1) ans += 1;
		if((int)gear[2].get(0) == 1) ans += 2;
		if((int)gear[3].get(0) == 1) ans += 4;
		if((int)gear[4].get(0) == 1) ans += 8;
		System.out.println(ans);
	}

	private static boolean[] checkPole(int n){ 
		boolean[] arr = new boolean[5];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(n);
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			arr[p] = true;
			
			int left = p-1;
			if(left>0 && !arr[left] && gear[left].get(2) != gear[p].get(6)) {
				queue.offer(left);
				dir[left] = (dir[p] == -1) ? 1 : -1;
			}
			
			int right = p+1;
			if(right<=4 && !arr[right] && gear[p].get(2) != gear[right].get(6)) {
				queue.offer(right);
				dir[right] = (dir[p] == -1) ? 1 : -1;
			}
		}
		return arr;
	}

	private static void rotateGear(int num, int dir) {
		if (dir == -1) { // 반시계방향
			int p = (int) gear[num].remove(0);
			gear[num].add(p);
		} else { // 시계 방향
			int p = (int)gear[num].remove(7);
			gear[num].add(0, p);
		}

	}

}
