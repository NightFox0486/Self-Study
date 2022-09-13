package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b17304_2 {
  static int[] par;
  static List<Integer>[] d;
  static List<int[]> v;
  static boolean visited[];
  static int[] size;
  static int[] rank;
  static int[] edge;

  static int find(int x) {
    if (par[x] == x)
      return x;
    else {
      par[x] = find(par[x]);
      return par[x];
    }
  }

  static void union_(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b)
      return;
    if (rank[a] < rank[b]) {
      par[a] = b;
      size[b] += size[a];
      edge[b] += edge[a];
      visited[b] |= visited[a];
    } else if (rank[a] > rank[b]) {
      par[b] = a;
      size[a] += size[b];
      edge[a] += edge[b];
      visited[a] |= visited[b];
    } else {
      par[a] = b;
      rank[b]++;
      size[b] += size[a];
      edge[b] += edge[a];
      visited[b] |= visited[a];
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    String answer = "YES";
    d = new ArrayList[N + 1];
    visited = new boolean[N + 1];
    par = new int[N + 1];
    size = new int[N + 1];
    rank = new int[N + 1];
    edge = new int[N + 1];
    v = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      par[i] = i;
      size[i] = 1;
      d[i] = new ArrayList<>();
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      d[from].add(to);
    }
    for (int i = 1; i <= N; i++) {
      for (int j : d[i]) {
        if (d[j].contains(i)) {
          v.add(new int[] { i, j });
          edge[i]++;
        } else {
          visited[j] = true;
        }
      }
    }
    for (int i = 0; i < v.size(); i++) {
      int[] temp = v.get(i);
      union_(temp[0], temp[1]);
    }
    for (int i = 1; i <= N; i++) {
      int x = find(i);
      if (edge[x] == 2 * size[x] - 2 && !visited[x]) {
        answer = "NO";
        break;
      }
    }
    System.out.println(answer);
  }
}
