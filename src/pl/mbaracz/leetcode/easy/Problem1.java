package pl.mbaracz.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);

            if (index != null) {
                return new int[]{index, i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }

    private static void test(int[] result, String expected) {
        String resultText = Arrays.toString(result);

        if (!resultText.equals(expected)) {
            System.out.println("Failed, got: " + resultText + " expected: " + expected);
        } else {
            System.out.println("OK");
        }
    }

    public static void main(String[] args) {
        test(twoSum(new int[]{3, 3}, 6), "[0, 1]");
        test(twoSum(new int[]{3, 2, 4}, 6), "[1, 2]");
        test(twoSum(new int[]{2, 7, 11, 15}, 9), "[0, 1]");
    }
}
