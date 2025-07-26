package com.itachi.leetcode.greedy;

//55. 跳跃游戏
public class CanJump {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1,3, 4};

        //int[] nums = new int[]{100, 3, 1, 1, 4};
        new CanJump().jump(nums);
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围：最大覆盖范围的计算公式应该为 当前元素的值+元素的Index
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            //每次都取最大值
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
    //45. 跳跃游戏 II
    public int jump(int[] nums) {
        int length = nums.length; //数组的长度
        int end = 0;  // 上次跳跃可达范围右边界（下次的最右起跳点）
        int maxPosition = 0; // 当前跳跃能跳到的最远位置
        int steps = 0; // 跳跃次数
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 到达上次跳跃能到达的右边界了
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
