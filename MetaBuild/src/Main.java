import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.Arrays;
 
public class Main {
	
	public static void main(String[] args) {
		
		try {
			//출력용 경로 
			File result_File = new File("C:\\exam\\result.txt");
			FileWriter writer = null;
			writer = new FileWriter(result_File, false);
			
			//파일 경로  설정 
			File file = new File("C:\\exam\\HFDS.log");
			BufferedReader filereader = new BufferedReader(new FileReader(file));
			
			//조건검색용 배열 
			String[] log = {"TOTAL","DEBUG","INFO","WARN","ERROR","FATAL"};
			
			//조건 출력용 배열 
			int[] logCount= {0,0,0,0,0,0};
				
			//파일을 한줄 씩 읽기위한 변수 
			String line=null;
			//날짜를 저장하는 변수
			String day=null;
			//시간을 저장하는 변수 
			String DataTime=null;
			// 결과 값을 result에 쓰기위한 변수
			String result=null;
				
			System.out.println("DateTime,Total,DEBUG,INFO,WARN,ERROR,FATAL");
			writer.write("DateTime,Total,DEBUG,INFO,WARN,ERROR,FATAL\n");
			while((line=filereader.readLine()) != null)
			{	
				
				String[] a=line.split(" ");
//				System.out.println(line);
				String time = a[1].substring(0,2);
				
				//처음 파일을 읽기 시작했을때 초기값을 넣어준다.
				if(day==null)
				{
					day=a[0];
					DataTime=a[1];
				}
				// 날짜와 시간이 동일하면 TOTAL값을 증가시킨다.
				if(day.equals(a[0]) && DataTime.startsWith(time))
				{
					logCount[0]++;
				}
				
				// 날짜와 시간이 동일하지않으면 지금까지 계산한 값을 출력하고 
				// 다음 날짜,시간을 넣어준다
				if(day.equals(a[0])==false || DataTime.startsWith(time)==false)
				{
					//지금까지 계산한 값
					result =day+" "+DataTime.substring(0,2)+","+logCount[0]+","+logCount[1]+","+logCount[2]+
							","+logCount[3]+","+logCount[4]+","+logCount[5]+"\n";
					System.out.print(result);
		            writer.write(result);
		            writer.flush();
					
		            //다음 날짜 시간 값
					day=a[0];
					DataTime=a[1];
					
					//배열 초기화
					Arrays.fill(logCount,0);
					// 날짜,시간값이 바뀌었을때 count값을 세고 들어간다.
				
					logCount[0]=1;
				}
				// 읽은 로그레벨(INFO,DEBUG...)을 계산한다.  
				for (int k = 0; k<= 5; k++) {
					if (a[3].equals(log[k])) {
						logCount[k]++;
					}
				}
			}
			//파일을 다읽고나서 마지막값은 변경이없기때문에 while문에서 저장이 되지 못하고 추가적으로 마지막값은 넣어준다.
			result =day+" "+DataTime.substring(0,2)+","+logCount[0]+","+logCount[1]+","+logCount[2]+
					","+logCount[3]+","+logCount[4]+","+logCount[5]+"\n";
			System.out.println(result);
			writer.write(result);
			writer.flush();
			filereader.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
