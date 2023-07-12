class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0, pos = section[0];
        
        for (int s : section)
            if (pos <= s){
                pos = Math.max(pos, s) + m;
                answer++;
            }
        return answer;
    }
}