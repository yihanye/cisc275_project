package cisc275_project;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
	private Animals blueFishList;
	private Animals blueCrabList;
	private int score;
	private int time;
	private Net net;
	//Constructor
	public GameModel() {
		this.blueFishList =BlueFish.createBFList();
		this.blueCrabList = BlueCrab.createBCList();
		this.net = new Net(500,50,0,0,0,10);
		this.score = 0;
		this.time = 100;
	}
	
	public Animals getBlueFishList() {
		return blueFishList;
	}
	public Animals getBlueCrabList() {
		return blueCrabList;
	}

	public void setBlueFishList(Animals blueFishList) {
		this.blueFishList = blueFishList;
	}

	public int getScore() {
		return score;
	}

	public int getTime() {
		return time;
	}
	
	public Net getNet() {
		return net;
	}

	public void update() {
		blueFishList.update();
		blueCrabList.update();
		net.update();
	}
	
	public String toString() {
		List<Animal> temp = (List<Animal>) blueFishList.getAnimals();
		int x1 = temp.get(0).getxPos();
		int x2 = temp.get(1).getxPos();
		int x3 = temp.get(2).getxPos();
		return x1+" "+x2+" "+x3;
	}
	public static void main(String[] args) {
		GameModel model = new GameModel();
		for(int i = 0; i < 1000; i++){
			model.update();
			System.out.println(model);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
