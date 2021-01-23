import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

	
/**	
 * @author 지승구
 *	
 */ 
public class Main {
	public static int map[][];
	public static int location_num[][];
	public static boolean visit[][];
	
	public static int direct[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static int count=0;
	List<Integer> reuslt = new ArrayList<Integer>();
	
	public static int sum=1;
	public static void DFS(int x,int y) 
	{
		visit[x][y]=true;
		location_num[x][y]=count;
//		System.out.println("현재 좌표 "+x+","+y);
		for(int i=0;i<4;i++)
		{
//			System.out.println("    현재 x :"+x+" y축:"+y);
//			System.out.println("이동하는 x축 :"+direct[i][0]+" y축 :"+direct[i][1]);
			int move_x = x+direct[i][0];
			int move_y = y+direct[i][1];
//			System.out.println("현재 좌표 "+move_x+","+move_y);
										
			if(move_x>=0 && move_x < map.length && move_y>=0 && move_y < map.length)
			{							
				if(map[move_x][move_y]==1 && visit[move_x][move_y]==false)
				{						
					sum++;
//					System.out.println("다음턴의 좌표:"+move_x+","+move_y);
					DFS(move_x,move_y);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정사각형의 크기를 입력해주세요");
		int size = scan.nextInt();
		
		map = new int[size][size];
		location_num = new int[size][size];
		visit = new boolean[size][size];
		
//		Arrays.fill(visit, false);
		System.out.println(size+"크기에 맞는 집(1) 공백(0) 을 입력해주세요");
		for(int i=0;i<size;i++)
		{	
			for(int j=0;j<size;j++)
			{
				 map[i][j] = scan.nextInt();
				 location_num[i][j]=0;
				 visit[i][j] = false;
			}
		}
		System.out.println("뭐여 :"+map[0][0]);
		
		for(int i=0;i<size;i++)
		{	
			for(int j=0;j<size;j++)
			{
				if(map[i][j]==1 && visit[i][j]==false)
				{
					count++;
					DFS(i,j);
					System.out.println("sum개수는"+sum);
				}
				sum=1;
			}
		}
		
		for(int i=0;i<size;i++)
		{	
			for(int j=0;j<size;j++)
			{
				System.out.print(location_num[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("총 카운트"+count);
	}
}	