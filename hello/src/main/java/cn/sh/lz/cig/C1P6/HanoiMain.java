package cn.sh.lz.cig.C1P6;

/***
 * @author Link
 * @date 2020/07/20
 * @time 12:03
 */
public class HanoiMain {
    public static void main(String[] args) {
        SimpleHanoi0 simpleHanoi0 = new SimpleHanoi0();
        System.out.println("Total steps is " + simpleHanoi0.hanoi(3, "left", "middle", "right"));

        SimpleHanoi simpleHanoi = new SimpleHanoi();
        System.out.println("Total steps is " + simpleHanoi.hanoi(3, "left", "middle", "right"));

        SimpleHanoi2 simpleHanoi2 = new SimpleHanoi2();
        System.out.println("Total steps is " + simpleHanoi2.hanoi(3, "left", "middle", "right"));

        Hanoi hanoi = new Hanoi();
        System.out.println("Total steps is " + hanoi.hanoi(3, "left", "middle", "right"));

        Hanoi0 hanoi0 = new Hanoi0();
        System.out.println("Total steps is " + hanoi0.hanoi(3, "left", "middle", "right"));
    }
}
