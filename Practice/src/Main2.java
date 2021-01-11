import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
//		String card[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String card[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13"};
		List<String> list = new ArrayList<String>();
		int i=0;
		System.out.print("카드 개수:");
		int card_num = scan.nextInt();
	
		System.out.print("카드의 합 :");
		int card_max = scan.nextInt();
		int min=card_max;
		
		
		int card1=0;
		int card2=0;
		int card3=0;
		
		while(card_num!=0) 
		{
			int display_card=(int)(Math.random()*13);
			list.add(card[display_card]);
			--card_num;
			i++;
		}
//		System.out.print("사이즈"+list.size());
						
		for(String a: list)
		{				
			System.out.print(a+" ");
		}				
		System.out.println();
		for(int j=0;j<list.size()-2;j++)
		{				
			for(int k=j+1;k<list.size()-1;k++)
			{			
				for(int q=k+1;q<list.size();q++)
				{		
					int a=Integer.parseInt(list.get(j))+Integer.parseInt(list.get(k))+Integer.parseInt(list.get(q));
					if(card_max>=a)
					{	
						System.out.println(list.get(j)+" "+list.get(k)+" "+list.get(q)+" 총 :"+a);
						System.out.println("총 값:"+a);
						int count = card_max-a;
						if(min>=count) 
						{
							min = count;
							card1=j;
							card2=k;
							card3=q;
						}
					}	
				}
			}
		}
		System.out.println();
		System.out.println(list.get(card1)+" "+list.get(card2)+" "+list.get(card3));
	}
}
