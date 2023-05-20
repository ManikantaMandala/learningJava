import java.util.*;
public class pascalsTriangleIteration{
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        Solution sol = new Solution();
        ArrayList<ArrayList<Integer>> pascalTriangle = sol.pascalTriangleCreation(height);
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
    public ArrayList<ArrayList<Integer>> pascalTriangleCreation(int height){
        // Create a 2D ArrayList to store the triangle
        ArrayList<ArrayList<Integer>> pascalTriangle = new ArrayList<>();
        // Generate the triangle
        for (int row = 0; row < height; row++) {
            ArrayList<Integer> currentRow = new ArrayList<>();
            // The first and last elements of each row are 1
            currentRow.add(1);
            if (row > 0) {
                ArrayList<Integer> previousRow = pascalTriangle.get(row - 1);
                for (int col = 1; col < row; col++) {
                    int value = previousRow.get(col - 1) + previousRow.get(col);
                    currentRow.add(value);
                }
                currentRow.add(1);
            }
            pascalTriangle.add(currentRow);
        }
        return pascalTriangle;
    }
}
