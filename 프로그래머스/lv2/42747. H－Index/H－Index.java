import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int h = 0, len = citations.length;
        
        Arrays.sort(citations);
        for (int i = 1; i <= len && i <= citations[len - i]; i++)
            h = Math.min(i, citations[len - i]);
        return h;
    }
}