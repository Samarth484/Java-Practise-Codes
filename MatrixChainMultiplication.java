package DyamicProgramming;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		int arr[] = { 4, 2, 3, 5, 1 };
		System.out.println(MCMmyCode(arr, 0, arr.length - 1));
	}

	private static void display(int arr[]) {
		for (int val : arr)
			System.out.print(val + " ");
		System.out.println();
	}

	private static int MCMmyCode(int arr[], int si, int ei) {
		int min = Integer.MAX_VALUE;
		if (si + 1 == ei) {

			return 0;
		}

		for (int k = si + 1; k <= ei - 1; k++) {
			int total = MCMmyCode(arr, si, k) + MCMmyCode(arr, k, ei) + arr[si] * arr[k] * arr[ei];
			if (total < min)
				min = total;
		}
		return min;
	}

}
