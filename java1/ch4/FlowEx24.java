package java1.ch4;

public class FlowEx24 {
    public static void main(String[] args) throws java.io.IOException {
        int input = 0;

        System.out.println("문장을 입력하세요");
        System.out.println("입력을 마치려면 x를 입력하세요.");
        do {
            input = System.in.read();
            System.out.print((char) input);
        } while (input != -1 && input != 'x');
    }
}