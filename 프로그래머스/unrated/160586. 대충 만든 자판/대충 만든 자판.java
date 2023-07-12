import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        int[] answer = new int[targets.length];
        
        for (String key : keymap)
            for (char c : key.toCharArray())
                map.put(c, Math.min(map.getOrDefault(c, 100), key.indexOf(c)+1));
        for (int i = 0; i < targets.length; i++)
            try {
                for (char c : targets[i].toCharArray())
                    answer[i] += map.get(c);
            } catch(NullPointerException e) {
                answer[i] = -1;}
        return answer;
    }
}