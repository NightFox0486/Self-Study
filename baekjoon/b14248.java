package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b14248 {
    static int N;
    static int[] arr;
    static boolean[] check;
    static int cnt = 0;

    static void solve(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        check[n] = true;
        while(!queue.isEmpty()){
            int current = queue.poll();
            cnt++;
            int left = current-arr[current];
            int right = current+arr[current];
            if(left>=0&&!check[left]){
                queue.add(left);
                check[left] = true;
            }
            if(right<N&&!check[right]){
                queue.add(right);
                check[right] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        check = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solve(Integer.parseInt(br.readLine())-1);
        System.out.println(cnt);
    }
}
