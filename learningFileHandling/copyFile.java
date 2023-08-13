import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;

public class copyFile {
    public static void main(String[] args) {
        copyFileMethod("https://docs.oracle.com/javase/7/docs/api/java/net/URI.html", "./URI_copy.html");
    }

    public static void copyFileMethod(String p1, String p2) {
        URI uriPath;
        File file1, file2;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            uriPath = new URI(p1);
            file1 = new File(uriPath);
            file2 = new File(p2);

            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);

            System.out.println(fis.available());

            int i;
            while ((i = fis.read()) != -1) {
                fos.write(i);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (fis != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
    }
}
