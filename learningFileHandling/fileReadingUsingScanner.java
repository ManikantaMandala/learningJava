import java.io.File;
import java.util.Scanner;

public class fileReadingUsingScanner{
    public static void main(String[] args){
        String path = "/home/babby/Learn/learningJava/learningFileHandling/input.txt";

        Scanner sc = null;
        try{
            File file = new File(path);
            sc = new Scanner(file);

            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }
        catch(Exception e ){
            e.printStackTrace();
        }
        finally{
            sc.close();
        }
    }
}
