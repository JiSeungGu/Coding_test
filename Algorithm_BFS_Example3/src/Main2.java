import java.awt.Point;
import java.util.LinkedList;
import java.util.Scanner;
				
public class Main2 {
	public static String map[][];
	public static boolean visited[][];
	
	//시간 저장용 
	public static int time[][];
	public static int time2;
	public static int result;
	
	
	public static int direct_x[] = {1,-1,0,0};
	public static int direct_y[] = {0,0,1,-1};
				
	public static int max=0;	
	public static int temp=0;
	
	
	public static int h;
	public static int w;
	
	public static void initBool() {
		for (int i = 0 ; i < 5; i++){
			for (int j = 0; j < 7 ; j++) {
				visited[i][j] = false;				
			}
		}
	}
	static class Treasure{
		int x,y,time;
		
		Treasure(int x,int y,int time){
			this.x = x;
			this.y = y;
			this.time =time;
		}
	}
	public static int max(int a,int b)
	{
		return a>b?a:b;
	}
	public static void bfs(int x,int y)
	{			
		int cnt = -1;
		java.util.Queue<Treasure> q = new LinkedList<>();
//		Point p = new Point(x,y);
		q.add(new Treasure(x,y,0));
		initBool();
		visited[x][y]=true;
//		System.out.println(max);
		max++;	
		while(!q.isEmpty()) {
			Treasure t = q.poll();
			result = max(result,t.time);
			cnt++;
			for(int i=0;i<4;i++)
			{
				int move_x = t.x+direct_x[i];
				int move_y = t.y+direct_y[i];
				if(move_x>=0 && move_x< map.length && move_y>=0 && move_y< map[0].length)
				{
					if(map[move_x][move_y].equals("L") && visited[move_x][move_y]==false)
					{
						q.add(new Treasure(move_x,move_y,t.time+1));
						time[move_x][move_y]=t.time+1;
						visited[move_x][move_y]=true;
					}
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
				
		max=0;
		for(int i=0;i<h;i++)
		{		
			for(int j=0;j<w;j++)
			{	
				if(temp<max)
				{
					temp=max;
				}
				if(map[i][j].equals("L"))
				{
					bfs(i,j);
					
				} 
			}	
		}		
		System.out.println("최장 시간 :"+result);
		System.out.println("제발"+time);
		
		
		for(int i=0;i<h;i++)
		{		
			for(int j=0;j<w;j++)
			{	
				System.out.print(time[i][j]+" ");
			}	
			System.out.println();
		}		
	}		 	 
}			 	
		