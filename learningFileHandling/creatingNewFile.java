import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class creatingNewFile {
    public static void main(String[] args) {
        creatingNewFile cnf = new creatingNewFile();
        cnf.creatingNewFileMethod("/home/babby/log.txt");
    }

    public void creatingNewFileMethod(String pathName){

        // 1. Using File class
        try{
            File newFilePathName = new File(pathName);
            if(newFilePathName.createNewFile()){
                System.out.println("The file is created!");
            }
            else{
                System.out.println("File is already present in the directory!");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        // 2. FileOutputStream class:
        try{
            Scanner sc = new Scanner(new File("./input.txt"));
            FileOutputStream fos = new FileOutputStream(sc.nextLine(), true);

            byte[] b = sc.nextLine().getBytes();

            fos.write(b);
            fos.close();

            System.out.println("File is saved!");
        }
        catch(Exception e){
            System.out.println(e);
        }

        // 3. Java nio package

        try{
            Scanner sc = new Scanner(new File("./input.txt"));
            Path pathLocation = Paths.get(sc.nextLine()+"s");
            Path newPath = Files.createFile(pathLocation);
            System.out.println("File Created");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
