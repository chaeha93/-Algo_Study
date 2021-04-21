import java.io.*;
import java.util.*;

// 커서를 변수로 두어 조작하려고 했다. => 시간초과

public class Main_백준_1406_에디터 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> left = new Stack<Character>(); // 커서 기준으로 왼쪽
		Stack<Character> right = new Stack<Character>(); // 커서 기준으로 오른쪽
		String s = br.readLine();
		int s_size = s.length();
		for(int i=0; i<s_size; i++) {
			left.push(s.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int m=0; m<M; m++) {
			String command = br.readLine();
			if(command.contains("L")) {
				if(!left.isEmpty()) right.push(left.pop());
			}else if(command.contains("D")) {
				if(!right.isEmpty()) left.push(right.pop());
			}else if(command.contains("B")) {
				if(!left.isEmpty()) left.pop();
			}else {
				String[] temp = command.split(" ");
				left.push(temp[1].charAt(0));
			}
		}
		while(!right.isEmpty()) {
			left.push(right.pop());
		}
		for(char c : left) {
			sb.append(c);
		}
		System.out.println(sb);
	}
}
