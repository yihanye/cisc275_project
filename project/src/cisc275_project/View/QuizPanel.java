package project.src.cisc275_project.View;

import project.src.cisc275_project.Model.GameModel;

import javax.swing.*;
import java.awt.*;

public class QuizPanel extends JPanel{
    static GameModel model;
    public static Rectangle question = new Rectangle(300,150,600,400);
    public static Rectangle option1 = new Rectangle(400,450,100,50);
    public static Rectangle option2 = new Rectangle(700,450,100,50);

    public QuizPanel(){
        JPanel quizPanel = new JPanel();
        quizPanel.setBackground(Color.black);
        add(quizPanel);
    }

    public void setModel(GameModel model){
        this.model = model;
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
        g2d.drawString(model.getQuiz().getCurrentQuiz().getQuestion(),350,200);
        g2d.drawString(model.getQuiz().getCurrentQuiz().getOption1(),400,480);
        g2d.drawString(model.getQuiz().getCurrentQuiz().getOption2(),700,480);

    }
}
