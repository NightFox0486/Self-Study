package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class b10816 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    Map<Integer, Integer> map = new TreeMap<>();
    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++){
      int temp = Integer.parseInt(st.nextToken());
      if(map.containsKey(temp)){
        int cnt = map.get(temp);
        map.put(temp,cnt+1);
      }else{
        map.put(temp,1);
      }
    }
    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < M; i++){
      int temp = Integer.parseInt(st.nextToken());
      if(map.containsKey(temp)){
        sb.append(map.get(temp)+" ");
      }else{
        sb.append("0 ");
      }
    }
    System.out.println(sb);

  }
}
