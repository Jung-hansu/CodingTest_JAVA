import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int size = Integer.parseInt(br.readLine());

		for (int i = 0; i < size; i++){
			if (i % 2 == 0) maxHeap.offer(Integer.parseInt(br.readLine()));
			else minHeap.offer(Integer.parseInt(br.readLine()));
			if (!minHeap.isEmpty() && maxHeap.element() > minHeap.element()){
				minHeap.offer(maxHeap.remove());
				maxHeap.offer(minHeap.remove());
			}
			bw.write(maxHeap.element() + "\n");
		}
		bw.flush();
	}
}