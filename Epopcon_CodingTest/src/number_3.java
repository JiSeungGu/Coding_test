import java.util.Arrays;

public class number_3 {
	
	static int lotto[]= new int[6];
	static int num=0;
//	
//	public void random() {
//		for(int i=0;i<lotto.length-1;i++)
//		{
//			lotto[i] = (int)(Math.random()*35)+1;
//			try {
//				Thread.sleep(1000);
//			}catch (Exception e) {
//				System.err.println(e.getMessage());
//			}
//			
//		}
//	}
//	
	//로또 번호 1부터 45까지 뽑는 메소드
	static class ThreadTask extends Thread{
		
		@Override
		public void run() {
			lotto[num] = (int)((Math.random()*35)+1);
			num++;
		}
	}
	//중복된 번호가 있는지 검사하는 메소드
	public boolean overlap(int lotto[]) {
		Boolean bCheck=false;
		for(int i=0;i<=lotto.length-2;i++)
		{
			for(int j=i;j<=lotto.length-1;j++)
			{
				if(lotto[i]==lotto[j])
				{
					bCheck=true;
				}
			}
		}
		return bCheck;
	}
	
	public static void main(String[] args) {
		boolean play=true;
		Runnable task = new ThreadTask();
		
		Thread thread_1 = new Thread(task);
		Thread thread_2 = new Thread(task);
		Thread thread_3 = new Thread(task);
		Thread thread_4 = new Thread(task);
		Thread thread_5 = new Thread(task);
		Thread thread_6 = new Thread(task);
		
		number_3 program = new number_3();

			try {
				thread_1.sleep(1);
				thread_1.start();
				thread_2.sleep(2);
				thread_2.start();
				thread_3.sleep(3);
				thread_3.start();
				thread_4.sleep(4);
				thread_4.start();
				thread_5.sleep(5);
				thread_5.start();
				thread_6.sleep(6);
				thread_6.start();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			play = program.overlap(lotto);
			
			//오름차순 정렬
			Arrays.sort(lotto);
			System.out.println(Arrays.toString(lotto));
	}
}
