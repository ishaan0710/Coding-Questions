package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 */

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smallerList;
        int[] largerList;

        if (nums1.length < nums2.length) {
            smallerList = nums1;
            largerList = nums2;
        } else {
            smallerList = nums2;
            largerList = nums1;
        }

        int totalElem = nums1.length + nums2.length;
        int half = Math.floorDiv(totalElem, 2);

        int l = 0;
        int r = smallerList.length - 1;


        // Split both arrays into left and right, with i & j signify last elem to be included

        while (true) {
            int i = Math.floorDiv(l + r, 2);
            // j+1 + i+1 = half
            int j = half - 1 - i - 1;

            int aLeft = i < 0 ? Integer.MIN_VALUE : smallerList[i];
            int aRight = i + 1 >= smallerList.length ? Integer.MAX_VALUE : smallerList[i + 1];
            int bLeft = j < 0 ? Integer.MIN_VALUE : largerList[j];
            int bRight = j + 1 >= largerList.length ? Integer.MAX_VALUE : largerList[j + 1];

            if (aLeft <= bRight && bLeft <= aRight) {
                if (totalElem % 2 == 1) {
                    return Math.min(aRight, bRight);
                } else {
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0f;
                }
            } else if (aLeft > bRight) {
                r = i -1;
            } else {
                l = i + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 3};
        int[] B = {2};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(A, B));
    }
}
