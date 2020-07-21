package cn.sh.lz.cig.C1P6;

/***
 * @author Link
 * @date 2020/07/20
 * @time 12:03
 */
public class HanoiMain {
    public static void main(String[] args) {
        SimpleHanoi simpleHanoi = new SimpleHanoi();
        System.out.println("Total steps is " + simpleHanoi.hanoi(3, "left", "middle", "right"));

        SimpleHanoi1 simpleHanoi1 = new SimpleHanoi1();
        System.out.println("Total steps is " + simpleHanoi1.hanoi(3, "left", "middle", "right"));

        Hanoi hanoi = new Hanoi();
        System.out.println("Total steps is " + hanoi.hanoi(1, "left", "middle", "right"));
        System.out.println("Total steps is " + hanoi.hanoi(2, "left", "middle", "right"));
        System.out.println("Total steps is " + hanoi.hanoi(3, "left", "middle", "right"));
    }
}
