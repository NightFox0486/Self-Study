package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class b4803 {
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
    int stage = 1;
    while(true) {
      List<Integer> cycle = new ArrayList<>();
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      if(n == 0 && m == 0)
          break;

      parent = new int[n+1];

      for (int i = 0; i <= n; i++){
        parent[i] = i;
      }

      for(int i = 0; i < m; i++){
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(parent[a] == parent[b]){
          cycle.add(parent[a]);
        }
        union(a, b);
      }


      Set<Integer> set = new TreeSet<>();
      for(int i = 1; i <= n; i++){
        set.add(parent[i]);
      }
      for(int i = 0; i < cycle.size(); i++){
        if(set.contains(cycle.get(i))){
          set.remove(cycle.get(i));
        }
      }
      if(set.size() == 0){
        System.out.println("Case "+stage+++": No trees.");
      }else if(set.size() == 1){
        System.out.println("Case "+stage+++": There is one tree.");
      }else{
        System.out.println("Case "+stage+++": A forest of " + set.size() + " trees.");
      }
    }
  }
}
// 사이클 판별 추가