import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.function.Function;

public class containsDuplicate {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/praneeth/Documents/LearningJava/input.txt");
        Scanner sc = new Scanner(file);
        String str1= sc.nextLine();
        String str2= sc.nextLine();
        isAnagram(str1,str2);
    }
    public static boolean containsDuplicate(int[] arr){
        HashSet<Integer> hashset=new HashSet();
        for(int i=0;i<arr.length;i++){
            if(hashset.contains(arr[i])){
                return true;
            }
            hashset.add(arr[i]);
        }
        return false;
    }

    public static boolean isAnagram(String s,String t){

        return false;
    }
}
