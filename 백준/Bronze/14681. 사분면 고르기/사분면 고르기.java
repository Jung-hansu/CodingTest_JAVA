import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine()), y = Integer.parseInt(br.readLine());
        System.out.println(x>0&&y>0 ? 1 : x<0&&y>0 ? 2 : x<0&&y<0 ? 3 : 4);
    }
}
