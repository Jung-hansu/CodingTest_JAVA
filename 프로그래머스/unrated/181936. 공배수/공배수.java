class Solution {
    public int solution(int number, int n, int m) {
        return number%n + number%m == 0 ? 1 : 0;
    }
}