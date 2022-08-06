import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class isAnagram {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/praneeth/Documents/LearningJava/input.txt");
        Scanner sc = new Scanner(file);
        String str1= sc.nextLine();
        String str2= sc.nextLine();
        isAnagram(str1,str2);
    }
    public static boolean isAnagram(String s,String t){
        HashMap<Character,Integer> anagramMap = new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            anagramMap.put(s.charAt(i),anagramMap.containsKey(s.charAt(i))? anagramMap.get(s.charAt(i))+1: 1);
            if(anagramMap.containsKey(t.charAt(i))){
                anagramMap.put(t.charAt(i),anagramMap.get(t.charAt(i))-1);
            }
            else{
                return false;
            }
        }
        return false;
    }
}
