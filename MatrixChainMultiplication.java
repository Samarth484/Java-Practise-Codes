package DyamicProgramming;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		int arr[] = { 4, 2, 3, 5, 1 };
		System.out.println(MCMmyCode(arr, 0, arr.length - 1));
	}

	private static int MCMmyCode(int arr[], int si, int ei) {

		if (si + 1 == ei)
			return 0;

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int firstPartition = MCMmyCode(arr, si, k); // arr[si]*arr[k]
			int secondPartition = MCMmyCode(arr, k, ei); // arr[k]*arr[ei]

			int sw = arr[si] * arr[k] * arr[ei]; // self work

			int total = firstPartition + secondPartition + sw;

			if (total < min)
				min = total;
		}
		return min;
	}

}
