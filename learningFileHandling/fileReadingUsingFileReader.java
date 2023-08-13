import java.io.File;
import java.io.FileReader;

public class fileReadingUsingFileReader{
    public static void main(String[] args){
        String path = "/home/babby/Learn/learningJava/learningFileHandling/input.txt";
        FileReader fr=null;
        try{
            File file = new File(path);

            fr = new FileReader(file);

            int c =0;
            while((c=fr.read())!=-1){System.out.print((char)c);}

        }
        catch(Exception e){ e.printStackTrace(); }
        finally{
            try{
                fr.close();
            }
            catch(Exception e){ e.printStackTrace(); }
        }
    }
}
