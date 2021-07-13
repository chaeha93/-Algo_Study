import java.io.*;
import java.util.*;

public class Main_백준_3967_매직스타 {

	private static StringBuilder sb;
	private static char[][] arr;
	private static ArrayList<int[]> list;
	private static boolean[] alphabet;
	private static boolean flag;
	private static int[][][] star = { { { 0, 4 }, { 1, 3 }, { 2, 2 }, { 3, 1 } }, { { 0, 4 }, { 1, 5 }, { 2, 6 }, { 3, 7 } },
			{ { 1, 1 }, { 1, 3 }, { 1, 5 }, { 1, 7 } }, { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 } },
			{ { 1, 7 }, { 2, 6 }, { 3, 5 }, { 4, 4 } }, { { 3, 1 }, { 3, 3 }, { 3, 5 }, { 3, 7 } } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		arr = new char[5][9];
		list = new ArrayList<int[]>();
		alphabet = new boolean[13];
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == 'x') { // 채워야 할 대상
					list.add(new int[] { i, j });
				} else if (arr[i][j] != '.') {
					alphabet[(int) arr[i][j] - 64] = true;
				}
			}
		}

		setMagicStar(0);
		System.out.println(sb);
	}

	private static void setMagicStar(int cnt) {
		if(flag) return;
		if(cnt == list.size() && isAvailable()) {
			flag = true;
			for(int i=0; i<5; i++) {
				for(int j=0; j<9; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			return;
		}
		for(int i=1; i<=12; i++) {
			if(!alphabet[i]) {
				int[] p = list.get(cnt);
				arr[p[0]][p[1]] = (char)(i+64);
				alphabet[i] = true;
				setMagicStar(cnt+1);
				alphabet[i] = false;
			}
		}
	}

	private static boolean isAvailable() {
		for(int i=0; i<6; i++) {
			int sum = 0;
			for(int j=0; j<4; j++) {
				sum += (int)(arr[star[i][j][0]][star[i][j][1]] - 64);
			}
			if(sum != 26) return false;
		}
		return true;
	}
}