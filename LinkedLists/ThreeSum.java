import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import com.sun.tools.javac.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int arr[] = { -1, 0, 1, 2, -1, -4 };

		System.out.println("FINAL ANSWER IS" + threeSum(arr));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
						String str = "";
						str=""+nums[i] + nums[j] + nums[k];
//						System.out.println(str);
						if (alreadyPresent(result, str) == false) {
							result.add(temp);
						}

					}
				}
			}
		}
		return result;

	}

	private static boolean alreadyPresent(List<List<Integer>> result, String str) {
		if (result.size() == 0)
			return false;
		String checker = "";
		List<Integer> val = new ArrayList<Integer>();
		for (int i = 0; i < result.size(); i++) {
			val = result.get(i);
			checker = "";
			for (int j = 0; j < val.size(); j++) {
				checker += val.get(j);
			}
//			System.out.println("Checker is " + checker + " and str is " + str);
			if (checker.equals(str))
				return true;
		}

		return false;
	}

	private static boolean alreadyPresent(List<List<Integer>> result, ArrayList<Integer> temp) {
		if (result.size() == 0 || temp.size() == 0)
			return false;
		System.out.println("in alreadyPresent result is " + result);
		System.out.println("in alreadyPresent temp is " + temp);
		List<Integer> val = new ArrayList<Integer>();
		for (int i = 0; i < result.size(); i++) {
			val = result.get(i);
			System.out.println("val is " + val);
			for (int j = 0; j < val.size(); j++) {
				int checker = 0;
				if (val.get(j) == temp.get(j)) {
					checker += 1;
				}
				if (checker == val.size() - 1)
					return true;

			}
		}
		System.out.println("true rha");
		return false;
	}

}
