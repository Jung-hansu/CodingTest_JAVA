import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        for (int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);

        // 세 원소의 합이 될 숫자를 먼저 정함
        for (int sumIdx = N - 1; sumIdx > 0; sumIdx--) {
            // 세 원소중 두 원소를 고름 (가장 큰 원소 포함시 불가능)
            for (int n1 = N - 2; n1 >= 0; n1--) {
                for (int n2 = N - 2; n2 >= 0; n2--) {
                    int n3 = nums[sumIdx] - (nums[n1] + nums[n2]);

                    //나머지 한 원소가 최솟값보다 작으면 불가능
                    if (n3 < nums[0]) {
                        continue;
                    }

                    // 구간 이분탐색으로 나머지 원소 찾기 (0부터 n2-1까지 이분탐색)
                    if (Arrays.binarySearch(nums, 0, n2 + 1, n3) >= 0) {
                        System.out.println(nums[sumIdx]);
                        return;
                    }

                }
            }
        }
    }

}