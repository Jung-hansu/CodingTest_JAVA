import java.io.*;
import java.util.*;

public class Main {
    private static List<Character>[] list;
    private static boolean bfs(boolean[][] check, int i, int j){
        List<int[]> trash = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        char c = list[i].get(j);

        //뭉쳐있는 동일한 블럭의 갯수 파악
        q.add(new int[]{i, j});
        check[i][j] = true;
        while (!q.isEmpty()){
            int[] tmp = q.remove();

            trash.add(tmp);
            if (tmp[0] > 0 && list[tmp[0]-1].size()-1 >= tmp[1] &&
                    !check[tmp[0]-1][tmp[1]] && list[tmp[0]-1].get(tmp[1]) == c){
                check[tmp[0]-1][tmp[1]] = true;
                q.add(new int[]{tmp[0]-1, tmp[1]});}
            if (tmp[0] < 5 && list[tmp[0]+1].size()-1 >= tmp[1] &&
                    !check[tmp[0]+1][tmp[1]] && list[tmp[0]+1].get(tmp[1]) == c){
                check[tmp[0]+1][tmp[1]] = true;
                q.add(new int[]{tmp[0]+1, tmp[1]});}
            if (tmp[1] > 0 &&
                    !check[tmp[0]][tmp[1]-1] && list[tmp[0]].get(tmp[1]-1) == c){
                check[tmp[0]][tmp[1]-1] = true;
                q.add(new int[]{tmp[0], tmp[1]-1});}
            if (tmp[1] < list[tmp[0]].size()-1 &&
                    !check[tmp[0]][tmp[1]+1] && list[tmp[0]].get(tmp[1]+1) == c){
                check[tmp[0]][tmp[1]+1] = true;
                q.add(new int[]{tmp[0], tmp[1]+1});}
        }
        if (trash.size() >= 4) {
            //4개 이상 뭉친 블럭들이 있다면 해당 블럭들을 모두 '0'으로 표시
            for (int[] tmp : trash) list[tmp[0]].set(tmp[1], '0');
            return true;
        }
        return false;
    }
    private static int puyo(){
        for (int cnt = 0; ; cnt++) {
            boolean[][] check = new boolean[6][12];
            boolean flag = false;

            //현재 필드의 모든 블럭들에 대해 bfs 실행
            for (int i = 0; i < 6; i++)
                for (int j = 0; j < list[i].size(); j++)
                    if (!check[i][j] && list[i].get(j) != '.')
                        flag |= bfs(check, i, j);

            //터지는 블럭이 있다면 '0'들을 모두 터트림
            if (flag)
                for (List<Character> l : list)
                    l.removeIf(c -> c == '0');
            //터질 수 있는 뭉치가 없다면 횟수 반환
            else return cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] field = new String[12];

        list = new LinkedList[6];
        for (int i = 0; i < 12; i++) field[i] = br.readLine();
        for (int j = 0; j < 6; j++){
            list[j] = new LinkedList<>();
            for (int i = 11; i >= 0; i--)
                if (field[i].charAt(j) != '.')
                    list[j].add(field[i].charAt(j));
        }
        System.out.println(puyo());
    }
}
