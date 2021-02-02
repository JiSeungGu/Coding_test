import java.util.Arrays;

public class Binary_Search {
	
	public static void main(String[] args) {
		
		int[] arr = {1,4,8,12,18,20,23,26,30};
		Arrays.sort(arr);
		
		System.out.println(binarySearch_recursion(arr, 0, arr.length-1, 4));
		System.out.println(binarySearch_loop(arr, 0, arr.length-1, 23));
		
	}
	
	public static int binarySearch_recursion(int[] arr,int start,int last,int no) {
		int mid = (int)(start+last)/2;
		
		if(arr[mid] == no) { 
			return mid; //순서를 반환하기 위한 mid
		}
		else if(arr[mid] > no) {
			last = mid - 1;
			return binarySearch_recursion(arr,start,last,no);
		}
		else {
			start = mid + 1;
			return binarySearch_recursion(arr,start,last,no);
		}
	}
	
	public static int binarySearch_loop(int[] arr,int start,int last,int no) {
		while(true) {
			int mid = (int)(start+last)/2;
			if(arr[mid]==no){
				return mid;
			} else if(arr[mid] > no) {
				last = mid - 1;
			} else {
				start = mid + 1;
			}
		}
	}
	
}
