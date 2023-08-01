import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[numbers.length];
        
        Arrays.fill(ret, -1);
        for (int i = 0; i < numbers.length; i++){
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i])
                ret[stack.pop()] = numbers[i];
            stack.push(i);
        }
        return ret;
    }
}