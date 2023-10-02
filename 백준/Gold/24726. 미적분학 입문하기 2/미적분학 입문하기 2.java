import java.io.*;
import java.util.*;

public class Main {
    private static double[][] tri = new double[3][];
    //mode -> true:X, false:Y
    private static double rotate(boolean mode){
        Arrays.sort(tri, Comparator.comparing(o->o[mode?0:1]));
        return Math.abs(rotate_Axis(tri[0], tri[2], mode)
                        - rotate_Axis(tri[0], tri[1], mode)
                        - rotate_Axis(tri[1], tri[2], mode));
    }
    private static double rotate_Axis(double[] t1, double[] t2, boolean mode){
        int x = mode ? 0 : 1, y = mode ? 1 : 0;
        
        if (t1[x] == t2[x]) return 0;
        double c2 = (Math.pow(t1[y]-t2[y], 2)/Math.pow(t1[x]-t2[x], 2))/3.0,
                c1 = (2*(t1[y]-t2[y])*(t1[x]*t2[y]-t2[x]*t1[y])/Math.pow(t1[x]-t2[x], 2))/2.0,
                c0 = (Math.pow(t1[x]*t2[y]-t2[x]*t1[y], 2)/Math.pow(t1[x]-t2[x], 2));
        return Math.PI *
                (c2 * Math.abs(Math.pow(t1[x],3) - Math.pow(t2[x],3)) +
                c1 * Math.abs(Math.pow(t1[x],2) - Math.pow(t2[x],2)) +
                c0 * Math.abs(t1[x] - t2[x]));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++)
            tri[i] = new double[]{Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())};
        System.out.println(rotate(true) + " " + rotate(false));
    }
}
