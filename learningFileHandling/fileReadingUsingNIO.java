import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class fileReadingUsingNIO{
    public static void main(String[] args){
        String path = "/home/babby/Learn/learningJava/learningFileHandling/input.txt";

        try{
            List<String> list = Files.readAllLines(Paths.get(path));
            for(String str: list){
                System.out.println(str);
            }
        }
        catch(Exception e){ e.printStackTrace(); }
    }
}
