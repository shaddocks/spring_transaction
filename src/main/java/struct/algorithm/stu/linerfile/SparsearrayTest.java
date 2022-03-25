package struct.algorithm.stu.linerfile;

public class SparsearrayTest {
    public static int[][] convertTwoDimensionalArrays(int[][] sparseArrays){
        //1.先读取稀疏数组第一行，创建二维数组
        int[][] twoDimensionalArrays = new int[sparseArrays[0][0]][sparseArrays[0][1]];
        //2.二维数组赋值
        for (int i = 0; i < sparseArrays.length; ++i) {
            twoDimensionalArrays[sparseArrays[i][0]][sparseArrays[i][1]] = sparseArrays[i][2];
        }
        return twoDimensionalArrays;
    }

    public static int[][] convertSparseArrays(int[][] twoDimensionalArrays){
        int count = 0;
        //1.得到非0元素
        for (int[] i: twoDimensionalArrays) {
            for (int j : i) {
                if (j != 0)count++;
            }
        }
        //2.创建对应的稀疏数组
        int[][] sparseArrays = new int[count + 1][3];
        //3.稀疏数组赋值
        sparseArrays[0][0] = twoDimensionalArrays.length;
        sparseArrays[0][1] = twoDimensionalArrays[0].length;
        sparseArrays[0][2] = count;
        int point = 1;
        for (int i = 0; i < twoDimensionalArrays.length; ++i) {
            for (int j = 0; j < twoDimensionalArrays[0].length; ++j) {
                if (twoDimensionalArrays[i][j] != 0) {
                    sparseArrays[point][0] = i;
                    sparseArrays[point][1] = j;
                    sparseArrays[point][2] = twoDimensionalArrays[i][j];
                    point++;
                }
            }
        }
        return sparseArrays;
    }
}
