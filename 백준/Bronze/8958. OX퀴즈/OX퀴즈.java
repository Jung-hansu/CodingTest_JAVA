import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0){
            String OX = br.readLine();
            int O = 0, score = 0;
            for (int i = 0; i <= OX.length(); i++)
                if (i == OX.length() || OX.charAt(i) == 'X'){
                    score += O * (O+1) / 2;
                    O = 0;
                }
                else O++;
            bw.write(score+"\n");
        }
        bw.flush();
    }
}