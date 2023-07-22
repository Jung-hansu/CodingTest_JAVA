class Solution {
	public int[] solution(int brown, int yellow) {
		int h, total = brown + yellow;

		for (h = 3; h * h <= total; h++)
			if ((total/h - 2) * (h - 2) == yellow)
				break;
		return new int[]{total/h, h};
	}
}