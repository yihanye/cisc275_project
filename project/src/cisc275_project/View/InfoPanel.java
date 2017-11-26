package project.src.cisc275_project.View;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    public static Rectangle startButton = new Rectangle(910,640,250,60);

    public InfoPanel(){
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.black);
        add(menuPanel);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.drawImage(ImageLoader.infoBackground,0,0,this);
        g2d.setColor(Color.white);
        g2d.draw(startButton);
    }
}
