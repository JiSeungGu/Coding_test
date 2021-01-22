import java.util.Scanner;
//백준 알고리즘 2606번  바이러스 (DFS 이용)
public class Main {
	static int cnt=0;

	static void dfs(int[][] a,boolean[] check,int v)
	{
		if(check[v]==true) return;
	
		check[v]= true;
		cnt++;
		System.out.println("사이즈 :"+a[v].length);
		for(int i=0;i<a[v].length;i++)
		{
			if(a[v][i] == 1 && !check[i] )
			{
				dfs(a,check,i);
			}
		}
	}
	public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			
			int n = scan.nextInt();
			int e = scan.nextInt();
			
			int a[][] = new int[n+1][n+1];
			boolean check[] = new boolean[n+1];
			
			for(int i=0;i<e;i++)
			{
				int v1 = scan.nextInt();
				int v2 = scan.nextInt();
				
				a[v1][v2] = 1;
				a[v2][v1] = 1;
			}
			dfs(a,check,1);
			System.out.println(cnt-1);
		}	
	}	
