import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 지승구
 *
 */
/*
 *  느낀점
 *  1. 문제가 신박하다.
 *  2. 경우의수가 여러개다.
 */
public class Main {
	
	static int temp=0;
	public static void Binary_Search(int arr[],int Hope)
	{
		int i=0;
		int Minus=0;
		while(true)
		{
			i++;
			if(temp>=Hope)
			{
				break;
			}
			else if(arr[arr.length-i]!=arr[arr.length-1-i])
			{
//				System.out.println("뭐지"+temp);
				Minus = arr[arr.length-i] - arr[arr.length-1-i];
				if(Minus >= Hope)
				{
					arr[arr.length-i] -= Hope;
					System.out.println(arr[arr.length-i]);
					break;
				}
				temp += Minus;
				arr[arr.length-i]=arr[arr.length-i] - Minus;
				Arrays.sort(arr);
				Binary_Search(arr, Hope);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int Quantity = scan.nextInt();
		int Hope = scan.nextInt();
		int[] Wood = new int[Quantity];
		
		for(int i=0;i<Wood.length;i++)
		{
			Wood[i]= scan.nextInt();
		}
		Arrays.sort(Wood);
		Binary_Search(Wood, Hope);

		System.out.println(Wood[Wood.length-1]);
	}	
}		
