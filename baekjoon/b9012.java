package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class b9012 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    for (int i = 0; i < N; i++){
      String temp = sc.next();
      String ans = "YES";
      Stack<Character> stack = new Stack<>();
      for(int j = 0;j<temp.length();j++){
        char tempChar = temp.charAt(j);
        if(tempChar == '('){
          stack.push(tempChar);
        }else{
          if(!stack.isEmpty()&&stack.peek()=='('){
            stack.pop();
          }else{
            ans = "NO";
            break;
          }
        }
      }
      if(!stack.isEmpty()){
        ans ="NO";
      }
      System.out.println(ans);
    }
  }
}
