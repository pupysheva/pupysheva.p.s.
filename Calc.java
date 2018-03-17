public class Calc{
	static boolean doubleOperationEnabled;

	public static void setDoubleOperationEnabled(boolean flag){
		doubleOperationEnabled = flag;
		
	}
	public static boolean isDoubleOperationEnabled(){
                    return doubleOperationEnabled;
	}
	public static int add(int a, int b){
		return a+b;
	}
	public static int sub(int a, int b){
		return a-b;
	}
	public static int mult(int a, int b){
		return a*b;
	}
	public static int div(int a, int b){
		return a/b;
	}
	
	public static double add(double a, double b){
		return a+b;
	}
	public static double sub(double a, double b){
		return a-b;
	}
	public static double mult(double a, double b){
		return a*b;
	}
	public static double div(double a, double b){
		return a/b;
	}
}


