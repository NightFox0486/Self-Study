package baekjoon;

import java.util.Scanner;

public class b17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        StringBuilder backup = new StringBuilder();
        StringBuilder output = new StringBuilder();
        boolean check = false;
        String input = sc.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') {
                check = true;
            }
            if (check) {
                sb.append(input.charAt(i));
                if (input.charAt(i) == '>') {
                    check = false;
                }
                output.append(sb.toString());
                sb = new StringBuilder();
            } else {
                backup.append(input.charAt(i));
                if (input.charAt(i) == ' ' || i == input.length() - 1) {
                    for (int j = backup.length() - 1; j >= 0; j--) {
                        if (backup.charAt(j) == ' ')
                            continue;
                        sb.append(backup.charAt(j));
                    }
                    output.append(sb.toString());
                    output.append(" ");
                    sb = new StringBuilder();
                    backup = new StringBuilder();
                }
            }
        }
        System.out.println(output);
    }
}