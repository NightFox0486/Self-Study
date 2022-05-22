package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b13417 {
  static char[] chs;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      StringBuilder sb = new StringBuilder();
      N = Integer.parseInt(br.readLine());
      chs = new char[N];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        chs[i] = st.nextToken().charAt(0);
      }
      sb.append(chs[0]);
      for (int i = 1; i < N; i++) {
        if (chs[i] > sb.charAt(0)) {
          sb.append(chs[i]);
        } else {
          sb.insert(0, chs, i, 1);
        }
      }
      System.out.println(sb);
    }

  }
}
