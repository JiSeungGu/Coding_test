import java.util.Scanner;

/**
 * @author 지승구
 *
 */
public class number_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("입력 :");
		int number = scan.nextInt();
		
		System.out.print("출력 :");
		reverse(number);
	}
	public static int reverse(int n) {
		String reverse = String.valueOf(n);
		String temp="";
		for(int i=0;i<reverse.length();i++)
		{
			temp += reverse.charAt((reverse.length()-1)-i);
		}
		System.out.println(Integer.parseInt(temp));
		
		return 0;
	}
}
