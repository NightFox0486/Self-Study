package baekjoon;

import java.util.Scanner;

public class b17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder braket = new StringBuilder();
        StringBuilder backup = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        StringBuilder output = new StringBuilder();
        boolean check = false;
        String input = sc.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') {
                if (backup.length() != 0) {
                    for (int j = backup.length() - 1; j >= 0; j--) {
                        if (backup.charAt(j) == ' ')
                            continue;
                        temp.append(backup.charAt(j));
                    }
                    output.append(temp.toString());
                    temp = new StringBuilder();
                    backup = new StringBuilder();
                }
                check = true;
            }
            if (check) {
                braket.append(input.charAt(i));
                if (input.charAt(i) == '>') {
                    check = false;
                }
                output.append(braket.toString());
                braket = new StringBuilder();
                continue;
            }
            if (!check) {
                backup.append(input.charAt(i));
                if (input.charAt(i) == ' ' || i == input.length() - 1) {
                    for (int j = backup.length() - 1; j >= 0; j--) {
                        if (backup.charAt(j) == ' ')
                            continue;
                        temp.append(backup.charAt(j));
                    }
                    output.append(temp.toString());
                    output.append(" ");
                    temp = new StringBuilder();
                    backup = new StringBuilder();
                }
            }
        }
        System.out.println(output);
    }
}