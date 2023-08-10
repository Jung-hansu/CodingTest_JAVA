import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0){
            String tmp = br.readLine();
            if (list.isEmpty() || !list.contains(tmp))
                list.add(tmp);
        }
        list.sort((s1, s2) -> s1.length() != s2.length() ? s1.length() - s2.length() : s1.compareTo(s2));
        for (String s : list) System.out.println(s);
    }
}