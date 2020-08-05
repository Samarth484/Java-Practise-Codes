package DyamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LCS_DP {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		String s1 = "ABCD";
		String s2 = "AGCFB";

		System.out.println(LCSRecursive(s1, s2));

		System.out.println(LCSRecursiveVIDX(s1, s2, 0, 0));

		System.out.println(LCSRecursiveVIDXTopDown(s1, s2, 0, 0, new int[s1.length()][s2.length()]));

		System.out.println(LCSRecursiveVIDXBottomUp(s1, s2));

		System.out.println(LCSRecursiveTopDownOnceAgain(s1, s2, 0, 0, new int[s1.length()][s2.length()]));
		int strg2[][] = new int[s1.length()][s2.length()];
		for (int val[] : strg2) {
			Arrays.fill(val, -1);
		}
		System.out.println(LCSRecursiveTopDownOnceAgainWithNewMeaningToCell(s1, s2, 0, 0, strg2));
	}

	private static int LCSRecursive(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0)
			return 0;

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		if (ch1 == ch2)
			return LCSRecursive(ros1, ros2) + 1;
		else {
			int leftCall = LCSRecursive(s1, ros2);
			int rightCall = LCSRecursive(ros1, s2);
			return Math.max(leftCall, rightCall);
		}

	}

	private static int LCSRecursiveVIDX(String s1, String s2, int vidx1, int vidx2) {
		if (vidx1 == s1.length() || vidx2 == s2.length())
			return 0;

		if (s1.charAt(vidx1) == s2.charAt(vidx2))
			return LCSRecursiveVIDX(s1, s2, vidx1 + 1, vidx2 + 1) + 1;

		else {
			int leftCall = LCSRecursiveVIDX(s1, s2, vidx1, vidx2 + 1);
			int rightCall = LCSRecursiveVIDX(s1, s2, vidx1 + 1, vidx2);
			return Math.max(leftCall, rightCall);
		}

	}

	private static int LCSRecursiveVIDXTopDown(String s1, String s2, int vidx1, int vidx2, int strg[][]) {
		if (vidx1 == s1.length() || vidx2 == s2.length())
			return 0;

		if (strg[vidx1][vidx2] != 0)
			return strg[vidx1][vidx2];

		if (s1.charAt(vidx1) == s2.charAt(vidx2))
			return strg[vidx1][vidx2] = LCSRecursiveVIDXTopDown(s1, s2, vidx1 + 1, vidx2 + 1, strg) + 1;

		else {
			int leftCall = LCSRecursiveVIDXTopDown(s1, s2, vidx1, vidx2 + 1, strg);
			int rightCall = LCSRecursiveVIDXTopDown(s1, s2, vidx1 + 1, vidx2, strg);
			return strg[vidx1][vidx2] = Math.max(leftCall, rightCall);
		}

	}

	private static int LCSRecursiveVIDXBottomUp(String s1, String s2) {

		int strg[][] = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; --row) {
			for (int col = s2.length() - 1; col >= 0; --col) {
				if (s1.charAt(row) == s2.charAt(col))
					strg[row][col] = strg[row + 1][col + 1] + 1;
				else
					strg[row][col] = Math.max(strg[row + 1][col], strg[row][col + 1]);
			}
		}
		return strg[0][0];
	}

	private static int LCSRecursiveTopDownOnceAgain(String s1, String s2, int vidx1, int vidx2, int strg[][]) {

		if (s1.length() == vidx1 || s2.length() == vidx2)
			return 0;
		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

		if (strg[vidx1][vidx2] != 0)
			return strg[vidx1][vidx2];

		if (ch1 == ch2)
			return LCSRecursiveTopDownOnceAgain(s1, s2, vidx1 + 1, vidx2 + 1, strg) + 1;
		else {
			int leftCall = LCSRecursiveTopDownOnceAgain(s1, s2, vidx1, vidx2 + 1, strg);
			int rightCall = LCSRecursiveTopDownOnceAgain(s1, s2, vidx1 + 1, vidx2, strg);
			return strg[vidx1][vidx2] = Math.max(leftCall, rightCall);
		}
	}

	
	
	//THE CODE GIVEN BELOW IS HELPFUL TO ERADICATE TWO MEANINGS TO 0 VALUE OF CELL WHEREIN THE DISCREPANCY OF RESULT NOT YET EVALUATED
	//AND THE LENGTH OF LCS = 0 IS DISTINGUISHED, OR ELSE THIS DISCREPANCY SIMPLY FAILED THE DP TO EXECUTE
	private static int LCSRecursiveTopDownOnceAgainWithNewMeaningToCell(String s1, String s2, int vidx1, int vidx2,
			int strg[][]) {

		if (s1.length() == vidx1 || s2.length() == vidx2)
			return 0;
		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

		if (strg[vidx1][vidx2] != -1)
			return strg[vidx1][vidx2];

		if (ch1 == ch2)
			return LCSRecursiveTopDownOnceAgainWithNewMeaningToCell(s1, s2, vidx1 + 1, vidx2 + 1, strg) + 1;
		else {
			int leftCall = LCSRecursiveTopDownOnceAgainWithNewMeaningToCell(s1, s2, vidx1, vidx2 + 1, strg);
			int rightCall = LCSRecursiveTopDownOnceAgainWithNewMeaningToCell(s1, s2, vidx1 + 1, vidx2, strg);
			return strg[vidx1][vidx2] = Math.max(leftCall, rightCall);
		}

	}
}
