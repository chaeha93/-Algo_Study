import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_2101_공유기설치 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 집의 개수
		int C = Integer.parseInt(st.nextToken()); // 공유기의 개수
		int[] house = new int[N];
		for(int i=0; i<N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		
		int left = 1; // 가능한 최소 거리
		int right = house[N-1]-house[0]; // 가능한 최대 거리
		int key = 0;
		int distance = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int start = house[0];
			int cnt = 1;
			
			// 간격(d)를 기준으로 공유기 설치
			for(int i=1; i<N; i++) {
				distance = house[i] - start;
				if(mid <= distance) {
					++cnt;
					start = house[i];
				}
			}
			if(cnt >= C) { // 공유기의 수를 줄이자. => 간격 넓히기
				key = mid;
				left = mid+1;
			}else { // 공유기가 더 설치되어어ㅑ한다. => 간격 좁히기
				right = mid - 1;
			}
			
		}
		System.out.println(key);
	}

}
