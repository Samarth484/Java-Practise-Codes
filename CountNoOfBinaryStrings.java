package DyamicProgramming;

import java.util.Scanner;

public class CountNoOfBinaryStrings {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println();
		int t = scn.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = scn.nextInt();
			System.out.println(countBinaryStrings(n, ""));
		}

	}

	private static int countBinaryStrings(int n, String binary) {
		if (n == 0) {
//			System.out.println(binary);
			return 1;
		}
		int result = 0;

		result += countBinaryStrings(n - 1, binary + "0");
		if (binary.equals("") || binary.charAt(binary.length() - 1) != '1') {
			result += countBinaryStrings(n - 1, binary + "1");
		}
		return result;
	}

}
