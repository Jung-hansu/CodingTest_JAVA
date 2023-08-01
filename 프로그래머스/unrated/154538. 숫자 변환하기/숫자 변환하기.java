import java.util.*;

class Solution {
	public int solution(int x, int y, int n) {
		Queue<Integer> q = new LinkedList<>();
        
        q.add(y);
        if (x == y) return 0;
        for (int answer = 1; !q.isEmpty(); answer++)
            for (int i = q.size(); i > 0; i--){
                int tmp = q.remove();
                if ((tmp/3.0) == x || (tmp/2.0) == x || tmp-n == x) return answer;
                
                if (tmp%3 == 0 && x < tmp/3) q.add(tmp/3);
                if (tmp%2 == 0 && x < tmp/2) q.add(tmp/2);
                if (x < tmp-n) q.add(tmp-n);
            }
        return -1;
	}
}