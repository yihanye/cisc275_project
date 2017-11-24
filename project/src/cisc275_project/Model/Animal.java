package project.src.cisc275_project.Model;
/**
@author Chu Qiao
@author Mingkun Chen
@author Yihan Ye
*/

import java.util.Random;

/**
 * Represnt an animal in the game
 */
public class Animal 
	{
		String name;
		double xPos, yPos;
		double xInc, yInc;
		boolean caught;

		/**
		 * Class constructor for animal
		 * @param name the name of the animal
		 * @param xPos the x position of the animal
		 * @param yPos the y position of the animal
		 * @param xInc the x incremnet of the animal
		 * @param yInc the y increment of the animal
		 * @param caught the caught status of the animal
		 */
	    public Animal(String name,int xPos,int yPos, int xInc, int yInc, boolean caught){
	        this.name = name;
	        this.xPos = xPos;
	        this.yPos = yPos;
	        this.xInc = xInc;
	        this.yInc = yInc;
	        this.caught = false;
	    }

		/**
		 * the description of an animal
		 * @return the string of animal constructor
		 */
		public String toString() {
	    	return name + " is on position" + "("+xPos+", "+ yPos+") with speed"+ "("+xInc+", "+ yInc+")" ;
	    }

		/**
		 * 	get the x position of the animal
		 * @return this animal's x position
		 */
		public double getxPos() {
			return xPos;
		}

		/**
		 * get the y position of the animal
		 * @return this animal's y position
		 */
		public double getyPos() {
			return yPos;
		}

		public boolean getCaught(){ return caught;}
		/**
		 * generate the random direction
		 * animal will change direction randomly
		 * @return this animal's updated direction
		 */
		public int randomDirection() {
			Random rand = new Random();
			int n = rand.nextInt(100)+1;
			return (n > 98) ? -1: 1;
		}

		/**
		 * update x direction
		 * if the animal at edge, the direction will turn back
		 * otherwise the aniaml direction will change randomly
		 */

		public void updateXDirection(Net n) {
			if(this.caught == false){
				if(xPos >= 900 || xPos < 0) {
					xInc *= -1;
				}
				else {
					xInc = xInc * randomDirection();
				}
			}
			else{
				xInc = -n.getxInc();
			}
		}

		/**
		 * update y direction
		 * if the animal at edge, the direction will turn back
		 * otherwise this animal's direction will change randomly
		 */
		public void updateYDirection(Net n) {
			if(this.caught == false){

				if(yPos >= 550 || yPos < 100) {
					yInc *= -1;
				}
				else {
					yInc = yInc * randomDirection();
				}
			}
			else{
				yInc = -n.getyInc();
			}
		}

		/**
		 *update animals's position based on the current x/y direction
		 *
		 */
		public void updatePosition(Net n) {
			updateXDirection(n);
			updateYDirection(n);
			xPos = xPos + xInc;
			yPos = yPos + yInc;
		}

		/**
		 * determine whether this animal has to touched net
		 * @param n the net that in the game
		 * @return whether this animal has been caught by the net
		 */

		public boolean isCollision(Net n){
	    	return (n.goDown()) & (Math.abs(getxPos()-n.getxPos())<50) & (Math.abs(getyPos()-n.getyPos())<50) & (!n.getCaught());
		}


		/**
		 * if it has been determined the animal has touched the net
		 * it will change the status of net and this animal
		 * @param n the net in the game
		 */
		public void updateCollision(Net n){
			if(isCollision(n)){
				this.caught = true;
				n.updateCollision();
			}
		}

		/**
		 * if the animal is caught by the net and move at the top of the screen should be removed
		 * @return whether the fish should be deleted
		 */
		public boolean delete(){
			return this.caught && this.getyPos()<=50;
		}
		/**update the status of animal based on the interaction with net
		 * @param n the net that in the game
		 */
		public void update(Net n) {
			updatePosition(n);
			updateCollision(n);

		}
//
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
