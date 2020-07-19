package cn.sh.lz.cig.C1P1;

/***
 * @author Link
 * @date 2020/07/16
 * @time 16:33
 */
public class MyStackMain {
    public static void printMin(MyStack myStack) {
        System.out.println("The Min in MyStack is :");
        System.out.println(myStack.getMin());
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(4);
        printMin(myStack);

        myStack.push(5);
        printMin(myStack);

        myStack.push(1);
        printMin(myStack);

        myStack.push(2);
        printMin(myStack);

        myStack.pop();
        myStack.pop();
        myStack.pop();
        printMin(myStack);

        myStack.push(1);
        printMin(myStack);
    }
}
