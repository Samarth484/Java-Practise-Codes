package DyamicProgramming;

public class WineProblem {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 5, 1, 4 };
//	
		System.out.println("The answer via regular recursive code is: " + WineProbRecursive(arr, 0, arr.length - 1));
		System.out.println("The answer via regular top down dp code is: "
				+ WineProbTopDown(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println("The answer via regular bottom up code is: " + WineProbBottomUpMyCode(arr));
		System.out.println("The answer via optimal bottom up code is: " + WineProbBottomUpOptimalGCM(arr));
	}

	private static int WineProbRecursive(int arr[], int si, int ei) {

		int year = arr.length - (ei - si + 1) + 1;
		if (si == ei) {
			return arr[si] * year;
		}
		int leftCall = WineProbRecursive(arr, si + 1, ei);
		int rightCall = WineProbRecursive(arr, si, ei - 1);

		return Math.max(leftCall + arr[si] * year, rightCall + arr[ei] * year);
	}

//	the code below will work perfectly fine for very large sized array for eg had arr been like so:
//	
//	int arr[] = new int[1000];
//	for (int i = 1; i <= 999; i++)
//		arr[i] = i;
//	
//	then in that case WineProbRecursive would have failed but WineProbTopDown will succeed because it follows DP and hence takes care of
//	overlapping sub-problems!
	private static int WineProbTopDown(int arr[], int si, int ei, int strg[][]) {

		int year = arr.length - (ei - si + 1) + 1;
		if (si == ei) {
			return arr[si] * year;
		}
		if (strg[si][ei] != 0)
			return strg[si][ei];
		int leftCall = WineProbTopDown(arr, si + 1, ei, strg);
		int rightCall = WineProbTopDown(arr, si, ei - 1, strg);

		return strg[si][ei] = Math.max(leftCall + arr[si] * year, rightCall + arr[ei] * year);
	}

	private static int WineProbBottomUpMyCode(int arr[]) {
		int strg[][] = new int[arr.length][arr.length];

		// si is denoted on rows, and ei is denoted on columns.

		for (int row = arr.length - 1; row >= 0; row--) {
			for (int col = 0; col < arr.length; col++) {
				int year = arr.length - (col - row + 1) + 1;
				if (row == col)
					strg[row][col] = arr[row] * year;
			}
		}

		for (int row = arr.length - 1; row >= 0; row--) {
			for (int col = 0; col < arr.length; col++) {
				int year = arr.length - (col - row + 1) + 1;
				if (row > col || row == col)
					continue;
				else {
					strg[row][col] = Math.max(strg[row + 1][col] + arr[row] * year,
							strg[row][col - 1] + arr[col] * year);
				}

			}
		}
		return strg[0][arr.length - 1];
	}

	private static int WineProbBottomUpOptimalGCM(int arr[]) {
		int strg[][] = new int[arr.length][arr.length];
		int year;
		for (int slide = 0; slide < arr.length; slide++) {
			for (int si = 0; si <= arr.length - slide - 1; si++) {
				int ei = si + slide;
				year = arr.length - (ei - si + 1) + 1;
				if (si == ei)
					strg[si][ei] = arr[si] * year;
				else
					strg[si][ei] = Math.max(strg[si + 1][ei] + arr[si] * year, strg[si][ei - 1] + arr[ei] * year);
			}
		}
		return strg[0][arr.length - 1];

	}
}
