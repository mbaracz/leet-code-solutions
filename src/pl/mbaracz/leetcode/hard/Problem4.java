package pl.mbaracz.leetcode.hard;

public class Problem4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int totalLen = nums1Len + nums2Len;
        int[] merged = new int[totalLen];

        int i = 0, j = 0, k = 0;
        while (i < nums1Len && j < nums2Len) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < nums1Len) {
            merged[k++] = nums1[i++];
        }

        while (j < nums2Len) {
            merged[k++] = nums2[j++];
        }

        if (totalLen % 2 == 0) {
            int mid1 = totalLen / 2 - 1;
            int mid2 = totalLen / 2;
            return (merged[mid1] + merged[mid2]) / 2.0;
        } else {
            return merged[totalLen / 2];
        }
    }

    private static void test(double result, double expected) {
        if (result != expected) {
            System.out.println("Got " + result + " expected " + expected);
        } else {
            System.out.println("OK");
        }
    }

    public static void main(String[] args) {
        test(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 2.0);
        test(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 2.5);
    }
}
