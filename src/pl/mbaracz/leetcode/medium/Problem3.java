package pl.mbaracz.leetcode.medium;

public class Problem3 {

    public static int lengthOfLongestSubstring(String string) {
        int n = string.length();
        int maxLen = 0;
        int[] charIndex = new int[128];

        for (int end = 0, start = 0; end < n; end++) {
            char currChar = string.charAt(end);
            start = Math.max(charIndex[currChar], start);
            maxLen = Math.max(maxLen, end - start + 1);
            charIndex[currChar] = end + 1;
        }

        return maxLen;
    }

    private static void test(int result, int expected) {
        if (result != expected) {
            System.out.println("Got length " + result + " expected " + expected);
        } else {
            System.out.println("OK");
        }
    }

    public static void main(String[] args) {
        test(lengthOfLongestSubstring(" "), 1);
        test(lengthOfLongestSubstring("au"), 2);
        test(lengthOfLongestSubstring("abcabcbb"), 3);
        test(lengthOfLongestSubstring("bbbbb"), 1);
        test(lengthOfLongestSubstring("pwwkew"), 3);
    }
}
