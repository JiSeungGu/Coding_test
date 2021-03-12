import java.util.Arrays;


public class main {
	public static void quickSort(int[] arr) {
		sort(arr,0,arr.length-1);
	}

	public static void sort(int[] arr, int low,int high) {
		if(low >= high) return;
		
		int mid = partition(arr,low,high);
		int temp[]=new int[arr.length];
		int temp2[]=new int[arr.length];
		System.arraycopy(arr, 0, temp, 0, mid);
		System.out.println("왼쪽 부분"+Arrays.toString(temp));
		sort(arr,low,mid-1);
		sort(arr,mid,high);
	}
	
	public static int partition(int[] arr,int low,int high) {
		int pivot = arr[(low + high) / 2 ];
		System.out.println("pivot"+pivot);
		while(low <= high) {
			while(arr[low] < pivot) low++;
			while(arr[high] > pivot) high--;
			if(low <= high) {
				System.out.println("low위치"+arr[low]);
				System.out.println("high위치"+arr[high]);
				swap(arr,low,high);
				System.out.println(Arrays.toString(arr));
				low++;
				high--;
			}
		}
		System.out.println("반환되는 low :"+low);
		return low;
	}
	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,10,5,8,7,6,4,3,2,9};
		System.out.println(Arrays.toString(arr));
		System.out.println("정렬시작");
		quickSort(arr);
	}
}	
	