package DyamicProgramming;

public class LCS3String {

	public static void main(String[] args) {
		String s1 = "AGGT12";
		String s2 = "12TXAYB";
		String s3 = "12XBA";
		System.out.println(LCS3Str(s1, s2, s3));
		System.out.println(LCS3SrtingsWithVIDX(s1, s2, s3, 0, 0, 0));
		System.out
				.println(LCS3StringTD(s1, s2, s3, 0, 0, 0, new int[s1.length() + 1][s2.length() + 1][s3.length() + 1]));
	}

	private static int LCS3Str(String s1, String s2, String s3) {
		if (s1.length() == 0 || s2.length() == 0 || s3.length() == 0)
			return 0;
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		char ch3 = s3.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		String ros3 = s3.substring(1);
		if (ch1 == ch2 && ch2 == ch3)
			return LCS3Str(ros1, ros2, ros3) + 1;
		else
			return Math.max(Math.max(LCS3Str(ros1, s2, s3), LCS3Str(s1, ros2, s3)), LCS3Str(s1, s2, ros3));

	}

	private static int LCS3SrtingsWithVIDX(String s1, String s2, String s3, int vidx1, int vidx2, int vidx3) {
		if (vidx1 == s1.length() || vidx2 == s2.length() || vidx3 == s3.length())
			return 0;
		if (s1.charAt(vidx1) == s2.charAt(vidx2) && s2.charAt(vidx2) == s3.charAt(vidx3))
			return LCS3SrtingsWithVIDX(s1, s2, s3, vidx1 + 1, vidx2 + 1, vidx3 + 1) + 1;

		else
			return Math.max(
					Math.max(LCS3SrtingsWithVIDX(s1, s2, s3, vidx1 + 1, vidx2, vidx3),
							LCS3SrtingsWithVIDX(s1, s2, s3, vidx1, vidx2 + 1, vidx3)),
					LCS3SrtingsWithVIDX(s1, s2, s3, vidx1, vidx2, vidx3 + 1));

	}

	private static int LCS3StringTD(String s1, String s2, String s3, int vidx1, int vidx2, int vidx3, int strg[][][]) {

		if (vidx1 == s1.length() || vidx2 == s2.length() || vidx3 == s3.length())
			return 0;
		if (strg[vidx1][vidx2][vidx3] != 0)
			return strg[vidx1][vidx2][vidx3];
		if (s1.charAt(vidx1) == s2.charAt(vidx2) && s2.charAt(vidx2) == s3.charAt(vidx3))
			return strg[vidx1][vidx2][vidx3] = LCS3StringTD(s1, s2, s3, vidx1 + 1, vidx2 + 1, vidx3 + 1, strg) + 1;

		else
			return strg[vidx1][vidx2][vidx3] = Math.max(
					Math.max(LCS3StringTD(s1, s2, s3, vidx1 + 1, vidx2, vidx3, strg),
							LCS3StringTD(s1, s2, s3, vidx1, vidx2 + 1, vidx3, strg)),
					LCS3StringTD(s1, s2, s3, vidx1, vidx2, vidx3 + 1, strg));

	}
}
