package utilities;

//http://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
public class ConstantsUtil {

	public static final String SUCCESS = "Success";
	public static final String FAIL = "Fail";

	public static boolean isPrime(int n) {

		for (int i = 2; 2 * i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
