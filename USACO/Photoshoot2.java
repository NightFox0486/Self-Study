package USACO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Photoshoot2 {
    static int N;
    static int[] index;
    static int[] arr;
    static int[] arr2;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 0;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        arr2 = new int[N];
        check = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            index[arr[i]] = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0;i< N; i++){
            if(index[arr[i]]<i)
                cnt++;
        }
        System.out.println(cnt);
    }
}