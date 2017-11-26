package project.src.cisc275_project.Model;
/**
 @author Chu Qiao
 @author Mingkun Chen
 @author Yihan Ye
 */

import java.util.ArrayList;
import java.util.List;

/**
 * this is the class for blue fish
 */
public class BlueFish extends Animal {
	/**
	 * Constructor for blueFish
	 * @param xPos the x position of fish
	 * @param yPos the y position of fish
	 */
	public BlueFish(int xPos, int yPos) {
		super("blue_fish", xPos, yPos, 2, 1, 200,400,0,850);
	}
	//create BlueFishList
	/**
	 * Create an animal list with 3 blue fish
	 * @return Animal
	 */
	public static Animals createBFList(){
		BlueFish bf1 = new BlueFish(800,250);
		BlueFish bf2 = new BlueFish(250,220);
		BlueFish bf3 = new BlueFish(500,280);
		BlueFish bf4 = new BlueFish(600,320);
		BlueFish bf5 = new BlueFish(300,300);
		BlueFish bf6 = new BlueFish(150,240);
		BlueFish bf7 = new BlueFish(100,360);
		BlueFish bf8 = new BlueFish(50,270);


		List<Animal> bfList = new ArrayList<Animal>();
		bfList.add(bf1);
		bfList.add(bf2);
		bfList.add(bf3);
		bfList.add(bf4);
		return new Animals("BlueFish",bfList);
	}
}
