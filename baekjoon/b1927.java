package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class b1927 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      int temp = Integer.parseInt(br.readLine());
      if (temp != 0) {
        pq.offer(temp);
      } else {
        if (pq.isEmpty())
          sb.append("0\n");
        else
          sb.append(pq.poll() + "\n");
      }
    }
    System.out.println(sb);
  }
}
