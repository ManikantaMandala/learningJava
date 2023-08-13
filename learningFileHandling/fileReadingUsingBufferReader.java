import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class fileReadingUsingBufferReader{
    public static void main(String[] ags){
        String path = "/home/babby/Learn/learningJava/learningFileHandling/input.txt";
        BufferedReader br =null;
        try{
            File file = new File(path);

            br = new BufferedReader(new FileReader(file));

            int c =0;
            while((c=br.read())!=-1){System.out.print((char)c);}

        }
        catch(Exception e){ e.printStackTrace(); }
        finally{
            try{
                br.close();
            }
            catch(Exception e){ e.printStackTrace(); }
        }
    }
}
