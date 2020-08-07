package DyamicProgramming;

public class WineProblem {

	public static void main(String[] args) {
//		int arr[] = { 2,3,5,1,4 };
		int arr[] = new int[1000];
		for (int i = 1; i <= 999; i++)
			arr[i] = i;
//		System.out.println(WineProbRecursive(arr, 0, arr.length - 1, 1));
		System.out.println(WineProbTopDown(arr, 0, arr.length - 1, 1, new int[arr.length][arr.length]));
	}

	private static int WineProbRecursive(int arr[], int si, int ei, int year) {
		if (si == ei) {
			return arr[si] * year;
		}
		int leftCall = WineProbRecursive(arr, si + 1, ei, year + 1);
		int rightCall = WineProbRecursive(arr, si, ei - 1, year + 1);

		return Math.max(leftCall + arr[si] * year, rightCall + arr[ei] * year);
	}

	private static int WineProbTopDown(int arr[], int si, int ei, int year, int strg[][]) {
		if (si == ei) {
			return arr[si] * year;
		}
		if (strg[si][ei] != 0)
			return strg[si][ei];
		int leftCall = WineProbTopDown(arr, si + 1, ei, year + 1, strg);
		int rightCall = WineProbTopDown(arr, si, ei - 1, year + 1, strg);

		return strg[si][ei] = Math.max(leftCall + arr[si] * year, rightCall + arr[ei] * year);
	}
}
