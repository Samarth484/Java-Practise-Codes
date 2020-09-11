package DyamicProgramming;

import java.util.Scanner;

public class K_Ordered_LCS {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println();
//		The first line contains three integers N, M and k
//		denoting the lengths of the first and second sequences and the value of the provided parameter respectively.
//		The second line contains N integers denoting the elements of the first sequence. 
//		The third line contains M integers denoting the elements of the second sequence.

		int n = scn.nextInt();
		int m = scn.nextInt();
		int k = scn.nextInt();

		int arr1[] = new int[n];
		int arr2[] = new int[m];

		for (int i = 0; i < n; i++)
			arr1[i] = scn.nextInt();

		for (int i = 0; i < m; i++)
			arr2[i] = scn.nextInt();

		System.out.println(KOrderedLCSRecursiveMine(arr1, arr2, k, 0, 0));

	}

	public static int KOrderedLCSRecursiveMine(int arr1[], int arr2[], int k, int vidx1, int vidx2) {

		if (vidx1 == arr1.length || vidx2 == arr2.length)
			return 0;
		int ans = 0;
		if (arr1[vidx1] == arr2[vidx2])
			ans = KOrderedLCSRecursiveMine(arr1, arr2, k, vidx1 + 1, vidx2 + 1) + 1;
		else {
			int o1 = KOrderedLCSRecursiveMine(arr1, arr2, k, vidx1, vidx2 + 1);
			int o2 = KOrderedLCSRecursiveMine(arr1, arr2, k, vidx1 + 1, vidx2);
			int o3 = 0;
			if (k >= 1)
				o3 = KOrderedLCSRecursiveMine(arr1, arr2, k - 1, vidx1 + 1, vidx2 + 1) + 1;

			ans = Math.max(o1, Math.max(o2, o3));
		}
		return ans;
	}

}
