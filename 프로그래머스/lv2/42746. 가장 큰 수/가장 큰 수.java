import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        String answer = "";
        
        Arrays.sort(nums, (o1,o2) -> Integer.parseInt(""+o2+o1) - Integer.parseInt(""+o1+o2));
        for (int num : nums) answer += num;
        if (answer.charAt(0) == '0')
            return "0";
        return answer;
    }
}