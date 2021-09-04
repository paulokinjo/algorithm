package Progression;

/**
 * Generates a simple progression. By default: 0, 1, 2, ...
 */
public class Progression {
  protected long current;

  public Progression() {
    this(0);
  }

  public Progression(long start) {
    current = start;
  }

  public long nextValue() {
    long answer = current;
    advance();
    return answer;
  }

  protected void advance() {
    current++;
  }

  /**
   * Prints the next "n" values of the progression
   */
  public void printProgression(int n) {
    System.out.print(nextValue());
    for (int i = 1; i < n; i++) {
      System.out.print(" " + nextValue());
    }
    System.out.println();
  }
}
