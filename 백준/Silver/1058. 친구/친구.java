import java.io.*;
import java.util.*;

public class Main {
    private static int[] friends;
    private static void get2F(String[] adj, int n){
        int[] check = new int[adj.length];

        check[n] = -1;
        for (int i = 0; i < adj.length; i++)
            if (check[i] >= 0 && adj[n].charAt(i) == 'Y'){
                check[i] = 1;
                for (int j = 0; j < adj.length; j++)
                    if (check[j] >= 0 && adj[i].charAt(j) == 'Y')
                        check[j] = 2;
            }
        friends[n] = (int)Arrays.stream(check).filter(i -> i>0).count();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] adj = new String[N];

        friends = new int[N];
        for (int i = 0; i < N; i++) adj[i] = br.readLine();
        for (int i = 0; i < N; i++) get2F(adj, i);
        System.out.println(Arrays.stream(friends).max().getAsInt());
    }
}