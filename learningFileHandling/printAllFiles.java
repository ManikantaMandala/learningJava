import java.io.File;

public class printAllFiles{
    public static void main(String[] args){
        printAllFiles paf = new printAllFiles();
        paf. printAllKindsOfFiles("/home/babby");
    }
    public void printAllKindsOfFiles(String path){
        File file = new File(path);

        File[] fileList = file.listFiles();

        for(File e: fileList){
            if(e.isFile()){
                System.out.println("File: " + e.getName());
            }
            else if(e.isDirectory()){
                System.out.println("Directory: "+ e.getName());
            }
            else{
                System.out.println("Not know files: "+ e.getName());
            }
        }
    }
}
