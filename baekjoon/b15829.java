package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class b15829 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String temp = br.readLine();
    BigInteger ans  = new BigInteger("0");
    long r = 1;
    for (int i = 0; i < N; i++){
      long num = ((temp.charAt(i)-'a'+1)*(r))%1234567891;
      r=(r*31)%1234567891;
      ans = ans.add(new BigInteger(Long.toString(num)));
    }
    System.out.println(ans.remainder(new BigInteger("1234567891")));
  }
}
