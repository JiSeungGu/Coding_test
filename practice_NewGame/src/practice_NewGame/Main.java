package practice_NewGame;
	
import java.util.Scanner;

	
public class Main {
	// 5 * 5 형태의 체스판 생성
	private static String[][] Chess_Board = new String[5][5];
	
	// 체스 말 
	private static String[][] Chess = new String[5][5];
	
	// 체스 말 방향
	private static String[] direction = {"→","←","↑","↓"};
	private static String[] direction_way = {"0,1","0,-1","-1,0","1,0"};
	
	// 체스 말 위치 표시
	private static String[] chess_location;
	
	// 초기화 메소드
	public String[][] init_Board(String[][] board)
	{
		int i=0;
		int j=0;
		while(true)
		{
			if(j>=5){
				i++;
				j=0;
			}
			if(i==5){
				break;
			}
			Chess_Board[i][j]="흰색";
			j++;
		}
		return board;
	}	
		
	// 체스판 말의 수에 따른 방향과,위치 선택
	public void init_Chess(int horse)
	{	
		int count=1;
		int i,j;
		String name="";
		
		//체스판 말의 갯수에 따른 위치를 저장하기위해 배열 크기  생성 
		chess_location = new String[horse];
		
		while(horse>=count)
		{
			i = (int)(Math.random()*5);
			j = (int)(Math.random()*5);
			name = count+"번말";
			int direct_ran = (int)(Math.random()*4);
			name += direction[direct_ran];
			if(Chess[i][j]==null)
			{
				Chess[i][j]=name;
				chess_location[count-1]= ""+i+","+j;
				count++;
			}
		}
	}
	
	// 빨간색, 파란색갈에 대한 체스판 UPDATE
	public void update_Chess_Board(int red,int blue)
	{
		int i,j;
		while(red!=0 || blue!=0)
		{
			if(red!=0)
			{
				i = (int)(Math.random()*5);
				j = (int)(Math.random()*5);
				if(Chess_Board[i][j].equals("흰색")) 
				{
					Chess_Board[i][j]="빨강";
					red-=1;
				}
				else
					continue;	
			}
			if(blue!=0)
			{
				i = (int)(Math.random()*5);
				j = (int)(Math.random()*5);
				if(Chess_Board[i][j].equals("흰색")) 
				{
					Chess_Board[i][j]="파랑";
					blue-=1;
				}
				else 
					continue;
			}
		}
	}
	//현재 현황판 
	public void status_board()
	{
		// 체스말 현황판 표시 
		System.out.println("=======================");
		for(int i=0;i<=4;i++)
		{
			for(int j=0;j<=4;j++)
			{
				if(Chess[i][j]==null)
					System.out.print("    "+Chess_Board[i][j]+"    ");
					
				if(Chess[i][j]!=null)
					System.out.print("    "+Chess[i][j].trim()+"");
			}
			System.out.println();
		}
		System.out.println("=======================");
	}
	//범위 밖으로 나갔는지 확인하는 부분
	public boolean check_outOfIndex(int x,int y){
		boolean out_check=false;
		
		if(x>=5 || x<0 || y>=5 || y<0)
		{
			out_check=true;
		}
			
		return out_check;
	}
	
	//파랑색 구역
	public String blue_Zone(String name,int count)
	{
		
//		name = name.substring(name.indexOf(""+count)+3,name.indexOf(""+count)+4);
		String first_name=name.substring(0,name.indexOf(""+count)+2);
		String middle=name.substring(name.indexOf(""+count)+3,name.indexOf(""+count)+4);
		String second_name=name.substring(name.indexOf(""+count)+4,name.length());
		
		System.out.println("앞 말:"+first_name);
		System.out.println("중간 말:"+middle);
		System.out.println("뒷 말:"+second_name);
		
		switch (middle) {
		case "→":
			middle="←";
			break;
		case "←":
			middle="→";
			break;
		case "↑":
			middle="↓";
			break;
		case "↓":
			middle="↑";
			break;
		}
		name=first_name+middle+second_name;
		System.out.println("블루존 메소드 :"+name);
		return name;
	}
	//빨강색 구역 
	public String red_Zone(String name)
	{
		System.out.println("레드존 입성");
		String change_name="";
		String[] switch_value;
		String temp="";
		switch_value = name.split(",");
		if(switch_value.length>=1)
		{
			for(int i=0;i<(switch_value.length)/2;i++)
			{
				int max=switch_value.length-i-1;
				temp = switch_value[i];	
				switch_value[i]=switch_value[max];
				switch_value[max]=temp;
			}
			
			for(String i:switch_value)
			{
				change_name+=i;
			}
		}
		else
			change_name=name;
		
		return change_name;
	}
	public String change_direct(String name,String way)
	{
		System.out.println("화살표 확인"+name);
		name = name.substring(0,name.length()-1);
		System.out.println("화살표 더블 	확인"+name);
		switch (way) {
		case "→":
			name+="←";
			break;
		case "←":
			name+="→";
			break;
		case "↑":
			name+="↓";
			break;
		case "↓":
			name+="↑";
			break;

		}
		
		System.out.println("화살표 세번	확인"+name);
		return name;
	}
	//게임시작
	public void game_paly()
	{
		String chess_name;

		//현재 좌표
		String[] xy;
		int x;
		int y;
		
		//이동해야하는 좌표
		String[] move_xy;
		int move_x;
		int move_y;
		
		//범위 밖인지 확인하는 부분
		boolean check;
		
		//몆번째 말인지 확인을위한 부분
		int count=0;
			//체스말 순서대로 게임플레이
			for(String location:chess_location)
			{
				//체스 위치 표시
				status_board();
				
				xy=location.split(",");
				x = Integer.parseInt(xy[0]);
				y = Integer.parseInt(xy[1]);
				chess_name= Chess[x][y];
						
				for(int i=0;i<direction.length;i++)
				{		
					//위치를 이동시키고 기존위치에 null값을 적용
					if(chess_name.contains(direction[i]))
					{	
						System.out.println("방향은 :"+direction[i]);
						move_xy = direction_way[i].split(",");
						move_x = Integer.parseInt(move_xy[0]);
						move_y = Integer.parseInt(move_xy[1]);
						Chess[x][y]=null;
						count++;
						check=check_outOfIndex(x+move_x, y+move_y);
						if(check==true)
						{
							//범위 밖을 벗어나면 방향을 바꿔준다.
							chess_name=change_direct(chess_name,direction[i]);
							Chess[x][y]=chess_name;
							break;
						}
						
						//레드존!!!!!!!!
						if(Chess_Board[x+move_x][y+move_y]=="빨강")
						{
							chess_name = red_Zone(chess_name);
							
//							Chess[x+move_x][y+move_y]=chess_name;
							
							
							// 이미 레드존에 있는 친구들의 순서를 위에 올려주면됌
							if(Chess[x+move_x][y+move_y]==null)
								Chess[x+move_x][y+move_y]=chess_name;
							else {
								chess_name+=","+Chess[x+move_x][y+move_y];
								Chess[x+move_x][y+move_y] = chess_name;
							}
						}
						
						//블루존!!!!!!!!!!!
						if(Chess_Board[x+move_x][y+move_y]=="파랑")
						{
							System.out.println("순번 : "+count);
							blue_Zone(chess_name,count);
						}
						else {
							
							if(Chess[x+move_x][y+move_y]==null)
								Chess[x+move_x][y+move_y]=chess_name;
							else {
								chess_name+=","+Chess[x+move_x][y+move_y];
								Chess[x+move_x][y+move_y] = chess_name;
							}
							break;
						}
						
					}
				}
				
			}
	}	
	public static void main(String[] args) {
		Main game = new Main();
		Scanner scan = new Scanner(System.in);
		int horse;
		int red;
		int blue;
		//초기화
		game.init_Board(Chess_Board);
		
		System.out.println("게임이 시작되었습니다. 말의 개수를 적어주세요");
		System.out.print("말 수 :");
		horse = scan.nextInt();
		game.init_Chess(horse);
		
		System.out.println("빨간색,파란색 칸의 개수를 입력해주세요");
		System.out.print("빨간색 :");
		red = scan.nextInt();
		System.out.print("파란색 :");
		blue = scan.nextInt();
		game.update_Chess_Board(red, blue);
		
		
		//게임시작
		game.game_paly();
		
		
		
		// 현황판 표시 
		System.out.println("=======================");
		for(int i=0;i<=4;i++)
		{
			for(int j=0;j<=4;j++)
			{
				System.out.print("    "+Chess_Board[i][j]+"    ");
			}
			System.out.println();
			System.out.println();
		}
		System.out.println("=======================");
		
		

	}
}
