package project.src.cisc275_project;

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
		this.net = Net.createNet();
		this.score = 0;
		this.time = 100;
	}
	
	public Animals getBlueFishList() {
		return blueFishList;
	}
	public Animals getBlueCrabList() {
		return blueCrabList;
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

	public void clicked(){
		net.stopSwing();
	}

	public void update() {
		blueFishList.update(net);
		blueCrabList.update(net);
		net.update();
	}
	
	public String toString() {
		return blueCrabList.toString();
	}

//	public static void main(String[] args) {
//		GameModel model = new GameModel();
//		for(int i = 0; i < 1000; i++){
//			model.update();
//			System.out.println(model);
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}

}
