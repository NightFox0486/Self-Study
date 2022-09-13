package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class b1764 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int cnt = 0;
    Set<String> noListen = new TreeSet<>();
    Set<String> noShown = new TreeSet<>();
    for(int i=0;i<N;i++){
      noListen.add(br.readLine());
    }
    for(int i=0;i<M;i++){
      noShown.add(br.readLine());
    }
    Iterator<String> iter = noListen.iterator();
    while(iter.hasNext()){
      String temp = iter.next();
      if(noShown.contains(temp)){
        cnt++;
        sb.append(temp+"\n");
      }
    }
    System.out.println(cnt);
    System.out.println(sb);
  }
}
