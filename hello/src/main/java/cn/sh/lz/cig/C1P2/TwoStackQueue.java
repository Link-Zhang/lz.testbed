package cn.sh.lz.cig.C1P2;

import java.util.Stack;

/***
 * @author Link
 * @date 2020/07/17
 * @time 16:17
 */
public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    public void add(int data) {
        this.stackPush.push(data);
    }

    public int poll() {
        queueHandle();
        return stackPop.pop();
    }
    
    public int peek() {
        queueHandle();
        return stackPop.peek();
    }

    private void queueHandle() {
        if (this.stackPop.isEmpty() && this.stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (this.stackPop.isEmpty()) {
            while (!this.stackPush.isEmpty()) {
                this.stackPop.push(this.stackPush.pop());
            }
        }
    }
}
