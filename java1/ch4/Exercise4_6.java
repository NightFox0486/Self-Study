package java1.ch4;

public class Exercise4_6 {
    public static void main(String[] args) {
        for (int i = 1; i < 7; i++)
            for (int j = 1; j < 7; j++)
                if (i + j == 6)
                    System.out.println(i + " : " + j);
    }
}