package cn.sh.lz.cig.C1P6;

/***
 * @author Link
 * @date 2020/07/20
 * @time 12:03
 */
public class HanoiMain {
    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        System.out.println("Total steps is " + hanoi.hanoi00(3, "left", "middle", "right"));
        System.out.println("Total steps is " + hanoi.hanoi0(3, "left", "middle", "right"));

//        System.out.println("Total steps is " + hanoi.hanoi(1, "left", "middle", "right"));
//        System.out.println("Total steps is " + hanoi.hanoi(2, "left", "middle", "right"));
        System.out.println("Total steps is " + hanoi.hanoi(3, "left", "middle", "right"));
    }
}
