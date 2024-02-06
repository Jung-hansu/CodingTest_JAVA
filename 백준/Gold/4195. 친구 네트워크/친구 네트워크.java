import java.io.*;
import java.util.*;

class Main {
	
	/** 해당 노드가 루트일 때의 네트워크 크기(subtree 노드 수) */
	private static int[] networkSize;
	private static int[] parent;
	
	/** Union 연산 후 합쳐진 네트워크 크기(tree 노드 수) 반환 */
	private static int union(int a, int b) {
		int x = find(a), y = find(b);
		
		if (x == y) {
			return networkSize[x];
		}
		parent[Math.max(x, y)] = Math.min(x, y);
		return networkSize[Math.min(x, y)] += networkSize[Math.max(x, y)];
	}
	
	private static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			Map<String, Integer> map = new HashMap<>();
			int F = Integer.parseInt(br.readLine()), cnt = 0;
			
			//initialize
			parent = new int[2 * F + 1];
			networkSize = new int[2 * F + 1];
			for (int i = 0; i <= 2 * F; i++) {
				networkSize[i] = 1;
				parent[i] = i;
			}
			
			//union-find
			for (int i = 0; i < F; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken(), f2 = st.nextToken();
				
				if (!map.containsKey(f1)) {
					map.put(f1, cnt++);
				}
				if (!map.containsKey(f2)) {
					map.put(f2, cnt++);
				}
				
				sb.append(union(map.get(f1), map.get(f2))).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
}