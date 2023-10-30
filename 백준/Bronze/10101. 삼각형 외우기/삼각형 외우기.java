import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] angles = new int[3];

        for (int i = 0; i < 3; i++) angles[i] = Integer.parseInt(br.readLine());
        Arrays.sort(angles);
        if (angles[0] + angles[1] + angles[2] != 180)
            System.out.println("Error");
        else if (angles[0] == angles[1] && angles[1] == angles[2])
            System.out.println("Equilateral");
        else if (angles[0] == angles[1] || angles[0] == angles[2] || angles[1] == angles[2])
            System.out.println("Isosceles");
        else
            System.out.println("Scalene");
    }
}
