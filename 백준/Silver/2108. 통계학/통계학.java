import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> map = new TreeMap<>();
        List<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine()), sum = 0, max = 0, smax = 0, s = -5000;
        boolean flag = true;

        for (int i = 0; i < N; i++){
            int tmp = Integer.parseInt(br.readLine());
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
            list.add(tmp);
            sum += tmp;
        }
        for (int n : map.keySet())
            if (max <= map.get(n)){
                max = map.get(n);
                if (smax < max){
                    smax = max;
                    s = n;
                    flag = true;}
                else if (flag && smax == max){
                    s = n;
                    flag = false;}
            }
        list.sort(Comparator.naturalOrder());
        bw.write((int)Math.round((double)sum/N)+"\n");
        bw.write(list.get(list.size()/2)+"\n");
        bw.write(s+"\n");
        bw.write(list.get(list.size()-1)-list.get(0)+"\n");
        bw.close();
    }
}