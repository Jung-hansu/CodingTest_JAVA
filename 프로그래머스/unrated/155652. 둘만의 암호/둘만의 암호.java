import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        List<Character> alpha = new LinkedList<>();
        String answer = "";
        
        for (char c = 'a'; c <= 'z'; c++) alpha.add(c);
        for (char c : skip.toCharArray()) alpha.remove((Character)c);
        for (char c : s.toCharArray())
            answer += alpha.get((alpha.indexOf(c)+index)%alpha.size());
        return answer;
    }
}