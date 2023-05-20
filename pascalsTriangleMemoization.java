import java.util.*;
public class pascalsTriangleMemoization{
    public static void main(String a[]){
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        Solution sol = new Solution();
        ArrayList<ArrayList<Integer>> pascalTriangle = sol.usingMemoization(height);
        printPascalTriangle(pascalTriangle);
        sc.close();
    }
    public static void printPascalTriangle(ArrayList<ArrayList<Integer>> pascalTriangle){
        //print the pascal's triangle
        for (ArrayList<Integer> row : pascalTriangle) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
class Solution{
    public ArrayList<ArrayList<Integer>> usingMemoization(int ROWS){

        /* Optimal substructure - yes
         * Optimal subproblem - yes
         *
         * DP State: 
         * We want to add the previous rows adjecent values
         *
         * DP statement
         * if(dp.get(i).get(j)==-1){
         * upperLeftNode = dp.get(i-1).get(j-1);
         * upperRightNode = dp.get(i-1).get(j);
         * dp.get(i).set(j, upperLeftNode+upperRightNode);
         * }
         * else dp.get(i).get(j);
         *
         * Base case
         * if j ==0 || j == currentRowSize-1 => return 1;
         */

        //Creation of dp ArrayList
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for(int i=0;i<ROWS;i++){
            ArrayList<Integer> currentRow = new ArrayList<>();
            currentRow.add(-1);
            if(i>0){
                for(int j=1;j<i;j++){
                    currentRow.add(-1);
                }
                currentRow.add(-1);
            }
            dp.add(currentRow);
        }

        //Getting values
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<dp.get(i).size();j++){
                int currentValue = value(dp, i, j, dp.get(i).size());
                dp.get(i).set(j, currentValue);
            }
        }
        return dp;
    }
    public int value(ArrayList<ArrayList<Integer>> dp, int i, int j, int jSize){
        //Base case:
        if(j==0|| j==jSize-1){
            return 1;
        }
        //DP Statement:
        if(dp.get(i).get(j)==-1){
            int upperLeftNode = value(dp,i-1,j-1,jSize-1);
            int upperRightNode = value(dp,i-1,j,jSize-1);
            return (upperLeftNode+upperRightNode);
        }
        return dp.get(i).get(j);
    }
}
