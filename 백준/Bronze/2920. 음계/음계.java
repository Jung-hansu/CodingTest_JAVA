import java.io.*;

public class Main {
    private static int isSorted(String s){
        if (s.charAt(0) == '1'){
            for (int i = 1; i < 9; i++)
                if (s.charAt(i*2-2) != ('0'+i))
                    return 0;
            return 1;
        }
        else if (s.charAt(0) == '8'){
            for (int i = 1; i < 9; i++)
                if (s.charAt(i*2-2) != ('9'-i))
                    return 0;
            return -1;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int flag = isSorted(s);

        System.out.println(flag>0 ? "ascending" : flag<0 ? "descending" : "mixed");
    }
}