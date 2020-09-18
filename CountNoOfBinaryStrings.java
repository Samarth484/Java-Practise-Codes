package DyamicProgramming;

public class CountNoOfBinaryStrings {

	public static void main(String[] args) {
		System.out.println(countBinaryStrings(3, ""));
	}

	private static int countBinaryStrings(int n, String binary) {
		if (n == 0) {
			System.out.println(binary);
			return 1;
		}
		int result = 0;
//		char rm=binary.charAt(binary.length()-1);
		result += countBinaryStrings(n - 1, binary + "0");
		if (binary.equals("") || binary.charAt(binary.length() - 1) != '1') {	
			result += countBinaryStrings(n - 1, binary + "1");
		}
		return result;
	}

}
