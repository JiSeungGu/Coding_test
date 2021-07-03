import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * @author 지승구
 *
 * 1.느낀점
 * 	1)DFS 방식이 아닌 BFS 방식으로 풀어야한다. 넓이 우선 탐색이기 때문에 
 *  2)굳이 1로 채우면서 count 값을 구하는 방법보다 그전에 있는 수에서 1씩더해주면 하루 증가가 된다..
 *  3) for으로 i j 를 계속 호출하는 방식이아닌 스택에 담고 나서 BFS를 호출해야한다.
 */

public class TEST {
	
	public static int map[][];
	public static boolean visit[][];
	
	//방향을 잡아 주기 위한 direct
	public static int direct[][] = {{0,1},{1,0},{-1,0},{0,-1}};
	
	//Queue에 들어갈 클래스 생성
	static class Box{
		int x,y;
		Box(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static int w;
	public static int h;
	public static int day=0;
	public static Queue<Box> q = new LinkedList<>();	
	
	public static int count=0;
	public static void BFS()
	{			
		while(!q.isEmpty())
		{
			count++;
			Box b = q.poll();
			visit[b.x][b.y]= true;
			for(int i=0;i<4;i++)
			{
				System.out.println("for문 횟수");
				int move_x = b.x+direct[i][0];
				int move_y = b.y+direct[i][1];
				if(move_x >= 0 && move_x <map.length && move_y >= 0 && move_y <map[0].length)
				{	
					if(map[move_x][move_y]== 0 && visit[move_x][move_y]==false)
					{
						System.out.println("계속도나");
						q.add(new Box(move_x,move_y));
						map[move_x][move_y] = map[b.x][b.y]+1;
						for(int k=0;k<h;k++)
						{
							for(int j=0;j<w;j++)
							{
								System.out.print(map[k][j]+"   ");
							}
							System.out.println();
						}
					}
				}
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("상자 부피를 입력하세요");
		w = scan.nextInt();
		h = scan.nextInt();
		map = new int[h][w];
		visit = new boolean[h][w];
		System.out.println("0:익지않은 토마토, 1:익은 토마토, -1:토마토가 없는 칸");
		for(int i=0;i<h;i++)
		{
			for(int j=0;j<w;j++)
			{
				map[i][j] = scan.nextInt();
				visit[i][j] = false;
			}
		}
		for(int i=0;i<h;i++)
		{
			for(int j=0;j<w;j++)
			{
				if(map[i][j] == 1 && visit[i][j]==false)
				{
					System.out.println("돈다");
					q.add(new Box(i,j));
				}
			}
		}
		BFS();
	
		for(int i=0;i<h;i++)
		{
			for(int j=0;j<w;j++)
			{
				if(map[i][j]==-1)
				{
					System.out.println(-1);
					return;
				}
				day = Math.max(day, map[i][j]);
			}
		}
		System.out.println(day-1+"일");
		System.out.println("count : "+count);
	}
}
