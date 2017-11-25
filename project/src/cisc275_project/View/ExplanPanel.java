package project.src.cisc275_project.View;

import project.src.cisc275_project.Model.GameModel;

import javax.swing.*;
import java.awt.*;

public class ExplanPanel extends JPanel{
    static GameModel model;
    public static Rectangle gotIt = new Rectangle(550,400,100,50);


    public ExplanPanel(){
        JPanel quizPanel = new JPanel();
        quizPanel.setBackground(null);
        add(quizPanel);
    }

    public void setModel(GameModel model){
        this.model = model;
    }

    private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font fnt = new Font("TimesRoman", Font.BOLD,20);
        g2d.setFont(fnt);
        g2d.drawImage(ImageLoader.explanBackground,350,160,this);
        g2d.setColor(Color.BLACK);
        drawString(g2d,model.getQuiz().getCurrentQuiz().getExplanation(),500,300);
        g2d.drawString(""+model.getQuiz().getCurrentQuiz().getResult(),500,200);
        g2d.drawString("Got It",560,430);
        g2d.draw(gotIt);
    }
}

