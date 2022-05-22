package baekjoon;

import java.util.Scanner;

public class b25175 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long N = sc.nextLong();
    long M = sc.nextLong();
    long K = sc.nextLong();
    System.out.println((M + K - 3 + 100000 * N - 1) % N + 1);
  }
}


// 1 2 3 4 5 6
// 3-2-1 0 1 2
// 3 4 5 6 7 8