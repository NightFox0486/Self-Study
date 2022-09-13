package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b11866 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int N = sc.nextInt();
    int K = sc.nextInt();
    Queue<Integer> queue = new LinkedList<Integer>();
    for (int i = 1; i <= N; i++) {
      queue.add(i);
    }
    sb.append("<");
    while (!queue.isEmpty()) {
      for (int i = 0; i < K-1; i++) {
        int temp = queue.poll();
        queue.add(temp);
      }
      sb.append(queue.poll()+", ");
    }
    sb.replace(sb.length()-2, sb.length(), ">");
    System.out.println(sb);
  }
}
