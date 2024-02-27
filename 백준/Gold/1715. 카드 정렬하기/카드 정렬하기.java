import java.io.*;
import java.util.*;

class Main {
	
	private static int readInt() throws IOException{
		int c, n = 0;
		while((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

    public static void main(String[] args) throws IOException{
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = readInt(), sum = 0;

        for (int i = 0; i < N; i++) {
        	pq.add(readInt());
        }

        while(pq.size() > 1) {
        	int tmp = pq.remove() + pq.remove();
        	
        	sum += tmp;
        	pq.add(tmp);
        }
        
        System.out.println(sum);
    }

}