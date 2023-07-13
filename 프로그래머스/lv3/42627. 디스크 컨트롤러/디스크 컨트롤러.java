import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o->o[1]));
        int total = 0, i = 0, time = 0;
        
        Arrays.sort(jobs, Comparator.comparing(o->o[0]));
        while (i < jobs.length || !pq.isEmpty()) {
            while (i < jobs.length && time >= jobs[i][0]) pq.add(jobs[i++]);
            if (pq.isEmpty()) time = jobs[i][0];
            else{
                time += pq.peek()[1];
                total += time - pq.remove()[0];
            }
        }
        return total / jobs.length;
    }
}