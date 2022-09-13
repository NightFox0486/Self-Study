package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class b11723 {
  public static void main(String[] args) throws IOException{
    Set<Integer> set = new TreeSet<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      String opper = st.nextToken();
      int num = 0;
      if(!(opper.equals("all")||opper.equals("empty"))){
        num = Integer.parseInt(st.nextToken());
      }
      if(opper.equals("add")){
        set.add(num);
      }else if(opper.equals("remove")){
        set.remove(num);
      }else if(opper.equals("check")){
        if(set.contains(num)){
          sb.append("1\n");
        }else{
          sb.append("0\n");
        }
      }else if(opper.equals("toggle")){
        if(set.contains(num)){
          set.remove(num);
        }else{
          set.add(num);
        }
      }else if(opper.equals("all")){
        set.clear();
        for(int j = 1;j<=20;j++){
          set.add(j);
        }
      }else if(opper.equals("empty")){
        set.clear();
      }
    }
    System.out.println(sb);
  }
}
