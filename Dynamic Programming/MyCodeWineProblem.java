package DyamicProgramming;

import java.util.ArrayList;

public class MyCodeWineProblem {
	static ArrayList<Integer> finalPrices = new ArrayList<Integer>();

	public static void main(String[] args) {
		int iniPri[] = { 2,4,6,2,5 };
		WineProb2(iniPri, 0, iniPri.length, "");
		System.out.println(finalPrices);
		int max = 0;
		for (int val : finalPrices) {
			if (max <= val)
				max = val;
		}
		System.out.println("Maximum price you can make is: " + max);
	}

	

	private static void WineProb2(int[] arr, int l, int r, String ops) {

		if (ops.length() == arr.length) {
			int price = 0;
			l = 0;
			r = ops.length() - 1;
			for (int i = 0; i < ops.length(); i++) {
				char ch = ops.charAt(i);
				if (ch == 'L')
					price += arr[l++] * (i + 1);
				else if (ch == 'R')
					price += arr[r--] * (i + 1);

			}
			finalPrices.add(price);
			System.out.println(finalPrices);
			return;
		}
		WineProb2(arr, l + 1, r, ops + "L");
		WineProb2(arr, l, r - 1, ops + "R");

	}

}
