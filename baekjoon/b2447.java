import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b2447 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        char[][] arr = new char[n][n];
        printstar(arr, n, 0, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        bf.close();
    }

    static void printstar(char[][] arr, int size, int x, int y) {
        for (int i = x; i < x + size; i += size / 3) {
            for (int j = y; j < y + size; j += size / 3) {
                if (i == x + size / 3 && j == y + size / 3) {
                    for (int a = i; a < i + size / 3; a++) {
                        for (int b = j; b < j + size / 3; b++) {
                            arr[a][b] = ' ';
                        }
                    }
                } else {
                    if (size == 3) {
                        for (int a = i; a < i + size / 3; a++) {
                            for (int b = j; b < j + size / 3; b++) {
                                arr[a][b] = '*';
                            }
                        }
                    } else {
                        printstar(arr, size / 3, i, j);
                    }
                }
            }
        }
    }
}