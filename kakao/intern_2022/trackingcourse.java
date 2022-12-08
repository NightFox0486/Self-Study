package kakao.intern_2022;

public class trackingcourse {
  static class TestCase{
    int n;
    int[][] paths;
    int[] gates;
    int[]summits;
    TestCase(int n, int[][] paths, int[] gates, int[] summits) {
      this.n = n;
      this.paths = paths;
      this.gates = gates;
      this.summits = summits;
    }
  }
  public static void main(String[] args) {
    int[] answer;
    TestCase[] testCase = new TestCase[4];
    testCase[0] = new TestCase(6, [[1, 2, 3], [2, 3, 5], [2, 4, 2], [2, 5, 4], [3, 4, 4], [4, 5, 3], [4, 6, 1], [5, 6, 1]], 
    answer = solution();
  }

  public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
    int[] answer = {};
    return answer;
}
}
