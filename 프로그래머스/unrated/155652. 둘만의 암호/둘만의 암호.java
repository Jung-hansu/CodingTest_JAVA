import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder alpha = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        StringBuilder answer = new StringBuilder();
        
        for (char c : skip.toCharArray())
            alpha.deleteCharAt(alpha.indexOf(String.valueOf(c)));
        for (char c : s.toCharArray())
            answer.append(alpha.charAt((alpha.indexOf(String.valueOf(c))+index)%alpha.length()));
        return answer.toString();
    }
}