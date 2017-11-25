package project.src.cisc275_project.View;

import project.src.cisc275_project.Model.GameModel;

import javax.swing.*;
import java.awt.*;

public class EndPanel extends JPanel {
    public static Rectangle startButton = new Rectangle(495,280,200,100);
    static GameModel model;

    public EndPanel(){
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.black);
        add(menuPanel);
    }

    public void setModel(GameModel model){
        this.model = model;
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font fnt = new Font("Garamond", Font.BOLD,60);
        g2d.setFont(fnt);
        g2d.drawImage(ImageLoader.background,0,0,this);
        g2d.setColor(Color.white);
        //g2d.draw(startButton);
        g2d.drawString("SCORE:" + model.getScore(),500,350);
    }

}