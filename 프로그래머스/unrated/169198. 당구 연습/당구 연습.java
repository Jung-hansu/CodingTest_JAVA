import java.util.*;

class Solution {
	public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
		int[] answer = new int[balls.length];
		for (int i = 0; i < balls.length; i++){
			int min = Integer.MAX_VALUE;
			if (balls[i][0] >= startX || balls[i][1] != startY)
				min = Math.min(distance_sqr(-startX, startY, balls[i]), min);
			if (balls[i][0] <= startX || balls[i][1] != startY)
				min = Math.min(distance_sqr(2*m-startX, startY, balls[i]), min);
			if (balls[i][0] != startX || balls[i][1] >= startY)
				min = Math.min(distance_sqr(startX, -startY, balls[i]), min);
			if (balls[i][0] != startX || balls[i][1] <= startY)
				min = Math.min(distance_sqr(startX, 2*n-startY, balls[i]), min);
			answer[i] = min;
		}
		return answer;
	}

	private int distance_sqr(int sX, int sY, int[] ball){
		return (sX-ball[0])*(sX-ball[0]) + (sY-ball[1])*(sY-ball[1]);
	}
}