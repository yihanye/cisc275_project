package project.src.cisc275_project;

import java.util.Random;

public class Animal 
	{	
		String name;
		double xPos, yPos; //Position of center of the animal
		double xInc, yInc; //speed of the certain animal
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
	    
		public double getxPos() {
			return xPos;
		}

		public double getyPos() {
			return yPos;
		}

		public double getxInc() {
			return xInc;
		}

		public double getyInc() {
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
		//move the animal
		public void updatePosition() {
			updateXDirection();
			updateYDirection();
			xPos = (xPos + xInc);
			yPos = (yPos + yInc);
		}

		public void update(Net n) {
			updatePosition();
			updateCollision(n);
		}
		//this is bad
		public boolean isCollision(Net n){
	    	return (n.goDown())&(Math.abs(getxPos()-n.getxPos())<50) & (Math.abs(getyPos()-n.getyPos())<50);
		}

		public void updateCollision(Net n){
			if(isCollision(n)){
				this.caught(n);
				n.updateCollision();
			}
		}

		public void caught(Net n){
			xInc = -n.getxInc();
			yInc = -n.getyInc();

		}
	
//	    public static void main(String[] args) {
//	    		Animal a1 = new Animal("animal",0,0,1,2,false);
//	    		for(int i = 0; i < 1000; i++){
//	    			a1.update();
//	    			System.out.println(a1);
//	    			try {
//	    				Thread.sleep(300);
//	    			} catch (InterruptedException e) {
//	    				e.printStackTrace();
//	    			}
//	    		}
//	    }

}
