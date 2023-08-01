import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<int[]> stack = new Stack<>();
        int[] ret = new int[numbers.length];
        
        Arrays.fill(ret, -1);
        for (int i = 0; i < numbers.length; i++){
            while (!stack.isEmpty() && stack.peek()[0] < numbers[i])
                ret[stack.pop()[1]] = numbers[i];
            stack.push(new int[]{numbers[i], i});
        }
        return ret;
    }
}