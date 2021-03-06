import static org.junit.Assert.assertEquals;

import java.util.*;

public class Median {
	public static double median(Scanner scanner) {
		Stack<Integer> a = new Stack<Integer>();
		while(scanner.hasNextInt()){
			a.push(scanner.nextInt());
		}
		int[] A = new int[a.size()];
		int i = 0;	
		while(!a.isEmpty()){
			A[i] = a.pop();
			i++;
		}
		Arrays.sort(A);
		if(A.length%2==1){
			return A[A.length/2];
		} else return ((double) A[A.length/2-1] + A[A.length/2 ])/2;
	}
}
