package project.src.cisc275_project.View;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
    static BufferedImage green = createImg("green");
    static BufferedImage gray = createImg("gray");
    static BufferedImage bass = createImg("bass");
    static BufferedImage summerFlunder = createImg("summerFlunder");
    static BufferedImage blueFish = createImg("blueFish");
    static BufferedImage background = createImg("background");
    static BufferedImage net = createImg("net");
    static BufferedImage blueCrab = createImg("blueCrab");
    static BufferedImage quizBackground = createImg("quizBackground");
    static BufferedImage mainBackground = createImg("mainBackground");
    static BufferedImage explanBackground = createImg("explanBackground");
    static BufferedImage startBackground = createImg("startBackground");

   public static BufferedImage createImg(String name){
        BufferedImage img;
        try {
            img = ImageIO.read(new File("project/images/"+name+".png"));
            return img;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
