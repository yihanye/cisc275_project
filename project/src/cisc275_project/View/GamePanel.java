package project.src.cisc275_project.View;

import project.src.cisc275_project.Model.Animal;
import project.src.cisc275_project.Model.Animals;
import project.src.cisc275_project.Model.GameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    static GameModel model;


    public GamePanel(){
        JPanel menuPanel = new JPanel();
        add(menuPanel);
    }

    public void setModel(GameModel model){
        this.model =model;
    }

    public void paintAnimals(Graphics g, Animals animals, BufferedImage img) {
        for(Animal a: animals.getAnimals()) {
            g.drawImage(img, (int)a.getxPos(),(int)a.getyPos(),this);
        }
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font fnt = new Font("Garamond", Font.BOLD,40);
        g2d.setFont(fnt);
        g2d.setColor(Color.white);
        g2d.drawImage(ImageLoader.mainBackground, 0, 0, this);
        AffineTransform trans = AffineTransform.getTranslateInstance
                (model.getNet().getxPos(), model.getNet().getyPos());
        trans.rotate(Math.toRadians(model.getNet().getRotation()));

        paintAnimals(g2d, model.getBlueFishList(), ImageLoader.green);
        paintAnimals(g2d, model.getBlueCrabList(), ImageLoader.gray);
        g2d.drawImage(ImageLoader.net, trans, this);
        g2d.drawString("TIME:"+model.getTime(),1000,100);
        g2d.drawString("BlueCrab:"+model.getBlueCrabList().number(),1000, 200);
        g2d.drawString("BlueFish:"+model.getBlueFishList().number(),1000, 300);


    }
}
