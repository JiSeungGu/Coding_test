import java.util.Scanner;

public class Harshard {
	private int sum =0;
	private String arr[];
	public boolean harshard_Check(int input_num)
	{
		boolean check;
		//람다식으로 푸는 방법 
//		Integer.toString(input_num).chars().forEach(c -> sum+=c - '0');
		arr=String.valueOf(input_num).split("");
		for(String i:arr)
		{
			sum+=Integer.parseInt(i);
		}
		if(input_num%sum==0)
		{
			check=true;
		}
		else
			check=false;
		
		return check;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Harshard hs = new Harshard();
		
		System.out.print("수를 입력해 주세요 :");
		int input_num = scan.nextInt();
		
		System.out.println(hs.harshard_Check(input_num));
	}
}
	