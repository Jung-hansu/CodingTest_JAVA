import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[photo.length];
        for (int i = 0; i < name.length; i++)
            map.put(name[i], yearning[i]);
        for (int i = 0; i < photo.length; i++){
            int sum = 0;
            for (String person : photo[i])
                sum += map.getOrDefault(person, 0);
            answer[i] = sum;
        }
        return answer;
    }
}