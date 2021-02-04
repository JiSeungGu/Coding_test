import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	static int[] company;
	static int budget;
	static int gap;
	public static void Binary_Search() {
		int first=1;
		int end= budget;
		
		int middle =(int)(last+first)/2;
		
		while(first<=last)
		{
			if(curculate(middle)>budget)
			{
				gap=middle;
				last = middle-1;
				Binary_Search(last, first);
			}
			else 
			{
				gap=middle;
				first = middle+1;
				Binary_Search(last, first);
			}
		}
		System.out.println("금액 "+gap);
	}
	public static int curculate(int money) {
		int total=0;
		for(int i=0;i<company.length-1;i++)
		{
			if(money > company[i])
			{
				total+=company[i];
			}
			else 
				total+=money;
		}
		
		return total;
	}
	public static void main(String[] args) throws IOException {
    
		Scanner scan = new Scanner(System.in);
		
		int amount = scan.nextInt();
		company = new int[amount];
		
		for(int i=0;i<=company.length-1;i++)
		{
			company[i] = scan.nextInt();
		}
		budget = scan.nextInt();
		
		Arrays.sort(company);
		Binary_Search(company[company.length-1],0);
		
		
	}	
}		
	