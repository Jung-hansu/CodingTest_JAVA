import java.io.*;
import java.util.*;

public class Main {

    private static int readInt() throws IOException{
        int c, n = 0;

        while ((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int N = readInt(), K = readInt();
        char c;

        while ((c = (char)System.in.read()) > 32 && K > 0){
            if (stack.isEmpty()){
                stack.addLast(c);
                continue;
            }

            while (K > 0 && !stack.isEmpty() && stack.peekLast() < c){
                stack.removeLast();
                K--;
            }

            stack.addLast(c);
        }

        for (char n : stack){
            sb.append(n);
        }
        if (c > 32) {
            do {
                sb.append(c);
            } while ((c = (char)System.in.read()) > 32);
        }

        System.out.println(K == 0 ? sb : sb.substring(0, sb.length() - K));
    }

}