import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean flag = true;
        int res = 0;

        for (int i = 0; i < s.length(); i++){
            int num = 0;
            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9')
                num = num * 10 + s.charAt(i++) - '0';
            res += (flag ? num : -num);
            if (i < s.length() && s.charAt(i) == '-') flag = false;
        }
        System.out.println(res);
    }
}