package DyamicProgramming;

public class MinimumJumpsRequired {

	public static void main(String[] args) {

//		int arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//		int arr[] = {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1};
//		int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println(MinJumps(arr, 0));
		System.out.println(MinJumpsDP(arr, 0, new int[arr.length]));

	}

	private static int MinJumps(int arr[], int vidx) {

		if (vidx >= arr.length - 1) {
			return 0;
		}
		if (arr[vidx] == 0)
			return Integer.MAX_VALUE;
		int minans = Integer.MAX_VALUE;
		for (int i = vidx; i < arr.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= arr[vidx]; j++) {
				min = Math.min(min, MinJumps(arr, vidx + j));
			}
			minans = Math.min(minans, min);
		}
		return minans + 1;
	}

	private static int MinJumpsDP(int arr[], int vidx, int strg[]) {

		if (vidx >= arr.length - 1) {
			return 0;
		}
		if (arr[vidx] == 0)
			return Integer.MAX_VALUE;
		if (strg[vidx] != 0)
			return strg[vidx];
		int minans = Integer.MAX_VALUE;
		for (int i = vidx; i < arr.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= arr[vidx]; j++) {
				min = Math.min(min, MinJumpsDP(arr, vidx + j, strg));
			}
			minans = Math.min(minans, min);
		}
		return strg[vidx] = minans + 1;
	}

}
