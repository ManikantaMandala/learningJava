import java.io.File;
import java.io.FileInputStream;

public class fileReadingUsingFileInputStream{
    public static void main(String[] args){
        String path = "/home/babby/Learn/learningJava/learningFileHandling/input.txt";
        FileInputStream fis = null;

        try{
            File file = new File(path);

            fis = new FileInputStream(file);

            int c =0;
            while((c=fis.read())!=-1){
                System.out.print((char) c);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                fis.close();
            }
            catch(Exception e){ e.printStackTrace(); }
        }
    }
}
