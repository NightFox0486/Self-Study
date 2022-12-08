package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1975 {
  static int[] parent;

  static void union(int from, int to) {
    int from_parent = find(from);
    int to_parent = find(to);

    if (from_parent != to_parent) {
      if (from_parent < to_parent)
        parent[to] = from_parent;
      else
        parent[from] = to_parent;
    }
  }

  static int find(int x) {
    if (parent[x] == x)
      return x;
    return parent[x] = find(parent[x]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    String answer = "YES";

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    parent = new int[N+1];

    for (int i = 0; i <= N; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        if (Integer.parseInt(st.nextToken()) == 1) { // 연결요소가 있으면 유니온
          union(i, j);
        }
      }
    }

    for (int i = 1; i <= N; i++){
    System.out.println(i+" : " + parent[i]);
    }
    System.out.println();

    st = new StringTokenizer(br.readLine());
    int first = parent[Integer.parseInt(st.nextToken())];

    for (int i = 1; i < M; i++) {
      if (first != parent[Integer.parseInt(st.nextToken())])
        answer = "NO";
    }

    System.out.println(answer);
  }
}
// 0,3  1,2  2,1  2,3  3,0,  3,2