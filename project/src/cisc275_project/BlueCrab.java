package cisc275_project;

import java.util.ArrayList;
import java.util.List;

public class BlueCrab extends Animal{

	public BlueCrab(int xPos, int yPos) {
		super("BlueCrab", xPos, yPos, 2, 1, false);
	}
	
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
