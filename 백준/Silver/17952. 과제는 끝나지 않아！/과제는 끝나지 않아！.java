import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static class Task {
		int score;
		int min;

		public Task(int score, int min) {
			this.score = score;
			this.min = min;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Stack<Task> stack = new Stack<>();
		int answer = 0;
		Task curr = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			//이번에 업무가 주어지지 않은 경우
			if (st.nextToken().equals("0")) {
				if (curr == null) {
					if (stack.isEmpty()) { // curr이 없는데 stack에도 값이 없는경우
						continue;
					} else {
						curr = stack.pop();
						curr.min -= 1;
						if (curr.min == 0) {
							answer += curr.score;
							curr = null;
						}
					}

				} else {
					curr.min -= 1;
					if (curr.min == 0) {
						answer += curr.score;
						curr = null;
					}
				}
			}
			//이번에 업무가 주어진 경우
			else {
				int score = Integer.parseInt(st.nextToken());
				int min = Integer.parseInt(st.nextToken());
				//작업중이던게 없으면
				if (curr == null) {
					if (min == 1) {
						answer += score;
					} else {
						curr = new Task(score, min);
						curr.min--;
					}
				} else {
					stack.add(curr);
					curr = new Task(score, min);
					curr.min-=1;
					if(curr.min == 0) {
						answer+=score;
						curr = null;
					}
				}
			}

		}
		System.out.println(answer);
	}
}