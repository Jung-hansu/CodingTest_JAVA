import java.io.*;
import java.util.*;

class MinHeap{
	
	int[][] heap;
	int size;
	
	public MinHeap(int initialCapacity) {
		heap = new int[initialCapacity + 1][];
	}
	
	public void add(int[] val) {
		heap[++size] = val;
		percolateUp();
	}
	
	public int[] remove() {
		percolateDown();
		return heap[size--];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private void swap(int x, int y) {
		int[] tmp = heap[x];
		heap[x] = heap[y];
		heap[y] = tmp;
	}
	
	private void percolateUp() {
		int idx = size;
		
		while (idx > 1 && heap[idx][0] < heap[idx / 2][0]) {
			swap(idx, idx / 2);
			idx /= 2;
		}
	}
	
	private void percolateDown() {
		int idx = 1;
		
		swap(1, size);
		while (2 * idx < size) {
			int minChild = 2 * idx;
			if (minChild + 1 < size && heap[minChild + 1][0] < heap[minChild][0]) {
				minChild += 1;
			}
			
			if (heap[idx][0] < heap[minChild][0]) {
				return;
			}
			swap(idx, minChild);
			idx = minChild;
		}
	}
	
}

public class Main {
	
	/** 각 컴퓨터의 {사용 종료 시간, 사용 횟수} 기록 */
	private static List<int[]> computers = new ArrayList<>();
	
	private static void takeSeat(int[] timestamp) {
		//기존 컴퓨터 중 사용 가능한 컴퓨터 탐색
		for (int[] computer : computers) {
			if (computer[0] <= timestamp[0]) {
				computer[0] = timestamp[1];
				computer[1]++;
				return;
			}
		}

		//앉을 자리가 없다면 새 컴퓨터 추가
		computers.add(new int[] {timestamp[1], 1});
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		MinHeap minHeap = new MinHeap(N);
		
		//parse inputs
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			minHeap.add(new int[] {start, end});
		}
		
		//run
		computers.add(new int[2]);
		while(!minHeap.isEmpty()) {
			int[] timestamp = minHeap.remove();
			takeSeat(timestamp);
		}
		
		//print
		sb.append(computers.size()).append('\n');
		for (int[] computer : computers) {
			sb.append(computer[1]).append(' ');
		}
		System.out.println(sb);
	}
	
}