import java.util.*;

class Solution {
	public int[] solution(int []arr) {
		Stack<Integer> stack = new Stack<>();
		int[] answer;
		
		for (int n : arr)
			if (stack.isEmpty() || n != stack.peek()) stack.push(n);
		answer = new int[stack.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = stack.get(i);
		return answer;
	}
}