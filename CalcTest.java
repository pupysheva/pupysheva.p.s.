public class CalcTest{
	public static void test_add(int a, int b){
		if(Calc.add(1,2)==3)
			System.out.println("ок");
		else System.out.println("not ок");
	}
	public static void test_div(int a, int b){
		if(Calc.div(4,2)==2)
			System.out.println("ок");
		else System.out.println("not ок");
	}
	public static void test_sub(int a, int b){
		if(Calc.sub(3,1)==2)
			System.out.println("ок");
		else System.out.println("not ок");
	}
	public static void test_mult(int a, int b){
		if(Calc.mult(2,2)==4)
			System.out.println("ок");
		else System.out.println("not ок");
	
	}

	public static void test_add_doub(double a, double b){
		if((Calc.add(1.1,2.1)-3.2)<0.000001)
			System.out.println("ок");
		else System.out.println("not ок");
	}
	public static void test_div_doub(double a, double b){
		if((Calc.div(4.2,2)-2.1)<0.000001)
			System.out.println("ок");
		else System.out.println("not ок");
	}
	public static void test_sub_doub(double a, double b){
		if((Calc.sub(3.3,1.2)-2.2)<0.000001)
			System.out.println("ok");
		else System.out.println("not ok");
	}
	public static void test_mult_doub(double a, double b){
		if((Calc.mult(2.1,2)-4.2)<0.000001)
			System.out.println("ок");
		else System.out.println("not ок");
	
	}

private static void testDivDouble(){
	Calc.setDoubleOperationEnabled(true);
	if(Calc.isDoubleOperationEnabled() == true)
		System.out.println("may");
	else System.out.println("not may");
}
	public static void main(String[] args){
		testDivDouble();
		if(Calc.isDoubleOperationEnabled() == true){
			test_add_doub(1.1,2.1);
			test_div_doub(4.2,2);
			test_sub_doub(3.3,1.2);
			test_mult_doub(2.1,2);
		}
		else System.out.println("Cannot execute double opetations");
		return;
	}
}
