import java.util.Arrays;

public class Main {
 	public static int firstMissingPosition(int[] A) {
   		
 		int n = A.length;
 		 
    	for (int i = 0; i < n; i++) {
    		while (A[i] != i + 1) {
    			if (A[i] <= 0 || A[i] >= n)
    				break;
    			
    			System.out.println(A[i]);
    			System.out.println(A[A[i]-1]);
                if(A[i]==A[A[i]-1])
                	break;
 
    			int temp = A[i];
    			A[i] = A[temp - 1];
    			A[temp - 1] = temp;
    			System.out.println(Arrays.toString(A));
    		}
    	}
 
    	for (int i = 0; i < n; i++){
    		if (A[i] != i + 1){
    			return i + 1;
    		}
    	}	
 
    	return n + 1;
 	}
 	public static void main(String[] args) {
 		int[] Find_Missing= {3,4,-1,1};
 		System.out.println(firstMissingPosition(Find_Missing));
 	}
} 
