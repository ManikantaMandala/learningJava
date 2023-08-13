import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class imageFormatConversion{
    public static void main(String[] args){
        try{
            URL url = new URL("https://w.wallhaven.cc/full/gj/wallhaven-gjzyke.png");

            BufferedImage image =  ImageIO.read(url);

            ImageIO.write(image, "jpg", new File("./deadPool.jpg"));
            ImageIO.write(image, "bmp", new File("./deadPool.bmp"));
            ImageIO.write(image, "gif", new File("./deadPool.gif"));
            ImageIO.write(image, "png", new File("./deadPool.png"));

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
