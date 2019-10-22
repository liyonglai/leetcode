/**
 * @author liyonglai
 * @date 2019/9/6
 * @description
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建11*11大小的原始数组
        int[][] chessArray = new int[11][11];
        chessArray[0][2] = 1;
        chessArray[1][3] = 2;
        chessArray[4][5] = 2;
        for (int[] rows : chessArray) {
            for (int item : rows) {
                System.out.print("  " + item);
            }
            System.out.println();
        }

        // 将原始数组转成稀疏数组
        // 遍历原始数组，统计非零值个数
        int sum = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 创建稀疏数组，其中数组的列固定为3，行为sum+1
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = chessArray.length;
        sparseArray[0][1] = chessArray[0].length;
        sparseArray[0][2] = sum;
        // 遍历原始数组将非零值存入稀疏数组中
        int rowNum = 1;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    sparseArray[rowNum][0] = i;
                    sparseArray[rowNum][1] = j;
                    sparseArray[rowNum++][2] = chessArray[i][j];
                }
            }
        }
        // 打印稀疏数组
        System.out.println("稀疏数组为：");
        for (int[] rows : sparseArray) {
            for (int item : rows) {
                System.out.print("  " + item);
            }
            System.out.println();
        }

        // 将稀疏数组还原成二维数组
        int[][] orgArray = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1; i < sparseArray.length; i++) {
            orgArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("还原初始的二维数组");
        for (int[] rows : orgArray) {
            for (int item : rows) {
                System.out.print("  " + item);
            }
            System.out.println();
        }
    }
}
