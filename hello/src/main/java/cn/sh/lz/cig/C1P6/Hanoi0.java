package cn.sh.lz.cig.C1P6;

import java.util.Stack;

/***
 * @author Link
 * @date 2020/07/21
 * @time 13:37
 */
public class Hanoi0 {
    public enum Action {
        No, LToM, MToL, MToR, RToM
    }

    public int hanoi(int number, String left, String middle, String right) {
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for (int i = number; i > 0; i--) {
            lS.push(i);
        }
//        用数组是为了可以修改record0
        Action[] record = {Action.No};
        int step = 0;
        while (rS.size() != number + 1) {
            step += fromStack2toStack(record, Action.MToL, Action.LToM, lS, mS, left, middle);
            step += fromStack2toStack(record, Action.LToM, Action.MToL, mS, lS, middle, left);
            step += fromStack2toStack(record, Action.RToM, Action.MToR, mS, rS, middle, right);
            step += fromStack2toStack(record, Action.MToR, Action.RToM, rS, mS, right, middle);
        }
        return step;
    }

    public int fromStack2toStack(Action[] record, Action banAction, Action action, Stack<Integer> fromStack, Stack<Integer> toStack, String from, String to) {
        if (record[0] != banAction && fromStack.peek() < toStack.peek()) {
            toStack.push(fromStack.pop());
            move(toStack.peek(), from, to);
            record[0] = action;
            return 1;
        }
        return 0;
    }

    private void move(int number, String from, String to) {
        if (0 > from.compareTo(to)) {
            System.out.println("Move " + number + " : " + from + " -> " + to);
        } else {
            System.out.println("Move " + number + " : " + to + " <- " + from);
        }
    }
}
