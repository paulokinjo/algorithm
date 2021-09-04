package Progression;

public class TestProgression {
  public static void main(String[] args) {
    Progression prog;
    
    System.out.println("Arithmetic progression with default increment: ");
    prog = new ArithmeticProgression();
    prog.printProgression(10);

    System.out.println("Arithmetic progression with increment 5: ");
    prog = new ArithmeticProgression(5);
    prog.printProgression(10);

    System.out.println("Geometric progression with default base: ");
    prog = new GeometricProgression();
    prog.printProgression(10);

    System.out.println("Geometric progression with base 3: ");
    prog = new GeometricProgression(3);
    prog.printProgression(10);

    System.out.println("Fibonacci progression default start values: ");
    prog = new FibonacciProgression();
    prog.printProgression(10);

    System.out.println("Fibonacci progression with start values 4 and 6: ");
    prog = new FibonacciProgression(4, 6);
    prog.printProgression(10);

    System.out.println("Fibonacci progression with start values 13 and 21: ");
    prog = new FibonacciProgression(13, 21);
    prog.printProgression(10);
  }
}
