package cn.sh.lz.cig.C1P9;

/***
 * @author Link
 * @date 2020/07/24
 * @time 11:34
 */
public class MatrixMain {
    public static void main(String[] args) {
        int[][] map = new int[][]{
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0}
        };
        Matrix matrix = new Matrix();
//        返回矩阵四点坐标：左上，右上，左下，右下
        int[] position = new int[8];
        System.out.println(matrix.maxRectangleSize(map, position));
        for (int i = 0; i < 4; i++) {
            System.out.println("( " + position[2 * i] + " , " + position[2 * i + 1] + " )");
        }
    }
}
