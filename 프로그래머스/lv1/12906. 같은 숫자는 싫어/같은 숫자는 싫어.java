import java.util.*;

class Solution {
	public int[] solution(int []arr) {
		Stack<Integer> stack = new Stack<>();
		for (int n : arr)
			if (stack.isEmpty() || n != stack.peek()) stack.push(n);
		return stack.stream().mapToInt(Integer::intValue).toArray();
	}
}