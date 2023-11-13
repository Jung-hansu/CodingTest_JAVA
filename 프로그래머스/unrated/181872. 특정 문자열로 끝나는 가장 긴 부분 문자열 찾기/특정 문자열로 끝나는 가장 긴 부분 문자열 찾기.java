class Solution {
    public String solution(String s, String pat) {
        return s.substring(0,s.lastIndexOf(pat)+pat.length());
    }
}