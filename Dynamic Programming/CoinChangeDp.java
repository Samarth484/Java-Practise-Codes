package DyamicProgramming;

import java.util.Scanner;

public class CoinChangeDp {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
System.out.println();
		int sum = scn.nextInt();
		int m = scn.nextInt();
		int denom[] = new int[m];
		for (int i = 0; i < m; i++)
			denom[i] = scn.nextInt();
		int strg[][] = new int[denom.length][sum + 1];
		System.out.println(CoinChange(denom, sum, 0, strg));
	}

	public static int CoinChange(int denom[], int sum, int vidx, int strg[][]) {

		if (vidx >= denom.length || sum < 0)
			return 0;
		if (sum == 0)
			return 1;
		if (strg[vidx][sum] != 0)
			return strg[vidx][sum];
		int o1 = CoinChange(denom, sum, vidx + 1, strg);

		int o2 = CoinChange(denom, sum - denom[vidx], vidx, strg);

		int ans = o1 + o2;
		if (sum < 0)
			return ans;
		return strg[vidx][sum] = ans;
	}

}
