package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1264 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(true) {
      char[] input = br.readLine().toCharArray();
      if (input.length==1&&input[0]=='#')
        break;
      int cnt = 0;
      for (int i = 0; i < input.length; i++) {
        if(input[i]=='A'|| input[i] == 'E' || input[i] == 'I' || input[i] == 'O' || input[i] == 'U')
          cnt++;
          if(input[i]=='a'|| input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u')
          cnt++;
      }
      System.out.println(cnt);
    }
  }  
}
