package project.src.cisc275_project;

import java.util.ArrayList;
import java.util.List;

public class BlueFish extends Animal {
	public BlueFish(int xPos, int yPos) {
		super("blue_fish", xPos, yPos, 4, 1, false);
	}	
	//create BlueFishList
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
