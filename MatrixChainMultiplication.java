package DyamicProgramming;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		int arr[] = { 4, 2, 3, 5, 1 };

		System.out.println(MCMRecursiveGCM(arr, 0, arr.length - 1));
		System.out.println(MCMTopDownMyCode(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println(MCMBottomUpMyCode(arr));

	}

	private static int MCMRecursiveGCM(int arr[], int si, int ei) {

		if (si + 1 == ei)
			return 0;

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int firstPartition = MCMRecursiveGCM(arr, si, k); // arr[si]*arr[k]
			int secondPartition = MCMRecursiveGCM(arr, k, ei); // arr[k]*arr[ei]

			int sw = arr[si] * arr[k] * arr[ei]; // self work

			int total = firstPartition + secondPartition + sw;

			if (total < min)
				min = total;
		}
		return min;
	}

//	The function below will work for array of very large sizes, i.e. had arr been like so:

//	int arr[] = new int[100];
//	for (int i = 0; i < 100; i++)
//		arr[i] = i + 1;

//	then too MCMTopDownMyCode function would have worked but MCMRecursiveGCM would have failed on TLE notes in that case!
	private static int MCMTopDownMyCode(int arr[], int si, int ei, int strg[][]) {

		if (si + 1 == ei)
			return 0;
		if (strg[si][ei] != 0)
			return strg[si][ei];
		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {
			int firstPartition = MCMTopDownMyCode(arr, si, k, strg);
			int secondPartition = MCMTopDownMyCode(arr, k, ei, strg);

			int sw = arr[si] * arr[k] * arr[ei];

			int total = firstPartition + secondPartition + sw;
			if (total < min)
				min = total;
		}
		return strg[si][ei] = min;

	}

	private static int MCMBottomUpMyCode(int arr[]) {
		int n = arr.length;
		int strg[][] = new int[n][n];
		for (int si = n - 3; si >= 0; si--) {
			for (int ei = 0; ei < n; ei++) {
				if (si + 1 < ei) {
					int total = Integer.MAX_VALUE;
					for (int k = si + 1; k <= ei - 1; k++) {
						total = Math.min(total, strg[si][k] + strg[k][ei] + arr[si] * arr[k] * arr[ei]);
					}
					strg[si][ei] = total;
				}
			}
		}
		return strg[0][n - 1];
	}
}
