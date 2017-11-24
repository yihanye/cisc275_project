package project.src.cisc275_project.Model;
/**
 @author Chu Qiao
 @author Mingkun Chen
 @author Yihan Ye
 */

import java.util.ArrayList;
import java.util.List;

/**
 * this is the class for bluecrab
 */
public class BlueCrab extends Animal {
	/**
	 * Constructor for blueCrab
	 * @param xPos the x position of crab
	 * @param yPos the y position of crab
	 */
	public BlueCrab(int xPos, int yPos) {
		super("BlueCrab", xPos, yPos, 2, 1, false);
	}

	/**
	 * Create an animal list with 3 crabs
	 * @return Animal
	 */
	public static Animals createBCList() {
		BlueCrab bc1 = new BlueCrab(300, 300);
		BlueCrab bc2 = new BlueCrab(200, 400);
		BlueCrab bc3 = new BlueCrab(100, 500);

		List<Animal> bcList = new ArrayList<Animal>();
		bcList.add(bc1);
		bcList.add(bc2);
		bcList.add(bc3);
		return new Animals("BlueCrab",bcList);
	}
}