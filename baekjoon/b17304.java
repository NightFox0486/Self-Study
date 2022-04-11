package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b17304 {
    static int N;
    static int M;
    static int[] node;
    static int cnt = 0;
    static boolean result;
    static List[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        node = new int[N + 1];
        map = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            map[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[to].add(from); // 나를 변호해주는 목록 작성
            if (node[to] != -1) // 서로를 변호하지 않고 변호를 받는 경우
                node[to] = 1; // 변호 받음
            if (map[from].contains(to)) { // 서로 변호하게 되는 경우 -1 할당
                node[from] = -1;
                node[to] = -1;
            }
        } // node == -1 이면 양방향 0 이면 아무도 변호해주는 사람이 없음
        for (int j = 1; j < N + 1; j++) {
            if (node[j] == 0) { // 변호 실패
                result = true;
            }
            if (node[j] == -1) { // 양방향 변호의 경우
                if (map[j].size() != 1) { // 서로 변호하는 경우 말고 다른 사람이 변호해주는 것이 있는지 확인
                    for (int k = 0; k < map[j].size(); k++) { // 변호리스트 순회
                        if (node[(int) map[j].get(k)] != -1) // 변호리스트중 서로 변호가 아닌 날 변호해주는 경우가 있는지 확인
                            node[j] = 2; // 서로 변호 말고 다른 곳에서 변호 받음
                    }
                }
            }
        }
        for (int j = 1; j < N + 1; j++) {
            if (node[j] == -1)
                if (node[(int) map[j].get(0)] != 2) // 다른곳에서 변호를 못받고 서로 변호 하던 사람이 다른곳에서 변호 받았는지 확인
                    result = true;
        }
        if (result)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}
