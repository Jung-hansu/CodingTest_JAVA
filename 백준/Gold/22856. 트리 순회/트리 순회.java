import java.io.*;
import java.util.*;

class Tree{

    private class Node{
        public Node lc, rc;
    }

    private int circuitCnt; //이동 횟수
    private int visitedCnt; //(중위 순회시)방문 노드 수
    private int size;
    private Node[] nodes;

    public Tree(int size) {
        this.size = size;
        nodes = new Node[size + 1];

        for (int i = 1; i <= size; i++)
            nodes[i] = new Node();
    }

    public void addChildren(int parent, int lc, int rc) {
        nodes[parent].lc = (lc > 0 ? nodes[lc] : null);
        nodes[parent].rc = (rc > 0 ? nodes[rc] : null);
    }

    /** 메인 알고리즘을 담은 Wrapping 메소드 */
    public int getCircuitCnt() {
        //루트에서 출발할 때(메소드가 시작할 때)의 움직임 고려
        this.circuitCnt = -1;
        this.visitedCnt = 0;

        pseudoInorderCircuit(nodes[1]);
        return this.circuitCnt;
    }

    /** 메인 알고리즘 */
    private void pseudoInorderCircuit(Node node){
        if (node == null){
            return;
        }

        //들어갈 때 체크
        circuitCnt++;
        
        pseudoInorderCircuit(node.lc);
        if (visitedCnt++ == size) return; //중위 순회 종료 조건
        pseudoInorderCircuit(node.rc);
        
        //나갈 때 체크(순회 종료시 실행 X)
        if (visitedCnt < size)
            circuitCnt++;
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree(N);

        //parsing
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()),
                    lc = Integer.parseInt(st.nextToken()),
                    rc = Integer.parseInt(st.nextToken());
            tree.addChildren(parent, lc, rc);
        }

        System.out.println(tree.getCircuitCnt());
    }

}
