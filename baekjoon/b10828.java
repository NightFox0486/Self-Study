package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b10828 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      String oppr = st.nextToken();
      if(oppr.equals("push")){
        stack.add(Integer.parseInt(st.nextToken()));
      }else if(oppr.equals("pop")){
        if(stack.isEmpty()){
          sb.append("-1\n");
        }else{
          sb.append(""+stack.pop()+"\n");
        }
      }else if(oppr.equals("size")){
        sb.append(""+stack.size()+"\n");
      }else if(oppr.equals("empty")){
        if(stack.isEmpty()){
          sb.append("1\n");
        }else{
          sb.append("0\n");
        }
      }else if(oppr.equals("top")){
        if(stack.isEmpty()){
          sb.append("-1\n");
        }else{
          sb.append(""+stack.peek()+"\n");
        }
      }
    }
    System.out.println(sb);
  }
}
