import java.io.*;
import java.util.*;

public class Solution { 
	
	private static boolean isClosing(char c) {
		return c == ')' || c == '}' || c == ']' || c == '>';
	}
	
	private static boolean isMatched(char c1, char c2) {
		return c1 == '(' && c2 == ')' || c1 == '{' && c2 == '}' ||
				c1 == '[' && c2 == ']' || c1 == '<' && c2 == '>';
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

    a:  for (int tc = 1; tc <= 10; tc++) {
        	Stack<Character> stack = new Stack<>();
        	int N = Integer.parseInt(br.readLine());
        	String s = br.readLine();
        	        	
        	for (int i = 0; i < N; i++) {
        		
        		if (!stack.isEmpty() && isClosing(s.charAt(i))) { 
    				if (!isMatched(stack.peek(), s.charAt(i))) {
    					sb.append('#').append(tc).append(" 0\n");
    					continue a;
    				}
					stack.pop();
        		}
        		else {
        			stack.push(s.charAt(i));
        		}
        		
        	}
        	sb.append('#').append(tc).append(" 1\n");
        }
        System.out.println(sb);
    }
	
}
