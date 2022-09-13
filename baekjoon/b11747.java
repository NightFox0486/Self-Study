package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.TreeSet;

public class b11747 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[] input = new int[N];
    boolean check = false;
    int index = 0;
    Set<Integer> set = new TreeSet<>();
    int cnt = 0;
    while (true) {
      int temp = br.read();
      if (temp == 32 || temp == 13 || temp == 10) {
        continue;
      }
      input[cnt++] = temp - 48;
      set.add(temp - 48);
      if (cnt == N)
        break;
    }
    for(int i = 0 ;i < 10;i++){
      if(!set.contains(i)){
        index = i;
        check = true;
        break;
      }
    }
    int length = 2;
    int temp = -1;
    while (!check) {
      for (int i = 0; i <= N - length; i++) {
        for (int j = i; j < i + length; j++) {
          if (j == i) {
            temp = input[j];
          } else {
            temp *= 10;
            temp += input[j];
          }
          if(j==i+length-1)
            set.add(temp);
        }
      }
      int start = (int)Math.pow(10, length-1);
      int end = (int)Math.pow(10, length)-1;
      for(int i = start ;i < end;i++){
        if(!set.contains(i)){
          index = i;
          check = true;
          break;
        }
      }
      length++;
    }
    System.out.println(index);
  }
}
