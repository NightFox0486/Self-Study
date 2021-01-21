package ch4;

public class Exercise4_12 {
    public static void main(String[] args) {
        for (int i = 2; i < 10; i += 3) {
            for (int j = 1; j < 4; j++) {
                for (int k = i; k < i + 3 && k < 10; k++)
                    System.out.print(k + "*" + j + "=" + k * j + "\t");
                System.out.println();
            }
            System.out.println();
        }
    }
}