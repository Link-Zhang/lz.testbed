package cn.sh.lz.cig.C1P6;

/***
 * @author Link
 * @date 2020/07/21
 * @time 09:07
 */
public class SimpleHanoi1 {

    public int hanoi(int number, String left, String middle, String right) {
        if (number < 1)
            return 0;
        return process(number, left, middle, right, left, right);
    }

    private int process(int number, String left, String middle, String right, String from, String to) {
        if (1 == number) {
            move(number, from, to);
            return 1;
        }
        String temp = (left + middle + right).replace(from, "").replace(to, "");
//        n-1: from -> temp
        int part1 = process(number - 1, left, middle, right, from, temp);
//        1: from -> to
        int part2 = 1;
        move(number, from, to);
//        n-1: temp -> to
        int part3 = process(number - 1, left, middle, right, temp, to);
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
