import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author 지승구
 *
 *  * 느낀점
 *  1. 바다가 미리 증가할 곳을 어떻게 알 수 있을까..
 *  
 */
public class main {
	public static Queue<position> ani;
	public static Queue<position> water;
	public static String map[][];
	public static boolean visit[][];
	
	//방향을 잡아 주기 위한 direct
	public static int direct[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	
	
	//Queue에 들어갈 클래스 생성
	static class position{
		int x,y;
		position(int x,int y){
			this.x = x;
			this.y = y;
		}	
	}		
	public void BFS() {
		while(!ani.isEmpty() && !water.isEmpty())
		{			
			position hedgehog = ani.poll();
			position water_place =  water.poll();
					
			for(int i=0;i<4;i++)
			{		
				int move_x = hedgehog.x + direct[i][0];
				int move_y = hedgehog.y + direct[i][1];
				
				int water_move_x = water_place.x + direct[i][0];
				int water_move_y = water_place.y + direct[i][1];
						
				if(water_move_x >= 0 && water_move_x < map.length && water_move_y >=0 && water_move_y <map[0].length)
				{		
					if(map[water_move_x][water_move_y].equals(".") && visit[water_move_x][water_move_y] ==false)
					{	
						water.add(new position(water_move_x, water_move_y));
						
						map[water_move_x][water_move_x] ="*";
						
					}	
				}		
				if(move_x >= 0 && move_x < map.length && move_y >=0 && move_y<map[0].length)
				{	
					if(map[move_x][move_y].equals(".") && visit[move_x][move_y] == false)
					{
						
					}
				}
				
			}
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		main escape = new main();
		ani = new LinkedList<>();
		water = new LinkedList<>(); 
		System.out.println("가로 세로 크기 입력");
		int w = scan.nextInt();
		int h = scan.nextInt();
			
		map = new String[h][w];
		visit = new boolean[h][w];
			
		for(int i=0;i<h;i++)
		{	
			for(int j=0;j<w;j++)
			{
				map[h][w] = scan.nextLine();
				visit[h][w] = false;
			}
		}	
			
		for(int i=0;i<h;i++)
		{	
			for(int j=0;j<w;j++)
			{
				if(map[h][w].equals("S"))
				{
					ani.add(new position(h,w));
				}
				if(map[h][w].equals("*"))
				{
					water.add(new position(h,w));
				}
			}
		}	
		escape.BFS();
	}
}			
