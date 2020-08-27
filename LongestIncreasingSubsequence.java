package DyamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

	static Scanner scn = new Scanner(System.in);

	public static void main(String args[]) {
//		System.out.println();
//		int n = scn.nextInt();
//		int arr[] = new int[n];
//		for (int i = 0; i < n; i++)
//			arr[i] = scn.nextInt();
		int arr[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(LIS_Quadratic_time(arr));
		System.out.println(LISBU_GCM(arr));
	}

	private static int LIS_Quadratic_time(int arr[]) {
		int n = arr.length;
		int strg[] = new int[n];

		Arrays.fill(strg, 1);

		for (int i = 0; i < n; i++) {
			int curr = arr[i];
			int max = 1;
			for (int j = 0; j <= i; j++) {
				if (arr[j] < curr) {
					max = Math.max(max, strg[j] + 1);
				}
			}
			strg[i] = max;
		}
		int ans = 1;
		for (int val : strg) {
			ans = Math.max(ans, val);
		}
		return ans;

	}

	public static int LISBU_GCM(int[] arr) {

		int max = Integer.MIN_VALUE;

		int[] strg = new int[arr.length];

		Arrays.fill(strg, 1);

		for (int i = 0; i < strg.length; i++) {

			for (int j = 0; j < i; j++) {

				if (arr[j] < arr[i]) {
					strg[i] = Math.max(strg[i], strg[j] + 1);

					max = Math.max(max, strg[i]);
				}
			}
		}

		return max;

	}
}
