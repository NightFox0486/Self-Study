package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class b10799 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int answer = 0;
    char[] input = br.readLine().toCharArray();
    int[] countArr = new int[input.length*2-1];
    List<Integer> raser = new ArrayList<>();
    Stack <Integer> stack = new Stack<>();
    for (int i = 0; i < input.length; i++) {
      if(input[i]==')'){
        if(input[i-1]=='('){ // 레이저 확인
          raser.add(i*2-1);
          stack.pop();
        }
        else{
          int start = stack.pop();
          int end = i*2;
          for(int j = start; j <= end; j++) {
            countArr[j]++;
          }
        }
      }
      if(input[i]=='('){
        stack.add(i*2);
      }
    }
    for(int i = 0; i < raser.size(); i++) {
      countArr[raser.get(i)]=0;
    }
    int max = 0;
    for(int i = 0; i < countArr.length; i++){
      max = Math.max(max, countArr[i]);
    }
    // int max = 0;
    // for(int i = 0; i < countArr.length; i++) {
    //   if(countArr[i] == 0 || i == countArr.length-1) {
    //     answer += max;
    //     System.out.println(max);
    //     max = 0;
    //   }else{
    //     max = Math.max(max, countArr[i]);
    //   }
    // }
    System.out.println(answer);
  }
}
