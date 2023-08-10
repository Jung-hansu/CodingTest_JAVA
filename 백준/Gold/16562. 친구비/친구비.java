import java.io.*;
import java.util.*;

public class Main {
	private static int[] parent;
	private static int[] cost;

	private static void union(int f1, int f2){
		int x = find(f1), y = find(f2);

		if (cost[x] > cost[y]) parent[x] = y;
		else parent[y] = x;
	}

	private static int find(int f){
		if (parent[f] == f) return f;
		return find(parent[f]);
	}

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> leaders = new HashSet<>();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken()), minCost = 0;

		cost = new int[N+1];
		parent = new int[N+1];
        st = new StringTokenizer(br.readLine());
	    for (int i = 1; i <= N; i++) cost[i] = Integer.parseInt(st.nextToken());
	    for (int i = 1; i <= N; i++) parent[i] = i;
                                
		//Unionizing
		while (M-- > 0){
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		//Gathering the cheapest friend of the group
		for (int f : parent) leaders.add(find(f));

	    for (int f : leaders) minCost += cost[f];
	    System.out.println(money >= minCost ? minCost : "Oh no");
    }
}