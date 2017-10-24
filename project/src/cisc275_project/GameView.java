package cisc275_project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameView extends JPanel{
    static JFrame frame = createFrame();
    static GameModel model = new GameModel();
    static BufferedImage img = createImage();
    static BufferedImage background = background();
    static BufferedImage net = createNet();
	final static int frameWidth = 1000;
    final static int frameHeight = 600;
//    final static int uperBound = 100;
//    final static int bottomBound = 600;

    public GameModel getModel() {
		return model;
	}

	public void setModel(GameModel model) {
		this.model = model;
	}
        
    
	public static JFrame createFrame() {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new GameView());
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		return frame;
    }
	
    public void paint(Graphics g) {
    	
    	 Graphics2D g2d = (Graphics2D)g;
    	 AffineTransform trans = AffineTransform.getTranslateInstance
    			 (model.getNet().getxPos(),model.getNet().getyPos());
    	 trans.rotate( Math.toRadians(model.getNet().getRotation()) );
    	 g2d.drawImage(background,0,0, Color.gray, this);
    	 g2d.drawImage(net, trans,this);
    	 
    	 paintAnimals(g2d, model.getBlueFishList());    	 
    	 
    }
	
    public void paintAnimals(Graphics g, Animals animals) {
    		for(Animal a: animals.getAnimals()) {
    			g.drawImage(img, a.getxPos(),a.getyPos(), Color.gray, this);
    		}
    }
    
    private static BufferedImage createImage(){
    		BufferedImage img;
    		try {	
    			img = ImageIO.read(new File("images/green.png"));
    			return img;
    		}
    		catch (IOException e) {
    			e.printStackTrace();
    		}
    		return null;
    }
    private static BufferedImage createNet(){
		BufferedImage img;
		try {	
			img = ImageIO.read(new File("images/red.png"));
			return img;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
}
    
    //this is bad-------------------------------------------------
    private static BufferedImage background(){
		BufferedImage img;
		try {	
			img = ImageIO.read(new File("images/background.png"));
			return img;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }
    
	public static void update() {
		frame.repaint(); 
	}
	
    public static void main(String[] args) {    
    	for(int i = 0; i < 10000; i++){
    		update();
    		try {
    			Thread.sleep(100);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }
}
