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
		super("blue_fish", xPos, yPos, 4, 1, false);
	}
	//create BlueFishList
	/**
	 * Create an animal list with 3 blue fish
	 * @return Animal
	 */
	public static Animals createBFList(){
		BlueFish bf1 = new BlueFish(800,100);
		BlueFish bf2 = new BlueFish(200,200);
		BlueFish bf3 = new BlueFish(500,300);

		List<Animal> bfList = new ArrayList<Animal>();
		bfList.add(bf1);
		bfList.add(bf2);
		bfList.add(bf3);
		return new Animals("BlueFish",bfList);
	}
}
