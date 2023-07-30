import java.util.*;

class Solution {
	private int answer = 0;
	public int solution(int n) {
		int star = (int)(Math.log(n)/Math.log(3)), plus = 2 * star, sum;
		int[] ternary = new int[star + 1];

		//n을 3진법으로 변환
		//*로 시작하여 2번째 자리부터 숫자만큼 +, 자릿수가 넘어갈 때 *
		//Ex) 41_(10) = 1112_(3) ->> "*+*+*++"
		for (int i = ternary.length - 1; i >= 0; i--, n /= 3)
			ternary[i] = n%3;

		//첫 자리 숫자가 1이어야 함 (아닐 시 *로 시작하지 않고 +로 시작함)
		//(각 자리 숫자의 합 - 1) = (필요 '+'의 개수) 이어야 함
		sum = Arrays.stream(ternary).sum();
		if (ternary[0] != 1 || (plus - sum) % 2 == 0) return 0;
		//자릿수를 내리며 총 '+'의 수(sum-1)을 필요 '+'의 수(plus)와 같아지게 하는 경우의 수를 구함
		getDupComb(ternary, (plus-sum+1)/2, 1);
		return answer;
	}

	//3진수의 양 끝 자리가 아닌 자리들을 times만큼 내림하는 경우의 수
	//i는 내림하는 자릿수
	private void getDupComb(int[] ternary, int times, int i){
		//가장 뒷자리 숫자가 2 이상인 경우에만 정답
		if (times == 0){
			if (ternary[ternary.length-1] >= 2) answer++;
			return;
		}
		//다 선택하지 못했는데 탐색이 끝난 경우 탈출
		if (i == ternary.length-1) return;

		//i번째 자리를 내림 하지 않는 경우
		getDupComb(ternary, times, i+1);
		//i번째 자리를 내림 하는 경우
		int[] tmp = ternary.clone();
		while (tmp[i] > 0 && times > 0) {
			times--;
			downGrading(tmp, i);
			if (isAble(tmp))
				getDupComb(tmp, times, i+1);
		}
	}

	//매 자릿수별 plus의 개수가 가능한 수인지 확인
	//자릿수마다 (plus -= 해당 '+'의 수), 자릿수가 넘어갈 때 마다 (plus += 2)
	private boolean isAble(int[] ternary){
		int plus = 2;
		for (int i = 1; i < ternary.length; i++){
			if (ternary[i] > plus) return false;
			plus = plus - ternary[i] + 2;
		}
		return true;
	}

	//3진수의 i번째 자릿수를 i-1번째 자릿수로 내림 (ex. 10210_(3) -> 10203_(3))
	private void downGrading(int[] ternary, int i){
		ternary[i]--;
		ternary[i+1] += 3;
	}
}