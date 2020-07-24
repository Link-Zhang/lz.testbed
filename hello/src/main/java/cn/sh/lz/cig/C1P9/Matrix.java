package cn.sh.lz.cig.C1P9;

import java.util.Stack;

/***
 * @author Link
 * @date 2020/07/24
 * @time 11:00
 */
public class Matrix {
    public int maxRectangleSize(int[][] map, int[] position) {
        if (null == map || 0 == map.length || 0 == map[0].length)
            return 0;
        int maxArea = 0;
//      hY[0]返回高度坐标，hY[1]返回Y1，hY[2]返回Y2
        int[] hY = new int[3];
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = 0 == map[i][j] ? 0 : height[j] + 1;
            }
            int result = maxFromBottom(height, hY);
            if (result > maxArea) {
                maxArea = result;
//                左上
                position[0] = i - height[hY[0]] + 1;
                position[1] = hY[1];

//                右上
                position[2] = position[0];
                position[3] = hY[2];

//                左下
                position[4] = i;
                position[5] = position[1];

//                右下
                position[6] = position[4];
                position[7] = position[3];
            }
        }
        return maxArea;
    }

    private int maxFromBottom(int[] height, int[] hY) {
        if (null == height || 0 == height.length)
            return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - (k + 1)) * height[j];
                if (curArea > maxArea) {
                    maxArea = curArea;
                    hY[0] = j;
                    hY[1] = k + 1;
                    hY[2] = i - 1;
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - (k + 1)) * height[j];
            if (curArea > maxArea) {
                maxArea = curArea;
                hY[0] = j;
                hY[1] = k + 1;
                hY[2] = height.length - 1;
            }
        }
        return maxArea;
    }
}
