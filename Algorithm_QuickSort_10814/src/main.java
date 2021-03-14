import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class main {
	
	static class Person {
		int age;
		String name;
		Person(int age,String name){
			this.age = age;
			this.name = name;
	}
	public static void quickSort(Person[] arr) {
		sort(arr,0,arr.length-1);
	}

	public static void sort(Person[] arr, int low,int high) {
		if(low >= high) return;
		
		int mid = partition(arr,low,high);
		sort(arr,low,mid-1);
		sort(arr,mid,high);
	}
	
	public static int partition(Person[] arr,int low,int high) {
		Person pivot = arr[(low + high) / 2 ];
//		System.out.println("나오나"+pivot);
		System.out.println("pivot"+pivot);
		while(low <= high) {
			while(arr[low].age < pivot.age) low++;
			while(arr[high].age > pivot.age) high--;
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
	public static void swap(Person[] arr,int i,int j){
		int age_temp = arr[i].age;
		String name_temp = arr[i].name;
				
		arr[i].age = arr[j].age;
		arr[j].age = age_temp;
		
		arr[i].name = arr[j].name;
		arr[j].name = name_temp;
	}
	
		
	public static  StringBuilder sb = new StringBuilder();
		
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Person[] arr = new Person[n];
        for(int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            int age = Integer.parseInt(s[0]);
            String name = s[1];
            arr[i] = new Person( age, name);
        }
        quickSort(arr);
        for(Person p : arr) {
            sb.append(p.age + " " + p.name + "\n");
        }
        System.out.println(sb);
	}
	    
	}
}	
	