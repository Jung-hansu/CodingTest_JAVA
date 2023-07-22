import java.util.*;

class Solution {
    private Queue<Node> q = new LinkedList<>();
    private int len, answer = Integer.MAX_VALUE;
    private class Node{
        public StringBuilder name;
        public int idx, mv;
        public Node(StringBuilder name, int idx, int mv){
            this.name = new StringBuilder(name);
            this.idx = idx;
            this.mv = mv;
        }
    }
    public int solution(String name) {
        Node tmp;
        int i = 0;
        
        len = name.length();
        q.add(moveUD(new Node(new StringBuilder(name), 0, 0)));
        while (!q.isEmpty())
            moveLR(q.remove());
        return answer;
    }
    
    private void moveLR(Node node){
        int l, r, mvL = 0, mvR = 0;
        for (l = node.idx; node.name.charAt(l) == 'A'; l = (l-1+len)%len)
            if (++mvL >= len){
                answer = Math.min(answer, node.mv);
                return;
            }
        for (r = node.idx; node.name.charAt(r) == 'A'; r = (r+1)%len)
            ++mvR;
        
        q.add(moveUD(new Node(node.name, l, node.mv + mvL)));
        q.add(moveUD(new Node(node.name, r, node.mv + mvR)));
    }
    
    private Node moveUD(Node node){
        Node res = new Node(node.name, node.idx, node.mv);
        int c = (int)res.name.charAt(res.idx);
        
        res.name.setCharAt(res.idx, 'A');
        res.mv += Math.min(c-'A', 'Z'-c+1);
        return res;
    }
}