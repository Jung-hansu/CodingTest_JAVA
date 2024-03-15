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

        // 세 수의 합이 될 수를 먼저 정함
        for (int sumIdx = N - 1; sumIdx > 0; sumIdx--) {
            // 세 수중 최대, 최소 수를 고름 (가장 큰 원소 포함시 불가능)
            for (int n3 = N - 2; n3 >= 0; n3--) {
                for (int n1 = 0; n1 <= n3; n1++) {
                    int n2 = nums[sumIdx] - (nums[n1] + nums[n3]);

                    //나머지 한 수가 최솟값보다 작으면 불가능
                    if (n2 < n1) {
                        break;
                    }

                    // 구간 이분탐색으로 사이에 있는 나머지 수 찾기
                    if (Arrays.binarySearch(nums, n1, n3 + 1, n2) >= 0) {
                        System.out.println(nums[sumIdx]);
                        return;
                    }

                }
            }
        }
    }

}