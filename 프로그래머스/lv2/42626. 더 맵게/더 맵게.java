import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer;
        
        for (int s : scoville) pq.add(s);
        for (answer = 0; pq.size() >= 2 && pq.peek() < K; answer++)
            pq.add(pq.remove() + pq.remove() * 2);
        if (pq.peek() < K) return -1;
        return answer;
    }
}