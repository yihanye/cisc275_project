package project.src.cisc275_project.View;

import javax.swing.*;
import java.awt.*;

public class QuizPanel extends JPanel{

    public static Rectangle question = new Rectangle(300,150,600,400);
    public static Rectangle option1 = new Rectangle(400,450,100,50);
    public static Rectangle option2 = new Rectangle(700,450,100,50);

    public QuizPanel(){
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.black);
        add(menuPanel);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font fnt = new Font("Garamond", Font.BOLD,20);
        g2d.setFont(fnt);
        g2d.drawImage(ImageLoader.quizBackground,200,100,this);
        g2d.setColor(Color.BLACK);
        g2d.draw(question);
        g2d.draw(option1);
        g2d.draw(option2);
        g2d.drawString("QUESTION: ",350,200);
        g2d.drawString("OPTION1",400,480);
        g2d.drawString("OPTION2",700,480);

    }
}
