package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class b10551 {
    public static void main(String[] args) throws IOException {
        int[] finger = new int[8];
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '`' || c == '1' || c == 'Q' || c == 'A' || c == 'Z')
                finger[0]++;
            else if (c == '2' || c == 'W' || c == 'S' || c == 'X')
                finger[1]++;
            else if (c == '3' || c == 'E' || c == 'D' || c == 'C')
                finger[2]++;
            else if (c == '4' || c == 'R' || c == 'F' || c == 'V' || c == '5' || c == 'T' || c == 'G' || c == 'B')
                finger[3]++;
            else if (c == '6' || c == 'Y' || c == 'H' || c == 'N' || c == '7' || c == 'U' || c == 'J' || c == 'M')
                finger[4]++;
            else if (c == '8' || c == 'I' || c == 'K' || c == ',')
                finger[5]++;
            else if (c == '9' || c == 'O' || c == 'L' || c == '.')
                finger[6]++;
            else if (c == '0' || c == 'P' || c == ';' || c == '/' || c == '-' || c == '[' || c == '\'' || c == '='
                    || c == ']')
                finger[7]++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(finger[i]);
        }
        sc.close();
    }
}
