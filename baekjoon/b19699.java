package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class b19699 {
  static int N;
  static int M;
  static int[] input;
  static boolean[] check;
  static int[] temp;
  static boolean[] prime = new boolean[11111];
  static Set<Integer> set = new TreeSet<Integer>();

  static void setPrime() {
    prime[0] = true;
    prime[1] = true;
    for (int i = 2; i < 10000; i++) {
      if (prime[i])
        continue;
      int j = 2;
      while (true) {
        if (i * j > 10000)
          break;
        prime[i * j] = true;
        j++;
      }
    }
  }

  static void recur(int cur) {
    if (cur == M) {
      int sum = 0;
      for (int i = 0; i < M; i++) {
        sum += temp[i];
      }
      if (!prime[sum]) {
        set.add(sum);
      }
      return;
    }

    for (int i = 0; i < N; i++) {
      if (check[i])
        continue;
      check[i] = true;
      temp[cur] = input[i];
      recur(cur + 1);
      check[i] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    input = new int[N];
    check = new boolean[N];
    temp = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }
    setPrime();
    recur(0);
    if (set.size() == 0) {
      sb.append("-1");
    } else {
      for (Integer n : set) {
        sb.append(n + " ");
      }
    }
    System.out.println(sb);
  }
}
