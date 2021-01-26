import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * @author 지승구
 *
 */
public class number_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Boolean play = true;
		DecimalFormat df = new DecimalFormat("#.##");
				
		while(play)
		{
			double result = 0;
			System.out.println("숫자 A를 입력하시오");
			double a = scan.nextDouble();
			
			System.out.println("숫자 B를 수집하시오");
			double b = scan.nextDouble();
			
			System.out.println("수행할 연산을 입력하시오(+,-,*,/) 종료:exit");
			String Symbols = scan.next();
			switch (Symbols) {
			case "+": result=a+b;
				break;
			case "-": result=a-b;
				break;
			case "*": result=a*b;
				break;
			case "/":
				if(b==0)
				{
					System.out.println("0으로 나눌 수 없습니다. 다시입력해주세요");
					continue;
				}
				result=a/b;
				break;
			case "exit":
					System.out.println("종료되었습니다.");
					play=false;
				break;
			default:
				System.out.println("올바른 입력이 아닙니다.");
			}
			System.out.println("결과 :"+df.format(result));
			System.out.println("----------------------");
		}
	}
}
