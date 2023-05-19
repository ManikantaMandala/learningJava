import java.util.*;
public class pascalsTriangleRecursion{
    public static void main(String a[]){
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        Solution sol = new Solution();
        ArrayList<ArrayList<Integer>> pascalTriangle = sol.usingRecursion(height);
        printPascalTriangle(pascalTriangle);
        sc.close();
    }
    public static void printPascalTriangle(ArrayList<ArrayList<Integer>> pascalTriangle){
        //print the pascal's triangle
        for(ArrayList<Integer> row: pascalTriangle){
            for(int value: row){
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }
}
class Solution{
    public ArrayList<ArrayList<Integer>> usingRecursion(int ROWS){

        /*
         * Recursion Logic:
         * upperLeftNode = dp.get(i-1).get(j-1);
         * upperRightNode = dp.get(i-1).get(j);
         * return upperLeftNode + upperRightNode
         * 
         * Base case:
         * j==0 || j == currentRowSize-1 => return 1;
         */

        //Creation of Pascal's Triangle
        ArrayList<ArrayList<Integer>> pascalTriangle = new ArrayList<>();
        for(int i=0;i<ROWS;i++){
            ArrayList<Integer> currentRow = new ArrayList<>();
            currentRow.add(-1);
            if(i>0){
                for(int j=1;j<i;j++){
                    currentRow.add(-1);
                }
                currentRow.add(-1);
            }
            pascalTriangle.add(currentRow);
        }

        //Getting values
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<pascalTriangle.get(i).size();j++){
                int currentValue = value(pascalTriangle, i, j, pascalTriangle.get(i).size());
                pascalTriangle.get(i).set(j, currentValue);
            }
        }
        return pascalTriangle;
    }
    public int value(ArrayList<ArrayList<Integer>> pascalTriangle, int i, int j, int jSize){
        //Base case:
        if(j==0|| j==jSize-1){
            return 1;
        }
        //DP Statement:
        int upperLeftNode = value(pascalTriangle,i-1,j-1,jSize-1);
        int upperRightNode = value(pascalTriangle,i-1,j,jSize-1);
        return (upperLeftNode+upperRightNode);
    }
}
