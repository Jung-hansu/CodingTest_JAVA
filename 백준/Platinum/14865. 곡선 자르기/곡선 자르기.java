import java.io.*;
import java.util.*;

public class Main {
	
	private static class Point implements Comparable<Point>{
		int x;
		int mountNo;
		boolean isInner;
		
		public Point(int x, int mountNo) {
			this.x = x;
			this.mountNo = mountNo;
			this.isInner = true;
		}

		@Override
		public int compareTo(Point o) {
			return x - o.x;
		}
		
		@Override
		public String toString() {
			return mountNo+": "+x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Point> pq = new PriorityQueue<>();
		Deque<Point> stack = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		int startX, startY, mountNo = 1, mountCnt = 0;
		int outters = 0, inners = 0;
		boolean flag;
		
		//get position of start point
		StringTokenizer st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken()); 	//시작 x좌표
		startY = Integer.parseInt(st.nextToken()); 	//시작 y좌표
		flag = startY > 0;							//시작 y좌표 부호
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int curX = Integer.parseInt(st.nextToken());
			int curY = Integer.parseInt(st.nextToken());
			
			//부호가 달라질 때마다 봉우리 기록
			if ((curY > 0) ^ flag) {
				if (!flag) {
					//음 -> 양이라면 봉우리 시작
					pq.add(new Point(curX, mountNo));
				} else {
					//양 -> 음이라면 봉우리 끝
					pq.add(new Point(curX, mountNo++));
					mountCnt++;
				}
				flag = !flag;
			}
		}
		if ((startY > 0) ^ flag) {
			if (!flag) {
				//음 -> 양이라면 봉우리 시작
				pq.add(new Point(startX, mountNo));
			} else {
				//양 -> 음이라면 봉우리 끝
				pq.add(new Point(startX, mountNo++));
				mountCnt++;
			}
			flag = !flag;
		}
		
		//x축 순서대로 봉우리 시작/끝점 확인
		while(!pq.isEmpty()) {
			Point p = pq.remove();
			
			//시작점의 Y좌표가 양수일 때의 경우 처리 (마지막 mount = 첫 mount)
			if (p.mountNo > mountCnt) {
				p.mountNo = 1;
			}
			
			if (stack.isEmpty()) {
				stack.addLast(p);
			}
			//내부에 다른 봉우리가 있음
			else if (stack.peekLast().mountNo != p.mountNo) {
				stack.peekLast().isInner = false;
				stack.addLast(p);
			}
			//하나의 봉우리 완성
			else {
				Point tmp = stack.removeLast();
				
				//바깥 봉우리가 없음
				if (stack.isEmpty()) {
					outters++;
				}
				//내부 봉우리가 없음
				if (tmp.isInner) {
					inners++;
				}
			}
		}
		
		System.out.println(outters + " " + inners);
	}
	
}