package java1.ch6;

class SutdaCard {
    int num;
    boolean isKwang;

    public SutdaCard() {
        this((int) (Math.random() * 10) + 1, (int) (Math.random() * 2) == 0);
    }

    public SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    String info() {
        return num + ", " + isKwang;
    }
}

public class Exercise6_2 {
    public static void main(String[] args) {
        SutdaCard card1 = new SutdaCard(3, false);
        SutdaCard card2 = new SutdaCard();

        System.out.println(card1.info());
        System.out.println(card2.info());
    }
}