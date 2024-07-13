import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(), T = br.readLine();
        int l = 0, r = T.length() - 1;
        boolean revMode = false;

        while (r - l + 1 > S.length()){
            char c = T.charAt(revMode ? l : r);

            if (revMode) l++;
            else r--;

            if (c == 'B'){
                revMode = !revMode;
            }
        }

        if (revMode) {
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) != T.charAt(r - i)) {
                    System.out.println(0);
                    return;
                }
            }
        } else {
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) != T.charAt(l + i)) {
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(1);
    }

}