package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b4949 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean end = false;
    while (true) {
      if(end)
        break;
      String answer = "no";
      Stack<Character> stack = new Stack<Character>();
      String input = br.readLine();
      for (int i = 0; i < input.length(); i++) {
        if (input.charAt(0) == '.'&&input.length()==1) {
          end = true;
          break;
        }
        if(input.charAt(i) == '('){
          stack.add(input.charAt(i));
        }else if(input.charAt(i) == ')'){
          if(stack.isEmpty()||stack.peek()!='('){
            break;
          }
          stack.pop();
        }else if(input.charAt(i) == '['){
          stack.add(input.charAt(i));
        }else if(input.charAt(i) == ']'){
          if(stack.isEmpty()||stack.peek()!='['){
            break;
          }
          stack.pop();
        }
        if(i == input.length()-1){
          answer = "yes";
        }
      }
      if(!stack.isEmpty()){
        answer="no";
      }
      if(!end)
        System.out.println(answer);
    }
  }
}
