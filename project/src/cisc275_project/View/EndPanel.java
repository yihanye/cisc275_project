package project.src.cisc275_project.View;

import project.src.cisc275_project.Model.GameModel;

import javax.swing.*;
import java.awt.*;

public class EndPanel extends JPanel {
    static GameModel model;

    public EndPanel(){
        JPanel menuPanel = new JPanel();
        add(menuPanel);
    }

    public void setModel(GameModel model){
        this.model = model;
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font fnt = new Font("TimesRoman", Font.BOLD,60);
        g2d.setFont(fnt);
        g2d.drawImage(ImageLoader.endPage,0,0,this);
        g2d.setColor(new Color(201,20,62));
        g2d.drawString("" + model.getScore(),700,320);
    }

}