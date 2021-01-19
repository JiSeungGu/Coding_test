import java.util.Scanner;

public class Main {

	/*
	 *  BFS를 사용하여 문제 풀이
	 *  재귀함수를 사용하였음
	 * 
	 */
	public static int[][] map;
	public static boolean[][] Visited;
	
	//이중배열로 풀수도 있을거같은데..
	static final int nx[] = {-1,0,1,0,-1,1,-1,1};
	static final int ny[] = {0,1,0,-1,1,1,-1,-1};
	static final String way[] = {"←","↓","→","↑","↙","↘","↖","↗"};
				
	//DFS STACK을 사용할 수도 ,배열을 사용할 수도 있나본데
	static void DFS(int x,int y)
	{			
		// 도착했으니까 true
		Visited[x][y] = true;
		//좌표는 8번이최대
		for(int i=0;i<8;i++)
		{		
			int move_x = x + nx[i];
			int move_y = y + ny[i];
			// x좌표는 0부터 visited.length의 사이  y좌표는  0 부터 visited[0].length=세로줄 의 사이
			if(move_x >= 0 && move_x < Visited.length && move_y >= 0 && move_y < Visited[0].length)
			{	
				if(Visited[move_x][move_y]==false && map[move_x][move_y] == 1)
				{
					System.out.print("좌표 "+"("+x+","+y+")");
					System.out.println("이동한 자리 는 : 0이면 강 1이면 땅 :"+map[move_x][move_y]);
					System.out.println(way[i]);
					DFS(move_x, move_y);
				}
			}	
		}		
				
	}			
	public static void main(String[] args) {
				
	Scanner scan = new Scanner(System.in);
				
	System.out.println("지도의 크기를 입력해주세요 x,y.");
	System.out.print("x길이");
	int w = scan.nextInt();
	System.out.print("y길이");
	int h = scan.nextInt();
				
	int land_count=0;
	if(w!=0 && h!=0)
	{			
		System.out.println("바다는 0 육지는 1 입니다.");
				
		map= new int[h][w];
		Visited = new boolean[h][w];
				
		for(int i=0;i<h;i++)
		{		
			for(int j=0;j<w;j++)
			{	
				map[i][j] = scan.nextInt();
				//방문한곳은 true 방문하지 않은곳은 false
				Visited[i][j] = false;
			}	
		}	
		System.out.println("입력은 끝나고 1.1자리 값은:"+map[0][0]);
		land_count=0;
		for(int i=0;i<h;i++)
		{		
			for(int j=0;j<w;j++)
			{	
				if(Visited[i][j]==false && map[i][j]==1)
				{
					System.out.println("땅인부분은 "+"("+i+","+j+")");
					land_count++;
					DFS(i,j);
				}
			}	
		}		
		System.out.println("개수 : "+land_count);
		}
	}
}
