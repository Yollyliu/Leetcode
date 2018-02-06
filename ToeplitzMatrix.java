package Week68;

import java.util.Scanner;


public class ToeplitzMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("row");
        int m = scanner.nextInt();
        scanner.nextLine();
        System.out.println("column");
        int n=scanner.nextInt();
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=scanner.nextInt();
            }
        }
        new ToeplitzMatrix().run(matrix);
    }

    public boolean run(int[][] matrix) {
        int row=matrix[0].length;
        int column=matrix.length;
        int min= row> column ? column: row;



        int[] linerow = new int[matrix.length - 1];
        int[] linecolumn = new int[matrix[0].length - 1];
        linerow[0] = matrix[0][0];
        linecolumn[0] = matrix[0][0];
        for (int i = 1; i < matrix.length -1; i++) {
            linerow[i] = matrix[i][0];


        }
        for(int j=1;j<matrix[0].length-1;j++){
            linecolumn[j] = matrix[0][j];
        }

        for (int i =0; i < min; i++) {
            if (matrix[i][i] != linerow[0]) {
                return false;
            }
        }

            for (int f = 0; f < matrix.length - 1; f++) {
                for (int k = 0; k < min; k++) {
                    if (matrix[f+k][k] != linerow[f]) {
                        return false;
                    }
                }

            }
            for(int i=1;i<column;i++) {
                for (int k = 0; k < min; k++) {
                    if (matrix[i + k][k] != linecolumn[i]) {
                        return false;
                    }
                }
            }

        return true;
    }


    public boolean isToeplitzMatrix(int[][] matrix) {       //right
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
            }
        }
        return true;
    }



}
