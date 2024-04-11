import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int a = 0, b = 0, c = 0, res = 0;

        while (c < s.length()){
            while(b < s.length() && s.charAt(b) != 'B'){
                b++;
            }
            while(c < s.length() && (c < b || s.charAt(c) != 'C')){
                c++;
            }

            if (c < s.length()) {
                b++;
                c++;
                res++;
            }
        }

        while (b < s.length()){
            while (a < s.length() && s.charAt(a) != 'A'){
                a++;
            }
            while(b < s.length() && (b < a || s.charAt(b) != 'B')){
                b++;
            }

            if (b < s.length()) {
                a++;
                b++;
                res++;
            }
        }
        System.out.println(res);
    }

}