package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1865 {
  static int N;
  static double[][] P;
  static boolean[] check;
  static double[] arr;
  static double maxDouble;

  static void recur(int cur, double p) {
    if(p<=maxDouble)
      return;

    if (cur == N) {
      maxDouble = Math.max(maxDouble, p);
      return;
    }
    for (int i = 0; i < N; i++) {
      if (check[i])
        continue;
      check[i] = true;
      recur(cur + 1 , p*P[cur][i]);
      check[i] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());
      P = new double[N][N];
      arr = new double[N];
      check = new boolean[N];
      maxDouble = 0.0;
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          P[i][j] = Integer.parseInt(st.nextToken()) / 100.0;
        }
      }
      recur(0,1.0);
      maxDouble *= 100;
      sb.append("#" + t + " " + String.format("%.6f", maxDouble)+"\n");
    }
    System.out.println(sb);
  }
}
