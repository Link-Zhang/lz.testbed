package cn.sh.lz.cig.C1P2;

/***
 * @author Link
 * @date 2020/07/17
 * @time 16:33
 */
public class TwoStackQueueMain {
    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.add(1);
        System.out.println(queue.peek());
        queue.poll();
        queue.add(2);
        System.out.println(queue.peek());
        queue.add(3);
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue.peek());
    }
}
