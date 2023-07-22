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
        int i = 0;
        
        len = name.length();
        q.add(moveUD(new Node(new StringBuilder(name), 0, 0)));
        while (!q.isEmpty())
            moveLR(q.remove());
        return answer;
    }
    
    //Queue에 해당 노드가 좌우로 움직일 경우 추가
    //이름이 완성됐다면 answer 업데이트 후 return
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
    
    //해당 노드 상하 조작
    private Node moveUD(Node node){
        int c = (int)node.name.charAt(node.idx);
        node.name.setCharAt(node.idx, 'A');
        node.mv += Math.min(c-'A', 'Z'-c+1);
        return node;
    }
}