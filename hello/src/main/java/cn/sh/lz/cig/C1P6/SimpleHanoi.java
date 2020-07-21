package cn.sh.lz.cig.C1P6;

/***
 * @author Link
 * @date 2020/07/21
 * @time 09:05
 */
public class SimpleHanoi {
    public int hanoi(int number, String left, String middle, String right) {
        if (number < 1)
            return 0;
        return process(number, left, middle, right);
    }

    private int process(int number, String left, String middle, String right) {
        if (1 == number) {
            move(number, left, right);
            return 1;
        }
        int part1 = process(number - 1, left, right, middle);
        int part2 = 1;
        move(number, left, right);
        int part3 = process(number - 1, middle, left, right);
        return part1 + part2 + part3;
    }

    private void move(int number, String from, String to) {
        if (0 > from.compareTo(to)) {
            System.out.println("Move " + number + " : " + from + " -> " + to);
        } else {
            System.out.println("Move " + number + " : " + to + " <- " + from);
        }
    }
}
