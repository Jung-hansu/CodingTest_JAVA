import java.io.*;
import java.util.*;

public class Main {
    private static int[][] field;
    private static List<Group> groups1 = new ArrayList<>();
    private static List<Group> groups2 = new ArrayList<>();
    private static class Group{
        public Set<Integer> blanks = new HashSet<>();
        public int member = 0;

        //빈칸 좌표 flatten
        public void addBlanks(int i, int j) {
            blanks.add(i * field.length + j);
        }
    }

    private static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        Group g = new Group();

        field[i][j] = 3;
        q.add(new int[]{i, j});
        while (!q.isEmpty()){
            int[] tmp = q.remove();

            //bfs하면서 해당 그룹 멤버 수 및 주변 빈칸 좌표 기록
            g.member++;
            if (tmp[0] > 0) {
                int n = field[tmp[0]-1][tmp[1]];
                if (n == 0) g.addBlanks(tmp[0]-1, tmp[1]);
                if (n == 2) {
                    field[tmp[0]-1][tmp[1]] = 3;
                    q.add(new int[]{tmp[0]-1, tmp[1]});
                }}
            if (tmp[1] > 0){
                int n = field[tmp[0]][tmp[1]-1];
                if (n == 0) g.addBlanks(tmp[0], tmp[1]-1);
                if (n == 2) {
                    field[tmp[0]][tmp[1]-1] = 3;
                    q.add(new int[]{tmp[0], tmp[1]-1});
                }}
            if (tmp[0] < field.length-1){
                int n = field[tmp[0]+1][tmp[1]];
                if (n == 0) g.addBlanks(tmp[0]+1, tmp[1]);
                if (n == 2){
                    field[tmp[0]+1][tmp[1]] = 3;
                    q.add(new int[]{tmp[0]+1, tmp[1]});
                }}
            if (tmp[1] < field[0].length-1){
                int n = field[tmp[0]][tmp[1]+1];
                if (n == 0) g.addBlanks(tmp[0], tmp[1]+1);
                if (n == 2){
                    field[tmp[0]][tmp[1]+1] = 3;
                    q.add(new int[]{tmp[0], tmp[1]+1});
                }}
        }
        if (g.blanks.size() == 1) groups1.add(g); //빈칸이 하나인 그룹
        if (g.blanks.size() == 2) groups2.add(g); //빈칸이 두개인 그룹
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), max = 0;

        field = new int[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                field[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (field[i][j] == 2)
                    bfs(i, j);

        //빈칸 두개짜리 그룹 기준
        for (int i = 0; i < groups2.size(); i++) {
            int mems = groups2.get(i).member;

            //한 그룹을 먹었을 때 저절로 따이는 돌의 수 계산
            for (int j = i + 1; j < groups2.size(); j++)
                if (groups2.get(i).blanks.containsAll(groups2.get(j).blanks))
                    mems += groups2.get(j).member;
            for (Group g : groups1)
                if (groups2.get(i).blanks.containsAll(g.blanks))
                    mems += g.member;
            max = Math.max(max, mems);
        }

        //빈칸 하나짜리 그룹 기준
        for (int i = 0; i < groups1.size(); i++){
            boolean[] check = new boolean[groups1.size()];
            int mems = groups1.get(i).member;

            //저절로 따이는 돌의 수 계산
            check[i] = true;
            for (int j = i+1; j < groups1.size(); j++){
                if (groups1.get(i).blanks.containsAll(groups1.get(j).blanks)) {
                    check[j] = true;
                    mems += groups1.get(j).member;
                }
            }
            //따이지 않은 한 그룹 더 선택해서 같은 작업 수행
            int max2 = 0;
            for (int j = 0; j < groups1.size(); j++)
                if (!check[j]) {
                    int mems2 = groups1.get(j).member;
                    for (int k = j + 1; k < groups1.size(); k++)
                        if (!check[k] && groups1.get(i).blanks.containsAll(groups1.get(k).blanks))
                            mems2 += groups1.get(k).member;
                    max2 = Math.max(max2, mems2);
                }
            max = Math.max(max, mems+max2);
        }
        System.out.println(max);
    }
}
