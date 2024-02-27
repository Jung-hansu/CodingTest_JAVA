import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), res = 0, idx = 0;
        br.readLine();
        String s = br.readLine(), IOI;
        StringBuilder sb = new StringBuilder().append("I");
        
        for (int i = 0; i < N; i++) {
        	sb.append("OI");
        }
        IOI = sb.toString();
        
        while((idx = s.indexOf(IOI, idx) + 1) > 0) {
        	res++;
        }
        System.out.println(res);
    }

}