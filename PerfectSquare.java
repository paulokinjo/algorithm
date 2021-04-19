import java.util.*;
import java.util.stream.IntStream;

public class Code {
  static int minCost = Integer.MAX_VALUE;
  public static void main(String[] args) {
		int testCase[][] = {{5, 3, 4}, {1, 5, 8}, {6, 4, 2}};        
    
    formingMagicSquare(testCase);
    
    // expected result = 7
    System.out.println(minCost);
  }
  
  static int formingMagicSquare(int[][] s) {
    int[] digits = IntStream.range(1, 10).toArray();
		int [][] targetSquare = new int [3][3];
    int initialIndex = 0;
    
    depthFirstSearch(digits, initialIndex, targetSquare, s);
    
    return minCost;
  }
  
  static void depthFirstSearch(int[] digits, int currentIndex, int [][] targetSquare, int[][] s) {
    if(currentIndex > digits.length) return;
    
    if(currentIndex == digits.length) {
      int index = 0;
      int currentCost = 0;
      for(int i = 0; i < targetSquare.length; i++) {
        for(int j = 0; j < targetSquare[0].length; j++) {
          targetSquare[i][j] = digits[index++];
          currentCost += Math.abs(targetSquare[i][j] - s[i][j]);
        }
      }
      
      if(isMagicSquare(targetSquare, 15)) {
        minCost = Math.min(currentCost, minCost);
      }
    }
    
    for(int i = currentIndex; i < digits.length; i++) {
      swap(digits, i, currentIndex);
      
      depthFirstSearch(digits, currentIndex + 1, targetSquare, s);
      
      swap(digits, i, currentIndex);
    }
  }
  
  static boolean isMagicSquare(int[][] s, int targetSum) {
    for(int i = 0; i < s.length; i++) {
      int rowSum = 0;
      int colSum = 0;
      for(int j = 0; j < s[0].length; j++) {
        rowSum += s[i][j];
        colSum += s[j][i];
      }
      
      if(rowSum != targetSum || colSum != targetSum) return false;
    }
    

    if(sumMainDiagonal(s) != targetSum) return false;
    if(sumSecondaryDiagonal(s) != targetSum) return false;
    
    return true;
  }
  
  static int sumMainDiagonal(int[][] s) {
    int mainDiagonalSum = 0;
    int m = 0, n = 0;
    while(m < s.length && n < s[0].length) {
      mainDiagonalSum += s[m][n];
      m++;
      n++;
    }
    
    return mainDiagonalSum;
  }
  
  static int sumSecondaryDiagonal(int[][] s) {
    int secondaryDiagonalSum = 0;
    int m = 0, n = s[0].length - 1;
    while(m < s.length && n >= 0) {
      secondaryDiagonalSum += s[m][n];
      m++;
      n--;
    }
    
    return secondaryDiagonalSum;
  }
  
  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
