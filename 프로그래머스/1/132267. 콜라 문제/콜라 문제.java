class Solution {
    public int solution(int a, int b, int n) {
        return Math.max(n - b, 0) / (a - b) * b;
        
    }
}