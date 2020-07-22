package cn.sh.lz.cig.C1P6;

import java.util.Stack;

/***
 * @author Link
 * @date 2020/07/21
 * @time 15:12
 */
public class SimpleHanoi0 {
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
        int step = 0;
        while (rS.size() != number + 1) {
            if (1 == number % 2) {
//                A->C
                step += legalMove(left, right, lS, rS);
//                A->B
                int flag = legalMove(left, middle, lS, mS);
                step += flag;
                if (0 == flag) {
                    break;
                }
            } else {
//                A->B
                step += legalMove(left, middle, lS, mS);
//                A->C
                step += legalMove(left, right, lS, rS);
            }
            step += legalMove(middle, right, mS, rS);
        }
        return step;
    }

    public int legalMove(String AName, String BName, Stack<Integer> A, Stack<Integer> B) {
        if (A.peek() < B.peek()) {
//            A->B
            move(A.peek(), AName, BName);
            B.push(A.pop());
            return 1;
        } else if (A.peek() > B.peek()) {
//            B->A
            move(B.peek(), BName, AName);
            A.push(B.pop());
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
