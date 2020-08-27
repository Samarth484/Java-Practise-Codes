package DyamicProgramming;

public class MinimumJumpsRequired {

	public static void main(String[] args) {
		System.out.println();
//		int arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//		int arr[] = { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 };
//		int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
//		int arr[] = { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };
//		int arr[] = new int[1100];
//		for (int i = 0; i < arr.length; i++)
//			arr[i] = i;

		long start = System.currentTimeMillis();
//		System.out.println(MinJumps(arr, 0));
		long end = System.currentTimeMillis();
//		System.out.println("Time taken = " + (end - start) + "ms");
//
//		
//		start = System.currentTimeMillis();
//		System.out.println(MinJumpsDP(arr, 0, new int[arr.length]));
//		end = System.currentTimeMillis();
//		System.out.println("Time taken = " + (end - start) + "ms");
		
		
		start = System.currentTimeMillis();
		System.out.println(MinJumpsBU(arr));
		end = System.currentTimeMillis();
		System.out.println("Time taken = " + (end - start) + "ms");
		System.out.println(Integer.MIN_VALUE);

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

	private static int MinJumpsBU(int arr[]) {
		if (arr[0] == 0)
			return Integer.MAX_VALUE;

		int strg[] = new int[arr.length];

		for (int i = arr.length - 2; i >= 0; i--) {

			if (arr[i] >= arr.length - i)
				strg[i] = 1;
			else {
				int min = Integer.MAX_VALUE;
				for (int j = i + 1; j < i + 1 + arr[i]; j++)
					min = Math.min(min, strg[j]);
				strg[i] = min + 1;
			}

		}
		return strg[0];
	}
}
