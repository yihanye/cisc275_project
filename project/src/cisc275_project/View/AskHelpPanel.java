package project.src.cisc275_project.View;

import project.src.cisc275_project.Model.GameModel;

import javax.swing.*;
import java.awt.*;

public class AskHelpPanel extends JPanel {

    public AskHelpPanel(){
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.black);
        add(menuPanel);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(ImageLoader.askBackground,0,0,this);
        g2d.setColor(Color.RED);
    }
}