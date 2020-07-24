package cn.sh.lz.cig.C1P7;

/***
 * @author Link
 * @date 2020/07/23
 * @time 10:29
 */
public class SlidingWindowMain {
    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
        int[] arr = new int[]{4, 3, 5, 4, 2, 3, 6, 7};
        int w = 3;
        int[] max = slidingWindow.getMax(arr, w);
        for (int aResult : max) {
            System.out.print(aResult + ", ");
        }
        System.out.println();
        int[] min = slidingWindow.getMin(arr, w);
        for (int aResult : min) {
            System.out.print(aResult + ", ");
        }
    }
}
