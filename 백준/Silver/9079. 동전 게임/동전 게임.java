import java.io.*;
import java.util.*;

public class Main {

    private static final int[][] cases = {
        {0, 511},
        {7, 56, 63, 73, 84, 146, 219, 238, 273, 292, 365, 427, 438, 448, 455, 504},
        {29, 53, 78, 83, 107, 108, 113, 118, 124, 143, 149, 167, 170, 173, 186, 198, 209, 214, 220, 227, 228, 233, 278, 283, 284, 291, 297, 302, 313, 325, 338, 341, 344, 362, 368, 387, 393, 398, 403, 404, 428, 433, 458, 482},
        {10, 13, 26, 34, 37, 40, 50, 67, 68, 97, 123, 130, 133, 136, 152, 159, 160, 176, 183, 189, 193, 243, 249, 254, 257, 262, 268, 318, 322, 328, 335, 351, 352, 359, 375, 378, 381, 388, 414, 443, 444, 461, 471, 474, 477, 485, 498, 501},
        {16, 23, 47, 89, 94, 102, 203, 204, 244, 267, 307, 308, 409, 417, 422, 464, 488, 495}
    };

    private static int getMinOperationCount(int coins){
        for (int opCnt = 0; opCnt < 5; opCnt++){
            if (Arrays.binarySearch(cases[opCnt], coins) >= 0){
                return opCnt;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int coins = 0;

            for (int i = 0; i < 3; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++){
                    coins = (coins << 1) | ("H".equals(st.nextToken()) ? 1 : 0);
                }
            }
            sb.append(getMinOperationCount(coins)).append("\n");
        }
        System.out.print(sb);
    }

}