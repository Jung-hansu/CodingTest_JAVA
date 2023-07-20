import java.util.*;

class Solution {
	private Set<String> primes = new HashSet<>();
	private boolean[] check;
	private String numbers;
	public int solution(String numbers) {
		this.numbers = numbers;
		check = new boolean[numbers.length()];
		
		dfs("");
		return primes.size();
	}

	private void dfs(String nums){
		if (!nums.equals("") && nums.charAt(0)=='0') return;
		if (!nums.equals("") && isPrime(nums)) primes.add(nums);

		for (int i = 0; i < numbers.length(); i++)
			if (!check[i]) {
				check[i] = true;
				dfs(nums + numbers.charAt(i));
				check[i] = false;
			}
	}

	private boolean isPrime(String nums){
		int n = Integer.parseInt(nums);

		if (n == 1) return false;
		for (int i = 2; i * i <= n; i++)
			if (n % i == 0)
				return false;
		return true;
	}
}