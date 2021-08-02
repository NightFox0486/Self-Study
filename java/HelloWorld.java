//import test.test1;

public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("HelloWorld");
    String sum;
    for (int i = 0; i < 10; i++) {
      sum = i + "test";
      System.out.println(sum + i);
    }
    int[] num = new int[15];
    String[] test = new String[15];
    for (int i = 0; i < test.length; i++) {
      num[i] = i;
      test[i] = "testcase" + i;
      System.out.println(num[i] + " " + test[i]);
    }
    // test1 mytest1 = new test1();
  }
}
