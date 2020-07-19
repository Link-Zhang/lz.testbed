package cn.sh.lz.cig.C1P1;

import java.util.Stack;

/***
 * @author Link
 * @date 2020/07/16
 * @time 17:20
 */
public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int data) {
        if (this.stackMin.isEmpty()) {
//            保存最小值的栈为空
            this.stackMin.push(data);
        } else if (data < this.getMin()) {
//            保存新的最小值
            this.stackMin.push(data);
        } else {
//            保存旧的最小值
            int min = this.stackMin.peek();
            this.stackMin.push(min);
        }
        this.stackData.push(data);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return this.stackMin.peek();
    }
}
