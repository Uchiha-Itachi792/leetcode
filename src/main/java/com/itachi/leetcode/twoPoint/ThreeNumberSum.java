package com.itachi.leetcode.twoPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ThreeNumberSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }


    /**
     * 如果不对数组进行排序，那么可能输出多个结果，比如输出（a,b,c），(b,a,c)，（c,a,b）等，这样是无意义的，并且会增加程序复杂度
     * 因此需要先对数组进行排序。
     * a + b + c =0，并且a,b,c三者之间互不相等
     * 1. 若a固定，b固定，那么c也就固定了，但是考虑到数组中有重复值，若c的下一位元素的值和c相等，应该跳过它.
     * 当然也可以想成: b 和 c固定，查看a的下一位元素是否和a相等
     * 2. 若a固定，那么 bcSum = b+c = 0 -a ,也就意味着若b增大，那么c必然需要减小 (c = bcSum - b)。我们可以使用双指针，一个指针从小到大遍历，一个从大到小遍历。
     * 若存在b + c >bcSum，那么就减少c的值(右指针往左移)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //遍历a的值
        for (int first = 0; first < length; first++) {
            //针对于a，跳过相同值
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            //计算 b+c的目标和
            int bcSum = 0 - nums[first];
            //c的下标，也就是右指针
            int right = length - 1;
            //left为b的下标，也就是左指针
            for (int left = first + 1; left < length; ++left) {
                //针对于b，跳过相同值
                if (left > first + 1 && nums[left] == nums[left - 1]) {
                    continue;
                }
                //while循环寻找目标c，c需要满足 b +c <=bcSum
                while (left < right && nums[left] + nums[right] > bcSum) {
                    right--;
                }

                //如果左右指针都相等了，那么直接break
                if (left ==right) {
                    break;
                }

                if (nums[left] + nums[right] == bcSum) {
                    List<Integer> an = new ArrayList<>();
                    an.add(nums[first]);
                    an.add(nums[left]);
                    an.add(nums[right]);
                    ans.add(an);
                }
            }
        }
        return ans;
    }

}
