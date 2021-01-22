import java.util.Scanner;
				
public class Main {
	public static String map[][];
	public static boolean visited[][];
	
	//시간 저장용 
	public static int time[][];
	
	public static int direct_x[] = {1,-1,0,0};
	public static int direct_y[] = {0,0,1,-1};
				
	public static int max=0;	
	public static int temp=0;
	static void DFS(int x,int y)
	{			
		visited[x][y]=true;
//		System.out.println(max);
		max++;	
		for(int i=0;i<4;i++)
		{		
			int move_x = x+direct_x[i];
			int move_y = y+direct_y[i];
			if(move_x>=0 && move_x< map.length && move_y>=0 && move_y< map[0].length)
			{	
//				System.out.println("move_x :"+move_x+" move_y :"+move_y);
				System.out.println("땅이냐 물이냐 "+map[move_x][move_y]);
				if(map[move_x][move_y].equals("L") && visited[move_x][move_y]==false)
				{
					time[move_x][move_y] = time[x][y]+1;
					System.out.println("안돌아?");
					DFS(move_x,move_y);
				}
			}	
		}		
	}			
				
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("보물 지도의 가로 세로 크기 입력");
		int h = scan.nextInt();
		int w = scan.nextInt();
				
		map = new String[h][w];
		visited = new boolean[h][w];
		time = new int[h][w];
				
		System.out.println("L(육지),W(바다)를 가로 세로에 맞게 입력해주세요");
		for(int i=0;i<h;i++)
		{	 	
			for(int j=0;j<w;j++)
			{	
			 	map[i][j]= scan.next();
			 	visited[i][j]=false;
			 	time[i][j]=0;
			}	
		}		
		System.out.println("출력 나오려나 ");
		for(int i=0;i<h;i++)
		{	 	
			for(int j=0;j<w;j++)
			{	
				System.out.print(map[i][j]);
			}	
			System.out.println();
		}		
				
		for(int i=0;i<h;i++)
		{		
			for(int j=0;j<w;j++)
			{	
				if(temp<max)
				{
					temp=max;
				}
				max=0;
				if(map[i][j].equals("L") && visited[i][j]==false)
				{
					DFS(i,j);
				} 
			}	
		}		
		System.out.println("최장 시간 :"+temp);
		int max2=0;
		for(int i=0; i<h;i++)
		{
			for(int j=0;j<w;j++)
			{
				System.out.print(time[i][j]+" ");
				if(time[i][j]>max2)
				{
					max2 = time[i][j];
				}
			}
			System.out.println();
		}
		System.out.println("제발"+max2);
	}		 	
}			 	
		