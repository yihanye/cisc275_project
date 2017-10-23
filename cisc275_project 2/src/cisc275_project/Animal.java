package cisc275_project;

import java.util.Random;

public class Animal 
	{	
		String name;
		int xPos, yPos; //Position of center of the animal
		int xInc, yInc; //speed of the certain animal
		//int weith, height; //weith and height of the image of a certain animal
		//int[] position = {xPos, yPos, xInc, yInc};
		boolean caught; //check if the animal is caught
	    
	    // Constructor
	    public Animal(String name,int xPos,int yPos, int xInc, int yInc, boolean caught){
	        this.name = name;
	        this.xPos = xPos;
	        this.yPos = yPos;
	        this.xInc = xInc;
	        this.yInc = yInc;
	        this.caught = false;
	    }
	    
	    public String toString() {
	    	return name + " is on position" + "("+xPos+", "+ yPos+") with speed"+ "("+xInc+", "+ yInc+")" ;
	    }
	    
		public int getxPos() {
			return xPos;
		}

		public void setxPos(int xPos) {
			this.xPos = xPos;
		}

		public int getyPos() {
			return yPos;
		}

		public void setyPos(int yPos) {
			this.yPos = yPos;
		}

		public int getxInc() {
			return xInc;
		}

		public void setxInc(int xInc) {
			this.xInc = xInc;
		}

		public int getyInc() {
			return yInc;
		}

		public void setyInc(int yInc) {
			this.yInc = yInc;
		}

		public boolean isCaught() {
			return caught;
		}

		public void setCaught(boolean caught) {
			this.caught = caught;
		}

		//move the animal
		public void updatePosition() {
			xPos = (xPos + xInc) % GameView.frameWidth;
			yPos = (yPos + yInc) % GameView.frameHeight;
		}
		//change the direction of the animal
		
		public void updateXDirection() {
			Random rand = new Random();
			int n=rand.nextInt(100)+1;
			if(n>98) {
				xInc = xInc * -1;
			}
		}
		public void updateYDirection() {
			Random rand = new Random();
			int n=rand.nextInt(100)+1;
			if(n>98) {
				yInc = yInc * -1;
			}
		}
		
		public void update() {
			updateXDirection();
			updateYDirection();
			updatePosition();
		}
	
	    public static void main(String[] args) {
	    		Animal a1 = new Animal("fish",0,0,1,2,false);
	    		for(int i = 0; i < 1000; i++){
	    			a1.update();
	    			System.out.println(a1);
	    			try {
	    				Thread.sleep(300);
	    			} catch (InterruptedException e) {
	    				e.printStackTrace();
	    			}
	    		}
	    }
}
