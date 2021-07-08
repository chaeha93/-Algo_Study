import java.io.*;
import java.util.*;

public class Main_백준_16198_에너지모으기 {

	private static int N;
	private static ArrayList<Integer> list;
	public static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 에너지 구슬의 개수
		list = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		gatherEnergy(0);
		System.out.println(max);
	}

	private static void gatherEnergy(int weight) {
		if (list.size() <= 2) { // list.size() <= 2 라는 건 더 이상 가운데에 제거할 구슬이 없음
			if (max < weight) {
				max = weight;
			}
			return;
		}
		for (int i = 1; i < list.size() - 1; i++) { // 맨 앞, 맨 뒤는 고를 수 없으니 
			int sum = 0;
			sum += list.get(i - 1) * list.get(i + 1); // 제거하고자 하는 것 왼쪽 오른쪽 에너지를 구하고
			int num = list.get(i); // list에 복귀시켜줄 i번째 num 저장
			list.remove(i);
			gatherEnergy(weight + sum);
			list.add(i, num); // list 복귀
		}

	}

}
