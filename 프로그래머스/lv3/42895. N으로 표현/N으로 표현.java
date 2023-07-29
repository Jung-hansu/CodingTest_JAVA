import java.util.*;

class Solution {
	public int solution(int N, int number) {
		Set<Integer>[] nums = new Set[9];

		for (int i = 1; i <= 8; i++){
			nums[i] = new HashSet<>();
			nums[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));
			for (int n = 1; n <= i/2; n++)
				for (int n1 : nums[n])
					for (int n2 : nums[i-n]) {
						nums[i].add(n1 + n2);
						nums[i].add(n1 * n2);
						nums[i].add(n1 - n2);
						nums[i].add(n2 - n1);
						if (n2 != 0) nums[i].add(n1 / n2);
						if (n1 != 0) nums[i].add(n2 / n1);
					}
			if (nums[i].contains(number)) return i;
		}
		return -1;
	}
}