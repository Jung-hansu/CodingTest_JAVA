import java.util.*;

class Solution {
	private int answer = 0;
	public int solution(int n) {
		int star = (int)(Math.log(n)/Math.log(3)), plus = 2 * star, sum;
		int[] ternary = new int[star + 1];

		for (int i = ternary.length - 1; i >= 0; i--, n /= 3)
			ternary[i] = n%3;

		sum = Arrays.stream(ternary).sum();
		if (ternary[0] != 1 || (plus - sum) % 2 == 0) return 0;
		getDupComb(ternary, (plus-sum+1)/2, 1);
		return answer;
	}

	private void getDupComb(int[] ternary, int times, int i){
		if (times == 0){
			if (ternary[ternary.length-1] >= 2) answer++;
			return;
		}
		if (i == ternary.length-1) return;

		getDupComb(ternary, times, i+1);
		int[] tmp = ternary.clone();
		while (tmp[i] > 0 && times > 0) {
			times--;
		    tmp[i]--;
		    tmp[i+1] += 3;
			if (isAble(tmp))
				getDupComb(tmp, times, i+1);
		}
	}

	private boolean isAble(int[] ternary){
		int plus = 2;
		for (int i = 1; i < ternary.length; i++){
			if (ternary[i] > plus) return false;
			plus = plus - ternary[i] + 2;
		}
		return true;
	}
}