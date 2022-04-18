package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14891 {
    static int K;
    static int[][] map;
    static int[] indexs;
    static boolean[] moved;

    static void solve(int selected, int direction) {
        int anotherDir;
        if (direction == 1)
            anotherDir = -1;
        else
            anotherDir = 1;
        if (selected == 0) {
            if (direction == 1) {
                int rightIdx = getRightIndex(indexs[selected]);
                if (map[selected][rightIdx] == map[selected + 1][getLeftIndex(indexs[1])]) {
                    indexs[0] = (indexs[0] + 8 - 1) % 8;
                } else {
                    indexs[0] = (indexs[0] + 8 - 1) % 8;
                    if (moved[1])
                        return;
                    moved[0] = true;
                    solve(selected + 1, anotherDir);
                    moved[0] = false;
                }
            } else if (direction == -1) {
                int rightIdx = getRightIndex(indexs[selected]);
                if (map[selected][rightIdx] == map[selected + 1][getLeftIndex(indexs[1])]) {
                    indexs[0] = (indexs[0] + 1) % 8;
                } else {
                    indexs[0] = (indexs[0] + 1) % 8;
                    if (moved[1])
                        return;
                    moved[0] = true;
                    solve(selected + 1, anotherDir);
                    moved[0] = false;
                }
            }
        } else if (selected == 3) {
            if (direction == 1) {
                int leftIdx = getLeftIndex(indexs[selected]);
                if (map[selected][leftIdx] == map[selected - 1][getRightIndex(indexs[2])]) {
                    indexs[3] = (indexs[3] + 8 - 1) % 8;
                } else {
                    indexs[3] = (indexs[3] + 8 - 1) % 8;
                    if (moved[2])
                        return;
                    moved[3] = true;
                    solve(selected - 1, anotherDir);
                    moved[3] = false;
                }
            } else if (direction == -1) {
                int leftIdx = getLeftIndex(indexs[selected]);
                if (map[selected][leftIdx] == map[selected - 1][getRightIndex(indexs[2])]) {
                    indexs[3] = (indexs[3] + 1) % 8;
                } else {
                    indexs[3] = (indexs[3] + 1) % 8;
                    if (moved[2])
                        return;
                    moved[3] = true;
                    solve(selected - 1, anotherDir);
                    moved[3] = false;
                }
            }
        } else {
            if (direction == 1) {
                int leftIdx = getLeftIndex(indexs[selected]);
                int rightIdx = getRightIndex(indexs[selected]);
                if (map[selected][leftIdx] != map[selected - 1][getRightIndex(indexs[selected - 1])]) {
                    indexs[selected] = (indexs[selected] + 8 - 1) % 8;
                    if (!moved[selected - 1]) {
                        moved[selected] = true;
                        solve(selected - 1, anotherDir);
                        moved[selected] = false;
                    }
                } else {
                    indexs[selected] = (indexs[selected] + 8 - 1) % 8;
                }
                indexs[selected] = (indexs[selected] + 1) % 8;
                if (map[selected][rightIdx] != map[selected + 1][getLeftIndex(indexs[selected + 1])]) {
                    indexs[selected] = (indexs[selected] + 8 - 1) % 8;
                    if (!moved[selected + 1]) {
                        moved[selected] = true;
                        solve(selected + 1, anotherDir);
                        moved[selected] = false;
                    }
                } else {
                    indexs[selected] = (indexs[selected] + 8 - 1) % 8;
                }
            } else if (direction == -1) {
                int leftIdx = getLeftIndex(indexs[selected]);
                int rightIdx = getRightIndex(indexs[selected]);
                if (map[selected][leftIdx] != map[selected - 1][getRightIndex(indexs[selected - 1])]) {
                    indexs[selected] = (indexs[selected] + 1) % 8;
                    if (!moved[selected - 1]) {
                        moved[selected] = true;
                        solve(selected - 1, anotherDir);
                        moved[selected] = false;
                    }
                } else {
                    indexs[selected] = (indexs[selected] + 1) % 8;
                }
                indexs[selected] = (indexs[selected] + 8 - 1) % 8;
                if (map[selected][rightIdx] != map[selected + 1][getLeftIndex(indexs[selected + 1])]) {
                    indexs[selected] = (indexs[selected] + 1) % 8;
                    if (!moved[selected + 1]) {
                        moved[selected] = true;
                        solve(selected + 1, anotherDir);
                        moved[selected] = false;
                    }
                } else {
                    indexs[selected] = (indexs[selected] + 1) % 8;
                }
            }
        }
    }

    static int getLeftIndex(int index) {
        int temp = index + 8;
        return (temp - 2) % 8;
    }

    static int getRightIndex(int index) {
        return (index + 2) % 8;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[4][8];
        indexs = new int[4];
        moved = new boolean[4];
        for (int i = 0; i < 4; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int select = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            solve(select - 1, dir);
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += map[i][indexs[i]] * Math.pow(2, i);
        }
        System.out.println(sum);

    }
}
