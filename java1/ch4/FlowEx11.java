package ch4;

public class FlowEx11 {
    public static void main(String[] args) {
        int score = 88;
        char grade = ' ';

        switch (score / 5) {
            case 20:
            case 19:
                grade = 'A';
                break;
            case 18:
                grade = 'B';
                break;
            case 17:
                grade = 'C';
                break;
            case 16:
                grade = 'D';
                break;
            default:
                grade = 'F';
        }
        System.out.println("당신의 학점은 " + grade + "입니다.");
    }
}