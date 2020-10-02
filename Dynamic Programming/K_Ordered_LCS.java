package DyamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class K_Ordered_LCS {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
System.out.println();
		int n = scn.nextInt();
		int m = scn.nextInt();
		int k = scn.nextInt();

		int arr1[] = new int[n];
		int arr2[] = new int[m];

		for (int i = 0; i < n; i++)
			arr1[i] = scn.nextInt();

		for (int i = 0; i < m; i++)
			arr2[i] = scn.nextInt();

		int strg[][][] = new int[k + 1][arr1.length + 1][arr2.length + 1];
		for (int i = 0; i < strg.length; i++) {

			for (int j = 0; j < strg[0].length; j++)
				Arrays.fill(strg[i][j], -1);

		}

//		System.out.println(KOrderedLCSRecursiveMine(arr1, arr2, k, 0, 0));
		System.out.println(KOrderedLCSTopDownMine(arr1, arr2, k, 0, 0, strg));

	}

	public static int KOrderedLCSTopDownMine(int arr1[], int arr2[], int k, int vidx1, int vidx2, int strg[][][]) {

		if (vidx1 == arr1.length || vidx2 == arr2.length)
			return 0;
		int ans = 0;
		if (strg[k][vidx1][vidx2] != -1)
			return strg[k][vidx1][vidx2];
		if (arr1[vidx1] == arr2[vidx2])
			ans = KOrderedLCSTopDownMine(arr1, arr2, k, vidx1 + 1, vidx2 + 1, strg) + 1;
		else {
			int o1 = KOrderedLCSTopDownMine(arr1, arr2, k, vidx1, vidx2 + 1, strg);
			int o2 = KOrderedLCSTopDownMine(arr1, arr2, k, vidx1 + 1, vidx2, strg);
			int o3 = 0;
			if (k >= 1)
				o3 = KOrderedLCSTopDownMine(arr1, arr2, k - 1, vidx1 + 1, vidx2 + 1, strg) + 1;

			ans = Math.max(o1, Math.max(o2, o3));
		}
		return strg[k][vidx1][vidx2] = ans;
	}

}
