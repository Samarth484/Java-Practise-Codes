package DyamicProgramming;

public class WineProblem {

	public static void main(String[] args) {
		int arr[] = { 1,4,2,3 };
		System.out.println(WineProb(arr, 0, arr.length-1 , 1));
	}

	private static int WineProb(int arr[], int si, int ei, int year) {
		if (si == ei) {
			return arr[si] * year;
		}
		int leftCall = WineProb(arr, si + 1, ei, year + 1);
		int rightCall = WineProb(arr, si, ei - 1, year + 1);

		return Math.max(leftCall + arr[si]*year, rightCall + arr[ei]*year);
	}
}
