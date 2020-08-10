
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {

	public static Long getLong(String str) {
		System.out.print(str);
		String s = "";
		try {
			s = getString("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long value = Long.valueOf(s);
		return value;
	}

	public static char getChar(String str) {
		System.out.print(str);
		String s = "";
		try {
			s = getString("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s.charAt(0);
	}

	public static Double getDouble(String str) {

		System.out.print(str);
		String s = "";

		try {
			s = getString("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Double value = Double.valueOf(s);
		return value;

	}

	public static Integer getInt(String str) {

		System.out.print(str);
		String s = "";

		try {
			s = getString("");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Integer value = Integer.valueOf(s);
			return value;
		} catch (NumberFormatException e) {
			return getInt("Invalid number! Please enter a number: ");
		}
	}

	public static String getString(String str)

			throws IOException {
		System.out.print(str);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();

		return s;
	}

	public static String getStr(String str) {

		System.out.print(str);
		String s = "";

		try {
			s = getString("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = String.valueOf(s);
		return value;

	}

}