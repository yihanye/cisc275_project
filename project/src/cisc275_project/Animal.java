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

		public int getyPos() {
			return yPos;
		}

		public int getxInc() {
			return xInc;
		}

		public int getyInc() {
			return yInc;
		}

		public boolean isCaught() {
			return caught;
		}

		public void setCaught(boolean caught) {
			this.caught = caught;
		}
		//change the direction of the animal
		public int randomDirection() {
			Random rand = new Random();
			int n = rand.nextInt(100)+1;
			return (n > 98) ? -1: 1;
		}
		public void updateXDirection() {
			if(xPos >= 900 || xPos < 0) {
				xInc *= -1;
			}
			else {
				xInc = xInc * randomDirection();				
			}
		}
		public void updateYDirection() {
			if(yPos >= 550 || yPos < 100) {
				yInc *= -1;
			}
			else {
				yInc = yInc * randomDirection();	
			}
		}
//		public void updateDirection(int pos, int inc,int uplimit, int bottomlimit) {
//			if(pos>=uplimit || pos < bottomlimit) {
//				inc *= -1;
//			}
//			else {
//				inc = inc * randomDirection();
//			}
//		}
		//move the animal
		public void updatePosition() {
			updateXDirection();
			//updateDirection(xPos, xInc, 900, 0);
			updateYDirection();
			xPos = (xPos + xInc) % GameView.frameWidth;
			yPos = (yPos + yInc) % GameView.frameHeight;
		}
		
		public void update() {
			updatePosition();
		}
	
	    public static void main(String[] args) {
	    		Animal a1 = new Animal("animal",0,0,1,2,false);
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
