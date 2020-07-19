package cn.sh.lz.cig.C1P3;

import java.util.Stack;

/***
 * @author Link
 * @date 2020/07/17
 * @time 16:50
 */
public class ReverseStackMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        int bottom = ReverseStack.peekStackBottom(stack);
        System.out.println(bottom);
        System.out.println(stack);

        bottom = ReverseStack.peekAndRemoveStackBottom(stack);
        System.out.println(bottom);
        System.out.println(stack);

        bottom = ReverseStack.peekStackBottom(stack);
        System.out.println(bottom);
        System.out.println(stack);

        ReverseStack.reverse(stack);
        System.out.println(stack);
    }
}
