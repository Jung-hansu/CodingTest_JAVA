import java.util.*;

class Solution {
    public String[] solution(String s) {
        return Arrays.stream(s.split("x")).filter(o->!o.isEmpty()).sorted().toArray(String[]::new);
    }
}