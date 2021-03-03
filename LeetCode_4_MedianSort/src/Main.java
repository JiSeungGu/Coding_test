import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static double findMedianSortedArrays(int[] nums1,int[] nums2 ) {
		
		//기존 방법 
		int Arrays1 = nums1.length;
		int Arrays2 = nums2.length;
		int len = Arrays1+Arrays2;
		
		int[] Temp = new int [len];
		int[] Test_Temp = new int [len];
		int position=0;
		for(int a : nums1)
		{
			Temp[position] = a;
			position++;
		}
		for(int a : nums2)
		{
			Temp[position] = a;
			position++;
		}
		
		// copy를 통한 방법
		System.arraycopy(nums1, 0, Test_Temp, 0, nums1.length);
		System.arraycopy(nums2, 0, Test_Temp, nums1.length, nums2.length);
			
		int[] a;
		 	
		// Stream.concat
		a = IntStream.concat(Arrays.stream(nums1),Arrays.stream(nums2)).toArray();
			
		Arrays.sort(Temp);
//		Arrays.sort(Test_Temp);
		System.out.println("Temp      :"+Arrays.toString(Temp));
		System.out.println("Test_Temp :"+Arrays.toString(Test_Temp));
		System.out.println("a         :"+Arrays.toString(a));
			
		System.out.println(len);
		if(len % 2 == 0)
			return (Temp[len/2-1]+Temp[len/2])/2.0;
		else 
			return Temp[len]/2;
	}		
	public static void main(String[] args) {
		int[] nums1 = {1,3};
		int[] nums2 = {2,4};
			
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}		
}			
			