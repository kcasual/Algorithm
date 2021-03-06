package com.cangxiao.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * @Author cangxiao
 * @Date 2021/4/18
 * @Desc 每日温度
 */
public class Solution2 {
    public int[] dailyTemperatures(int[] T) {
        int[] days = new int[T.length];
        if(T.length<2){
            days = new int[]{0};
        }
        Stack<Integer> stack =new Stack<>();
        for (int i = 0; i < T.length; i++) {
            //必须穷尽stack中比T[i]小的元素，如72>71 并且72>69, 如果不用while循环，则只能得到71的相差天数，不能得到69的相差天数
            while (!stack.isEmpty() && T[i]>T[stack.peek()]){
                int index = stack.pop();
                days[index] = i - index;
            }
            stack.push(i);
        }
        //如果栈中还有元素， 说明没有比其温度更大的温度了，直接默认为0；
        return days;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures)));
    }
}
