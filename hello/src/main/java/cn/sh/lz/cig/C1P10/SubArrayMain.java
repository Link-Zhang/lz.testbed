package cn.sh.lz.cig.C1P10;

/***
 * @author Link
 * @date 2020/07/24
 * @time 14:43
 */
public class SubArrayMain {
    public static void main(String[] args) {
        int[] array = new int[]{1, 6, 8};
        int number = 2;
        SubArray subArray = new SubArray();
        System.out.println(subArray.getNumber(array, number));
    }
}
