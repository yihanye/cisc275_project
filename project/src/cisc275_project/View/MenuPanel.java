package project.src.cisc275_project.View;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    public static Rectangle startButton = new Rectangle(495,280,200,100);

    public MenuPanel(){
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.black);
        add(menuPanel);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font fnt = new Font("Garamond", Font.BOLD,60);
        g2d.setFont(fnt);
        g2d.drawImage(ImageLoader.background,0,0,this);
        g2d.setColor(Color.white);
        g2d.draw(startButton);
        g2d.drawString("START",500,350);
    }

}
