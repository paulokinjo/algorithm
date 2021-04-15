import java.util.*;

public class SubArrays {
  public static void main(String args[] ) throws Exception {
    int[] values = new int[]{4, 4, 2, 1};
		findAllSubArrays(values); 
  }

  public static void findAllSubArrays(int[] arr) {
    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr.length; j++) {
        System.out.println(i + "," + j);
      }
    }
  }
}