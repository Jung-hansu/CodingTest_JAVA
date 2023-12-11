import java.util.stream.IntStream;
class Solution {
    public int[] solution(String s) {
        int[] arr = new int[52];
        IntStream.range(0, s.length()).forEach(i->arr[s.charAt(i)-(s.charAt(i)<'a'?'A':'a'-26)]++);
        return arr;
    }
}