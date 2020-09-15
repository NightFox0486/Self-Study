package ch6;

/*class Car {
    String color;
    String gearType;
    int door;

    Car() {
        this("white", "auto", 4);
    }

    Car(String color) {
        this(color, "auto", 4);
    }

    Car(String c, String g, int d) {
        this.color = c;
        this.gearType = g;
        this.door = d;
    }
}*/

public class CarTest2 {
    public static void main(String[] args) {
        Car c1 = new Car();
        // Car c2 = new Car("blue");
        System.out.println("c1ě color=" + c1.color + ", gearType=" + c1.gearType + ", door=" + c1.door);
        // System.out.println("c2ě color=" + c2.color + ", gearType=" + c2.gearType +
        // ", door=" + c2.door);
    }
}