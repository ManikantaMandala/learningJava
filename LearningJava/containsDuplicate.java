import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class containsDuplicate {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/praneeth/Documents/LearningJava/input.txt");
        Scanner sc = new Scanner(file);
        int size=sc.nextInt();
        int[] arr =new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        containsDuplicateMethod(arr);
        sc.close();
    }
    public static boolean containsDuplicateMethod(int[] arr){
        HashSet<Integer> hashset=new HashSet<Integer>();
        for(int i=0;i<arr.length;i++){
            if(hashset.contains(arr[i])){
                return true;
            }
            hashset.add(arr[i]);
        }
        return false;
    }
}
