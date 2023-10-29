import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Arrays.stream((new BufferedReader(new InputStreamReader(System.in))).readLine().split(" "))
              .mapToInt(Integer::parseInt)
              .sorted()
              .mapToObj(o -> o + " ")
              .forEach(System.out::print);
    }
}
