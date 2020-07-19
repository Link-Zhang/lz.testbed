package cn.sh.lz.cig.C1P1;

import java.util.Stack;

/***
 * @author Link
 * @date 2020/07/16
 * @time 16:33
 */
public class MyStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int data) {
        if (this.stackMin.isEmpty()) {
//            保存最小值的栈为空
            this.stackMin.push(data);
        } else if (data <= this.getMin()) {
//            保存新的最小值
            this.stackMin.push(data);
        }
//            如果无新的最小值，就不压栈
        this.stackData.push(data);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        int data = this.stackData.pop();
        if (data == this.getMin()) {
//            出栈为最小值
            this.stackMin.pop();
        }
        return data;
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return this.stackMin.peek();
    }
}
