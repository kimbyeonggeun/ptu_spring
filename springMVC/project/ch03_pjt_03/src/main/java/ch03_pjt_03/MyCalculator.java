package ch03_pjt_03;

public class MyCalculator {
	public void calculate(int fNum, int sNum, ICalculator calculator) {
//		ICalculator 객체 주입
		int value = calculator.doOperation(fNum, sNum);	//연산실행
		System.out.println("result : "+value);
	}
}
