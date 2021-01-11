import java.util.Scanner;

public class Main4 {
	
	
	static int arr[] = {0,0,0,0,0,0,0,0,0,0};
	static String[] temp;
	static boolean bcheck=true;
	static int number=0;
	public static boolean value_check(int value)
	{
		if(value>=100 && value<=1000)
		{
			bcheck=false;
		}
		
		return bcheck;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int value_a=0,value_b=0,value_c=0;

		while(bcheck)
		{
			System.out.println("세개의 자연수를 입력해주세요 (자연수는 100보다 같거나 크도 1000보다 작습니다)");
			value_a = scan.nextInt();
			value_b = scan.nextInt();
			value_c = scan.nextInt();
			value_check(value_a);
			value_check(value_b);
			value_check(value_c);
		}
		String sum = String.valueOf((value_a*value_b*value_c));
		
		temp = sum.split("");
		for(String i:temp)
		{
			arr[Integer.parseInt(i)]+=1;
		}
		
		for(int j:arr)
		{
		
			System.out.println("순서 "+number+":"+j);
			number++;
		}
	}	
}		
