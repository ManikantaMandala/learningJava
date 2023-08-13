import java.awt.*;
import java.io.*;

public class fileOpeningUsingDesktop {
    public static void main(String[] args) {
        String path = "/input.txt";
        try {
            File file = new File(path);

            if (!Desktop.isDesktopSupported()) {
                System.out.println("Desktop is not supported");
            }

            Desktop desktop = Desktop.getDesktop();

            if (file.exists()) {
                desktop.open(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
