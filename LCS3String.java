package DyamicProgramming;

public class LCS3String {

	public static void main(String[] args) {
		String s1 = "abcd1e2";
		String s2 = "bc12ea";
		String s3 = "bd1ea";
		System.out.println(LCS3Str(s1, s2, s3));
		System.out.println(LCS3SrtingsWithVIDX(s1, s2, s3, 0, 0, 0));
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
}
