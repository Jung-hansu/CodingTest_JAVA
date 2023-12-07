import java.io.*;
import java.util.*;

public class Main {
    private static int ccw(int[] p1, int[] p2, int[] p3){
        long tmp = ((long)p2[0]-p1[0])*(p3[1]-p2[1])-((long)p2[1]-p1[1])*(p3[0]-p2[0]);
        return tmp > 0 ? 1 : tmp < 0 ? -1 : 0;
    }
    private static boolean isCrossed(int[] p1, int[] p2, int[] p3, int[] p4){
        int a = ccw(p1, p2, p3), b = ccw(p1, p2, p4), c = ccw(p3, p4, p1), d = ccw(p3, p4, p2);

        if (a*b<=0 && c*d<0 || a*b<0 && c*d<=0) return true;
        if (a*b==0 && c*d==0) {
            if (p1[0] > p2[0] || p1[0] == p2[0] && p1[1] > p2[1]){
                int[] tmp = p1;
                p1 = p2;
                p2 = tmp;
            }
            if (p3[0] > p4[0] || p3[0] == p4[0] && p3[1] > p4[1]){
                int[] tmp = p3;
                p3 = p4;
                p4 = tmp;
            }
            if (p1[0] == p2[0])
                return p1[1] <= p3[1] && p3[1] <= p2[1] || p1[1] <= p4[1] && p4[1] <= p2[1] ||
                        p3[1] <= p1[1] && p1[1] <= p4[1] || p3[1] <= p2[1] && p2[1] <= p4[1];
            else
                return p1[0] <= p3[0] && p3[0] <= p2[0] || p1[0] <= p4[0] && p4[0] <= p2[0] ||
                        p3[0] <= p1[0] && p1[0] <= p4[0] || p3[0] <= p2[0] && p2[0] <= p4[0];
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] p1, p2, p3, p4;

        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        p2 = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        st = new StringTokenizer(br.readLine());
        p3 = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        p4 = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        System.out.println(isCrossed(p1, p2, p3, p4) ? 1 : 0);
    }
}
