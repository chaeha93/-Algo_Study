import java.io.*;

public class Main_백준_10994_별찍기19 {
	
	private static String[] str;
	public static int range, index;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 1 <= N <= 100
		range = (2*N) - 1;
		str = new String[range];
		printStar(1, (4*N)-3); // 몇 번째 줄인지, rule
		for(int i=0; i<range; i++) {
			sb.append(str[i]).append("\n");
		}
		for(int i=range-2; i>=0; i--) {
			sb.append(str[i]).append("\n");
		}
		System.out.println(sb);
	}

	private static void printStar(int row, int rule) {
		String s = "";
		if(row == range) {
			for(int i=1; i<=row; i++) {
				s += "* ";
			}
			str[index++] = s; 
			return;
		}
		if(row % 2 == 1) { // 홀수 줄
			for(int i=1; i<=row/2; i++) {
				s += "* ";
			}
			for(int i=1; i<=rule; i++) {
				s += "*";
			}
			for(int i=1; i<=row/2; i++) {
				s += " *";
			}
			rule -= 4;
		} else { // 짝수 줄
			for(int i=1; i<=row/2; i++) {
				s += "* ";
			}
			for(int i=1; i<=rule; i++) {
				s += " ";
			}
			for(int i=1; i<=row/2; i++) {
				s += " *";
			}
		}
		str[index++] = s;
		printStar(row+1, rule);
	}
}
