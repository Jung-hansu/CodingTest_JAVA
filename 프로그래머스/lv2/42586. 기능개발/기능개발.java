import java.util.*;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answer =  new ArrayList<>();
		int l = 0, r;

		while (l < progresses.length) {
			for (int i = l; i < progresses.length; i++) progresses[i] += speeds[i];
			for (r = 0; l + r < progresses.length && progresses[l+r] >= 100; r++) ;
			if (r > 0) answer.add(r);
			l += r;
		}
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}