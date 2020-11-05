import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class b2447 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] arr = new char[n][n];
        printstar(arr, 0, 0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }

    static void printstar(char[][] arr, int x, int y, int size) {
        if (size != 3) {
            for (int i = x; i < x + size; i += size / 3) {
                for (int j = y; j < y + size; j += size / 3) {
                    if (i == size / 3 && j == size / 3) {
                        for (int a = i; a < i + size / 3; a++)
                            for (int b = i; b < i + size / 3; b++)
                                arr[a][b] = ' ';
                    } else {
                        printstar(arr, i, j, size / 3);
                    }
                }
            }
        } else {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (i == 1 && j == 1)
                        arr[i][j] = ' ';
                    else
                        arr[i][j] = '*';
                }
            }
        }
    }
}