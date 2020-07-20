package cn.sh.lz.cig.C1P5;

import java.util.Stack;

/***
 * @author Link
 * @date 2020/07/20
 * @time 11:24
 */
public class SortStackByStackMain {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        System.out.println(stack);

        SortStackByStack.sortAsc(stack);
        System.out.println(stack);

        SortStackByStack.sortDesc(stack);
        System.out.println(stack);
    }
}
