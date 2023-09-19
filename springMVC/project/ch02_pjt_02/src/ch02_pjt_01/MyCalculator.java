package ch02_pjt_01;

public class MyCalculator {

	public void calculate(int fNum, int sNum, ICalculator calculator) {
//		ICalculator calculator = new CalAdd();
		int value = calculator.doOperation(fNum, sNum);
		System.out.println("result : " + value);
	}
}
