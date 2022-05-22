package baekjoon;

import java.util.Scanner;

public class b14650 {
    static int N;
    static int cnt = 0;
    static char[] chs = {'0','1','2'};
    static char[] temp = new char[9];

    static void recur(int cur){
        if(cur==N){
            if(temp[0]=='0')
                return;
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ;i<N;i++){
                sb.append(temp[i]);
            }
            if(Integer.parseInt(sb.toString())%3==0)
                cnt++;
            
            return;
        }
        for (int i=0; i<3;i++){

            temp[cur] = chs[i];
            recur(cur+1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        recur(0);
        System.out.println(cnt);
    }
}
