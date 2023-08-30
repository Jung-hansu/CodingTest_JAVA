import java.io.*;
import java.util.*;

public class Main {
    private static int prec(char c){
        switch(c){
            case '(': case ')':   return 0;
            case '+': case '-':  return 1;
            case '*': case '/':  return 2;
            default:        return -1;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        String exp = br.readLine();

        for (int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);

            if (c >= 'A' && c <= 'Z') ans.append(c);
            else if (c == '(') stack.push(c);
            else if (c == ')'){
                while (stack.peek() != '(')
                    ans.append(stack.pop());
                stack.pop();}
            else{
                while (!stack.isEmpty() && prec(c) <= prec(stack.peek()))
                    ans.append(stack.pop());
                stack.push(c);}
        }
        while (!stack.isEmpty()) ans.append(stack.pop());
        System.out.println(ans);
    }
}
