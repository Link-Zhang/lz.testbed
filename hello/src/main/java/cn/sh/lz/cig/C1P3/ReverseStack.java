package cn.sh.lz.cig.C1P3;

import java.util.Stack;

/***
 * @author Link
 * @date 2020/07/17
 * @time 16:41
 */
public class ReverseStack {
    public static int peekAndRemoveStackBottom(Stack<Integer> stack) {
//      stack not empty!
        int data = stack.pop();
        if (stack.isEmpty()) {
            return data;
        } else {
            int bottom = peekAndRemoveStackBottom(stack);
            stack.push(data);
            return bottom;
        }
    }

    public static int peekStackBottom(Stack<Integer> stack) {
//        stack not empty!
        int data = stack.pop();
        if (stack.isEmpty()) {
            stack.push(data);
            return data;
        } else {
            int bottom = peekStackBottom(stack);
            stack.push(data);
            return bottom;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = peekAndRemoveStackBottom(stack);
        reverse(stack);
        stack.push(last);
    }
}
