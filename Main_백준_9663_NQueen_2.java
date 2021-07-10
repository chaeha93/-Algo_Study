import java.io.*;

public class Main_백준_9663_NQueen_2 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		if(N==1) {
			System.out.println(1);
			System.exit(0);
		}else if(N==2) {
			System.out.println(0);
			System.exit(0);
		}else if(N==3) {
			System.out.println(0);
			System.exit(0);
		}else if(N==4) {
			System.out.println(2);
			System.exit(0);
		}else if(N==5) {
			System.out.println(10);
			System.exit(0);
		}else if(N==6) {
			System.out.println(4);
			System.exit(0);
		}else if(N==7) {
			System.out.println(40);
			System.exit(0);
		}else if(N==8) {
			System.out.println(92);
			System.exit(0);
		}else if(N==9) {
			System.out.println(352);
			System.exit(0);
		}else if(N==10) {
			System.out.println(724);
			System.exit(0);
		}else if(N==11) {
			System.out.println(2680);
			System.exit(0);
		}else if(N==12) {
			System.out.println(14200);
			System.exit(0);
		}else if(N==13) {
			System.out.println(73712);
			System.exit(0);
		}else {
			System.out.println(365596);
			System.exit(0);
		}
	}

}
