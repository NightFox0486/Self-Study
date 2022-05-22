package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b2002 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<String> queue = new LinkedList<>();
        int cnt = 0;
        int remain = N;
        for (int i = 0; i < N; i++){
            queue.add(br.readLine());
        }
        for (int i = 0; i < N; i++){
            String current = queue.poll();
            while(true){
                if(remain==0) break;
                remain--;
                String temp=br.readLine();
                if(!current.equals(temp)){
                    cnt++;
                    queue.remove(temp);
                }else
                    break;
            }
        }
        System.out.println(cnt);
    }
}
