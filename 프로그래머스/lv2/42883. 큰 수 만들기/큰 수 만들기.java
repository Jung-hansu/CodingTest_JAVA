class Solution {
	public String solution(String number, int k) {
		StringBuilder ans = new StringBuilder(number);
		int i = 0;

		while (k > 0) {
			if (i == ans.length()-1 || ans.charAt(i) < ans.charAt(i+1)) {
				ans.deleteCharAt(i);
				i = Math.max(i-1, 0);
				k--;
			}
			else i++;
		}
		return ans.toString();
	}
}