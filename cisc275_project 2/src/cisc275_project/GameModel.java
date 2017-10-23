package cisc275_project;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
	private Animals blueFishList;
	private int score;
	private int time;
	//Constructor
	public GameModel() {
		this.blueFishList = createBFList();
		this.score = 0;
		this.time = 100;
	}
	
	public Animals getBlueFishList() {
		return blueFishList;
	}

	public void setBlueFishList(Animals blueFishList) {
		this.blueFishList = blueFishList;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
	//create BlueFishList
	public Animals createBFList(){
		BlueFish bf1 = new BlueFish(800,100);
		BlueFish bf2 = new BlueFish(200,200);
		BlueFish bf3 = new BlueFish(500,300);

		List<Animal> bfList = new ArrayList<Animal>();
		bfList.add(bf1);
		bfList.add(bf2);
		bfList.add(bf3);
		Animals reuslt = new Animals("BlueFish",bfList);
		return reuslt;
	}

	public void update() {
		blueFishList.update();
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
