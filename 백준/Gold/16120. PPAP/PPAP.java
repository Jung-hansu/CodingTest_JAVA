import java.io.*;

public class Main {
    private static boolean isPPAP(String s){
        int P = 1;

        if (s.charAt(0) != 'P' || s.charAt(s.length()-1) != 'P') return false;
        for (int i = 1; P > 0 && i < s.length(); i++)
            if (s.charAt(i) == 'P') P++;
            else if (s.charAt(++i) == 'P') P--;
            else return false;
        return P == 1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(isPPAP(br.readLine()) ? "PPAP" : "NP");
    }
}