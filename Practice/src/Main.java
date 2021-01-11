import java.util.Scanner;
		
public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("돌의 수를 입력해주세요");
		int num = scan.nextInt();
		String player[] = {"SG","SK"};
		int i=0;
		boolean value = true;
		int count=0;
		while(num>1)
		{	
			System.out.println("=============================");
			System.out.println(player[i]+"의 턴");
			System.out.println("남은 돌 :"+num);
			while(value)
			{
				
				System.out.print("가져갈 갯수(1,3중에  하나의 숫자만 입력하세요) : ");
				count = scan.nextInt();
				if(count==1 || count==3)
				{
					value=false;
				}
			}
			num-=count;
			i++;
			if(i>=player.length)
			{
				i=0;
			}
			value=true;
		}
		System.out.println("승리 :"+(i-1<0?player[player.length-1]:player[i]));
	}		
}					
