package com.leetcode.challenge.june;

/*
        Day 5 Challenge

Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input:
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input:
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.

*/


public class RandomPickWithWeight {

    /**
     * Your Solution object will be instantiated and called as such:
     * RandomPickWithWeight obj = new RandomPickWithWeight(w);
     * int param_1 = obj.pickIndex();
     */

    int[] wSum;
    int length = 0;
    public RandomPickWithWeight(int[] w) {
        length = w.length;
        wSum = new int[length];
        int sum = 0;
        for (int i=0; i<length; i++) {
            sum += w[i];
            wSum[i] = sum;
        }

    }

    public int pickIndex() {
        int randomNumber = (int)(wSum[length-1]*Math.random());
        int result = -1;
        int start = 0, end = length-1;

        while (start<=end) {
            int mid = (start + end)/2;
            if (randomNumber < wSum[mid]) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid +1;
            }
        }
        return result;

    }


}
