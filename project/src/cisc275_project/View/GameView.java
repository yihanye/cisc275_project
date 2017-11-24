package project.src.cisc275_project.View;

import project.src.cisc275_project.Model.GameModel;

import java.awt.event.MouseAdapter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameView extends JFrame{
	static GameModel model = new GameModel();
	static MenuPanel menuPane = new MenuPanel();
	static GamePanel gamePanel = new GamePanel();
	static QuizPanel quizPanel = new QuizPanel();

	final static int frameWidth = 1200;
    final static int frameHeight = 700;

	public void setModel(GameModel model) {
		this.model = model;
		gamePanel.setModel(model);
	}

	public GameView(){
		setPreferredSize(new Dimension(frameWidth,frameHeight));
		setBackground(Color.black);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
		setResizable(false);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				int x = me.getX();
				int y = me.getY();
				model.clicked(x,y);
			}
		});
	}



    public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(model.getGameState() == GameModel.STATE.MENU){
			menuPane.paint(g2d);
		}
		else if(model.getGameState() == GameModel.STATE.GAME){
			gamePanel.paint(g2d);
		}
		else if(model.getGameState() == GameModel.STATE.QUIZ){
			quizPanel.paint(g2d);
		}
	}


	public  void update() {
		this.repaint();
	}

//    public static void main(String[] args) {
//		for(int i = 0; i < 10000; i++){
//				update();
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//    }

}
