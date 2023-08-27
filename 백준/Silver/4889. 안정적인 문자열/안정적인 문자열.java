import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1;;i++) {
            String s = br.readLine();
            int op = 0;
            if (s.isEmpty()) bw.write(i+". 0\n");
            else if (s.charAt(0)=='-') break;
            else{
                int open = 0;
                for (int j = 0; j < s.length(); j++) {
                    open += (s.charAt(j) == '{' ? 1 : -1);
                    if (open < 0){
                        op++;
                        open += 2;
                    }
                }
                if (open > 0) op += open/2;
                bw.write(i+". "+op+"\n");
            }
        }
        bw.close();
    }
}