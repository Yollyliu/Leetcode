package array;

import java.util.Scanner;

public class MaxIsland {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int [][]arr=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=scanner.nextInt();
             //   System.out.print(arr[i][j]+" ");
            }
        }


        int ans=new MaxIsland().correct(arr);
        System.out.println(ans);
    }


    public int correct(int [][]grid){
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,correctrun(grid,i,j));
                }
            }
        }
        return max;
    }

    public int correctrun(int[][]grid, int i,int j){
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j]==1){

            grid[i][j]=0;
            return 1+ correctrun(grid,i,j+1)+correctrun(grid,i,j-1)
                    +correctrun(grid,i+1,j)+correctrun(grid,i-1,j);
        }
        return 0;
    }



    public int run(int [][]grid){
        int row=grid.length;
        int column=grid[0].length;
        int ans=0,max=0;
        int pr=0,pc=0;
        boolean [][] flag=new boolean[row][column];
        for(int r=0;r<row;r++) {
            for (int c = 0; c < column; c++) {
//        int r=0,c=0;
//        while((r<row-1)&&(c<column-1)) {

                if ((grid[r][c] == 1) && (flag[r][c] == false)) {
                    ans = depthf(r, c, grid, flag);
                }

            }
//                if((grid[i][j]==1)&&(flag[i][j]==false)){
//                    ans++;
//                    pr=i;
//                    pc=j;
//                    int tempc=i;
//                    flag[i][j]=true;
//
//
//                    while((pr+1)<column) {        //dpf
//                        if (grid[pr + 1][j] == 1) {
//                            ans++;
//                            pr++;
//
//                        } else {
//                            break;
//                        }
//                    }
//                    while(pr>=i) {
//                        while ((tempc - 1) >= 0) {             //left
//                            if (grid[i][tempc - 1] == 1) {
//                                ans++;
//                                tempc--;
//                            } else {
//                                break;
//                            }
//                        }
//
//                        tempc=j;
//
//                        while ((tempc + 1) < column) {          //right
//                            if (grid[i][tempc + 1] == 1) {
//                                ans++;
//                                tempc++;
//                            } else {
//                                break;
//                            }
//                        }
//                        pr--;
//                    }
            if (max < ans) {
                max = ans;
            }

            // }

            //  }
            // }
        }
        return max;
    }

    public int depthf(int i,int j, int [][]grid, boolean [][] flag){
        if((i==grid.length-1)||(j==grid[i].length-1)) {return 0;}
        else {
            int ans = 1;
            int row = grid.length;
            int column = grid[0].length;
            //  System.out.println(column);
            int tempc = j, pr = i;
            while ((pr + 1) < row - 1) {        //dpf
                if ((grid[pr + 1][j] == 1) && (flag[pr + 1][j] == false)) {
                    ans++;
                    pr++;

                } else {
                    break;
                }
            }
            while (pr >= i) {
                if ((tempc - 1 == 0) || (tempc == column - 1)) {
                    return 0;
                }
                while ((tempc - 1) > 0) {
                    if (tempc - 1 == 0) {
                        return grid[pr][0];
                    } else {
                        if ((grid[i][tempc - 1] == 1) && (flag[i][j] == false)) {
                            ans++;
                            tempc--;
                            depthf(pr, tempc, grid, flag);
                        } else {
                            break;
                        }
                    }
                }

                tempc = j;

                while ((tempc + 1) < column - 1) {
                    if (tempc - 1 == 0) {
                        return grid[pr][0] ;
                    } else {
                    }
                    if ((grid[i][tempc + 1] == 1) && (flag[i][j] == false)) {
                        ans++;
                        tempc++;
                        depthf(pr, tempc, grid, flag);
                    } else {
                        break;
                    }
                }
            }
                pr--;

            return ans;
        }

    }




}
