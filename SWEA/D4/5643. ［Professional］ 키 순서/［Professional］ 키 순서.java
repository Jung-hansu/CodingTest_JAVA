import java.io.*;
import java.util.*;

public class Solution {
	
	private static Node[] inNodes, outNodes;
	private static int N;
	
	private static class Node{
		List<Node> next = new ArrayList<>();
		BitSet knowns = new BitSet();
		int inDegree;
		
		public Node(int n) {
			knowns.set(n);
		}
	}
	
	private static boolean canKnow(int n) {
		return inNodes[n].knowns.cardinality() 
				+ outNodes[n].knowns.cardinality() == N + 1;
	}
	
	private static void topologicalTravel(Node[] nodes) {
		Queue<Node> q = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			if (nodes[i].inDegree == 0) {
				q.add(nodes[i]);
			}
		}
		
		while (!q.isEmpty()) {
			Node node = q.remove();
			
			for (Node next : node.next) {
				next.knowns.or(node.knowns);
				next.inDegree--;
				if (next.inDegree == 0) {
					q.add(next);
				}
			}
		}
	}
	
	private static int getKnownNum() {
		int res = 0;
		
		topologicalTravel(inNodes);
		topologicalTravel(outNodes);
		for (int i = 1; i <= N; i++) {
			if (canKnow(i)) {
				res++;
			}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			inNodes = new Node[N + 1];
			outNodes = new Node[N + 1];
			for (int i = 1; i <= N; i++) {
				inNodes[i] = new Node(i);
				outNodes[i] = new Node(i);
			}
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				inNodes[a].next.add(inNodes[b]);
				inNodes[b].inDegree++;
				outNodes[b].next.add(outNodes[a]);
				outNodes[a].inDegree++;
			}
			
			sb.append('#').append(tc).append(' ').append(getKnownNum()).append('\n');
		}
		System.out.print(sb);
	}

}