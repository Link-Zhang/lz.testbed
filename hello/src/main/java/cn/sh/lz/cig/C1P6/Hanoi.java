package cn.sh.lz.cig.C1P6;

/***
 * @author Link
 * @date 2020/07/20
 * @time 11:55
 */
public class Hanoi {
    public int hanoi(int number, String left, String middle, String right) {
        if (number < 1)
            return 0;
        return process(number, left, middle, right, left, right);
    }
    
    private int process(int number, String left, String middle, String right, String from, String to) {
        if (1 == number) {
            if (from.equals(middle) || to.equals(middle)) {
//                不跨middle
//                from->to
                move(number, from, to);
                return 1;
            } else {
//                跨middle
//                from->middle->to
                move(number, from, middle);
                move(number, middle, to);
                return 2;
            }
        }
        if (from.equals(middle) || to.equals(middle)) {
//            不跨middle
//            移动方向
            String temp = (from.equals(left) || to.equals(left)) ? right : left;
//            n-1: from -> temp
            int part1 = process(number - 1, left, middle, right, from, temp);
//            1: from -> to
            int part2 = 1;
            move(number, from, to);
//            n-1: temp->to
            int part3 = process(number - 1, left, middle, right, temp, to);
            return part1 + part2 + part3;
        } else {
//            跨middle
//            n-1: from -> to
            int part1 = process(number - 1, left, middle, right, from, to);
//            1: from -> middle
            int part2 = 1;
            move(number, from, middle);
//            n-1: to -> from
            int part3 = process(number - 1, left, middle, right, to, from);
//            1: middle -> to
            int part4 = 1;
            move(number, middle, to);
//            n - 1:from -> to
            int part5 = process(number - 1, left, middle, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    private void move(int number, String from, String to) {
        if (0 > from.compareTo(to)) {
            System.out.println("Move " + number + " : " + from + " -> " + to);
        } else {
            System.out.println("Move " + number + " : " + to + " <- " + from);
        }
    }
}
