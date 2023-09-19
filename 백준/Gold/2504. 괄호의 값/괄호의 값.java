import java.io.*;
import java.util.*;

public class Main {
    private static class Node{
        int n;
        char c;
        Node(int n){this.n = n;}
        Node(char c){this.c = c;}
    }
    private static long calc(String s) throws Exception{
        Stack<Node> expr = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (c == '(' || c == '[')expr.push(new Node(c=='('?'(':'['));
            //parse () -> 2
            else if (c == ')' && expr.peek().c == '(') {
                expr.pop();
                expr.push(new Node(2));
            }
            //parse [] -> 3
            else if (c == ']' && expr.peek().c == '[') {
                expr.pop();
                expr.push(new Node(3));
            }
            //parse (X) -> 2*X
            else if (c == ')' && expr.peek().n>0 && expr.get(expr.size()-2).c == '('){
                int n = expr.pop().n;
                expr.pop();
                expr.push(new Node(2*n));
            }
            //parse [X] -> 3*X
            else if (c == ']' && expr.peek().n>0 && expr.get(expr.size()-2).c == '['){
                int n = expr.pop().n;
                expr.pop();
                expr.push(new Node(3*n));
            }

            //parse XY -> X+Y
            if (expr.size() >= 2 && expr.peek().n>0 && expr.get(expr.size()-2).n>0)
                expr.push(new Node(expr.pop().n + expr.pop().n));
        }
        return expr.size() == 1 ? expr.pop().n : 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.println(calc(br.readLine()));
        } catch(Exception e){
            System.out.println(0);
        }
    }
}
