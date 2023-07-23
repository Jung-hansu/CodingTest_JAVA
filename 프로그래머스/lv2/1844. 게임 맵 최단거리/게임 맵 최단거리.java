import java.util.*;

class Solution {
	public int solution(int[][] maps) {
		Queue<int[]> q = new LinkedList<>();
		int answer = 0, size, n = maps.length, m = maps[0].length;

		q.add(new int[]{0, 0});
		while (!q.isEmpty()){
			size = q.size();
			answer++;
			for (int i = 0; i < size; i++){
				int[] tmp = q.remove();
				if (tmp[0] == n-1 && tmp[1] == m-1) return answer;
				if (tmp[0] > 0 && maps[tmp[0]-1][tmp[1]] == 1){
					maps[tmp[0]-1][tmp[1]] = 0;
					q.add(new int[]{tmp[0]-1,tmp[1]});}
				if (tmp[1] > 0 && maps[tmp[0]][tmp[1]-1] == 1){
					maps[tmp[0]][tmp[1]-1] = 0;
					q.add(new int[]{tmp[0],tmp[1]-1});}
				if (tmp[0] < n-1 && maps[tmp[0]+1][tmp[1]] == 1){
					maps[tmp[0]+1][tmp[1]] = 0;
					q.add(new int[]{tmp[0]+1,tmp[1]});}
				if (tmp[1] < m-1 && maps[tmp[0]][tmp[1]+1] == 1){
					maps[tmp[0]][tmp[1]+1] = 0;
					q.add(new int[]{tmp[0],tmp[1]+1});}
			}
		}
		return -1;
	}
}