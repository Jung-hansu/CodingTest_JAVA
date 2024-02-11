import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    private static List<Symbol> buf = new ArrayList<>();
    private static int idx = 0;
    private enum sym {NUL, DIGIT, NUMBER, EXPR, PLUS, MINUS, STAR, SLASH, LP, RP};

    private static class Symbol{
        public sym type;
        public BigInteger lval;
        public Symbol(){type = sym.NUL;}
        public Symbol(char c){
            if (c >= '0' && c <= '9'){ type = sym.DIGIT; lval = BigInteger.valueOf(c-'0'); }
            else if (c == '+') type = sym.PLUS;
            else if (c == '-') type = sym.MINUS;
            else if (c == '*') type = sym.STAR;
            else if (c == '/') type = sym.SLASH;
            else if (c == '(') type = sym.LP;
            else if (c == ')') type = sym.RP;
            else type = sym.NUL;
        }
        public void setNum(Symbol s){ type = sym.NUMBER; lval = lval.multiply(BigInteger.TEN).add(s.lval); }
        public void setNum() { type = sym.NUMBER; }
        public void setExpr() { type = sym.EXPR; }
    }

    private static Symbol expression() throws Exception{
        Symbol res = term();

        while (buf.get(idx).type == sym.PLUS || buf.get(idx).type == sym.MINUS){
            sym symbol = buf.get(idx++).type;
            Symbol T = term();
            if (symbol == sym.PLUS) res.lval = res.lval.add(T.lval);
            else if (symbol == sym.MINUS) res.lval = res.lval.subtract(T.lval);
        }
        return res;
    }
    private static Symbol term() throws Exception{
        Symbol res = factor();

        while (buf.get(idx).type == sym.STAR || buf.get(idx).type == sym.SLASH){
            sym symbol = buf.get(idx++).type;
            Symbol F = factor();
            if (symbol == sym.STAR) res.lval = res.lval.multiply(F.lval);
            else if (symbol == sym.SLASH) res.lval = res.lval.divide(F.lval);
        }
        return res;
    }
    private static Symbol factor() throws Exception{
        Symbol res;

        if (buf.get(idx).type == sym.EXPR) res = buf.get(idx++);
        else if (buf.get(idx).type == sym.LP){
            idx++;
            res = expression();
            if (buf.get(idx).type == sym.RP) idx++;
            else throw new Exception();}
        else throw new Exception();
        return res;
    }

    public static void main(String[] args) throws IOException {
        int c;
        
        //Parsing digit -> number -> expr
        while ((c = System.in.read()) >= 0){
            Symbol tmp = new Symbol((char) c);
            if (tmp.type == sym.DIGIT)
                if (buf.isEmpty() || buf.get(buf.size()-1).type != sym.NUMBER){
                    tmp.setNum();
                    buf.add(tmp);}
                else buf.get(buf.size()-1).setNum(tmp);
            else {
                if (!buf.isEmpty() && buf.get(buf.size()-1).type == sym.NUMBER)
                    buf.get(buf.size()-1).setExpr();
                buf.add(tmp);}}
        if (!buf.isEmpty() && buf.get(buf.size()-1).type == sym.NUMBER) buf.get(buf.size()-1).setExpr();
        buf.add(new Symbol());

        //Calculation
        try {
            Symbol res = expression();
            if (buf.get(idx).type != sym.NUL) throw new Exception();
            System.out.println(res.lval.toString());}
        catch(Exception e){ System.out.println("ROCK"); }
    }
}