package project.src.cisc275_project.View;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
    static BufferedImage green = createImg("green");
    static BufferedImage gray = createImg("gray");
    static BufferedImage background = createImg("background");
    static BufferedImage net = createImg("red");
    static BufferedImage quizBackground = createImg("quizBackground");
    static BufferedImage mainBackground = createImg("mainBackground");

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
