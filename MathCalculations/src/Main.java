import com.util.MyMath;

public class Main {

	public static void main(String[] args) {
		int var1 = MyMath.romanToInteger("X");
		int var2 = MyMath.romanToInteger("V");
		int sum = var1 + var2;
		System.out.println(sum);
		System.out.println(MyMath.toRomanNumeral(sum));
		
	}

}
