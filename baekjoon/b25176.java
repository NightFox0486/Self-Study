package baekjoon;

import java.util.Scanner;

public class b25176{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int ans = 1;
    for (int i = 2; i <= N; i++) {
      ans*=i;
    }
    System.out.println(ans);
  }
}