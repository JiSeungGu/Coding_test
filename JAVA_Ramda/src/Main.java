import java.util.function.BinaryOperator;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

	

public class Main {
			
	@FunctionalInterface
	interface Say{
		int something(int a,int b);
	}		
	public static class Person{
		public void hi(Say line) {
			int number = line.something(3, 4);
			System.out.println("Number is "+number);
		}
	}
	
	
	// 람다식 문제 - 두개의 숫자 더하기
	@FunctionalInterface
	interface Compare{
		public int compareTo(int a,int b);
	}		
	public static class Ramda{
		public static void exec(Compare com) {
			int k=10;
			int m=20;
			int value = com.compareTo(k, m);
			System.out.println("value ="+value);
		}
	}	
	
	//두개의 숫자중 큰 수 찾기 
		@FunctionalInterface
		public interface MyNumber{
			int getMax(int num1,int num2);
	}
	
	public static void main(String[] args) {
		//람다 함수 
		//프로래밍 언어에서 사용되는 개념으로 '익명 함수'를 지칭하는 용어
		
		
		//Java에서 지원하는 java.util.function 인터페이스
		//					 	** Function Interface 는 함수가 하나만 존재하는 Interface를 의미한다.
		//IntFunctino<R> = int값을 인수로 바아들이고 결과를 생서하는 함수
		IntFunction intSum = (x) -> x+1;
		System.out.println(intSum.apply(1));
		
		
		//BinaryOperator
		//동일한 유형의 두 피연산자에 대한 연산을 나타내며 피연산자와 동일한 유형의 결과를 생성
		BinaryOperator stringSum=(x,y)->x+" "+y;
		System.out.println(stringSum.apply("이게되나","되나본데"));
		
		//https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html <- 인터페이스 목록 
		
		//2로 나눠지는 값 출력
		IntStream.range(1, 11).filter(i->i%2==0).forEach(System.out::println);
		
		// 0~1000까지의 값중 500이상,짝수,5의 배수인 수의 합
		System.out.println(
				IntStream.range(0, 1001) // 0부터 1001사이
				.skip(500)			//500이상
				.filter(i->i%2==0)  //짝수
				.filter(i->i%5==0)  //5의 배수
				.sum()
				);
		
		
		// 직접구현한 FunctionalInterface 사용
		Person rin = new Person();
		rin.hi((a,b)->{
			System.out.println("람다식 표헌법");
			System.out.println("Parameter number is"+a+","+b);
			return 7;
		});
		
		Ramda ram = new Ramda();
		ram.exec((i,j)->{
			return i+j;
		});
		
		
		//두개의 숫자중 큰 수 찾기
		MyNumber max = (x,y)->(x>=y)?x:y;
		System.out.println(max.getMax(10, 20));
	}		
}		
