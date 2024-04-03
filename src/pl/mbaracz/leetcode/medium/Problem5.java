package pl.mbaracz.leetcode.medium;

public class Problem5 {

    public static String longestPalindrome(String text) {
        if (text == null || text.isEmpty()) return "";

        int start = 0, end = 0;

        for (int i = 0; i < text.length(); i++) {
            int len1 = expandAroundCenter(text, i, i);
            int len2 = expandAroundCenter(text, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return text.substring(start, end + 1);
    }

    private static int expandAroundCenter(String text, int left, int right) {
        while (left >= 0 && right < text.length() && text.charAt(left) == text.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    private static void test(int result, int expected) {
        if (result != expected) {
            System.out.println("Got length " + result + " expected " + expected);
        } else {
            System.out.println("OK");
        }
    }

    public static void main(String[] args) {
        test(longestPalindrome("babad").length(), 3);
        test(longestPalindrome("cbbd").length(), 2);
    }
}
