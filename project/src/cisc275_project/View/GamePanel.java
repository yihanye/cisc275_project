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
    final static int left = 0;
    final static int right = 1;


    public GamePanel(){
        JPanel menuPanel = new JPanel();
        add(menuPanel);
    }

    public void setModel(GameModel model){
        this.model =model;
    }

    public void paintAnimal(Graphics g, Animal a, BufferedImage img){
        g.drawImage(img,(int)a.getxPos(),(int)a.getyPos(),this);
    }

    public void paintAnimals(Graphics g, Animals animals, BufferedImage[] imgs) {
        for(Animal a: animals.getAnimals()) {
            if(a.getxInc()<0){
                paintAnimal(g,a,imgs[left]);
            }
            else {
                paintAnimal(g,a,imgs[right]);
            }
        }
    }


    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font fnt = new Font("Garamond", Font.BOLD,40);
        g2d.setFont(fnt);
        g2d.setColor(Color.black);
        g2d.drawImage(ImageLoader.mainBackground, 0, 0, this);
        AffineTransform trans = AffineTransform.getTranslateInstance
                (model.getNet().getxPos(), model.getNet().getyPos());
        trans.rotate(Math.toRadians(model.getNet().getRotation()),30,0);

        paintAnimals(g2d, model.getBlueFishList(), ImageLoader.blueFish);
        paintAnimals(g2d, model.getBlueCrabList(), ImageLoader.blueCrab);
        paintAnimals(g2d,model.getSummerFlounderList(),ImageLoader.summerFlounder);
        paintAnimals(g2d,model.getBassFishList(),ImageLoader.bassFish);
        g2d.drawImage(ImageLoader.net, trans, this);
        g2d.drawImage(ImageLoader.boat,430,70,this);
        g2d.drawString(""+model.getTime(),1050,100);
        g2d.drawString(""+model.getScore(),1050,200);
        g2d.drawString("" + (4-model.getBassFishList().number()),1150, 310);
        g2d.drawString("" + (4-model.getBlueFishList().number()),1150, 400);
        g2d.drawString("" + (3-model.getSummerFlounderList().number()),1150, 490);
        g2d.drawString("" + (3-model.getBlueCrabList().number()),1150, 580);
        g2d.drawString("0",1150, 660);

    }
}
