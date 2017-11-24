package project.src.cisc275_project.Model;

public class GameModel {
	private Animals blueFishList;
	private Animals blueCrabList;
	private int score;
	private int time;
	private Net net;
	private boolean quizable= true;
	public enum STATE{MENU,GAME,QUIZ}
	private STATE state;

	//Constructor
	public GameModel() {
		this.blueFishList = BlueFish.createBFList();
		this.blueCrabList = BlueCrab.createBCList();
		this.net = Net.createNet();
		this.score = 0;
		this.time = 1000;
		this.state = STATE.MENU;
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
	public void setQuizable(boolean bool){ quizable = bool; }
	public boolean getQuizable(){return quizable;}
	public int getTime() {
		return time;
	}
	public Net getNet() {
		return net;
	}
	public STATE getGameState() {
		return state;
	}
	public void setState(STATE state){
		this.state = state;
	}


	public void clicked(int x, int y){
		if(getGameState()== STATE.GAME){
			net.stopSwing();
			if(!hasCollision()){
				setQuizable(true);
			}
		}
		else if(getGameState() == STATE.MENU){
			if(x<795 && x>495 && y<380 && y>280){
				setState(STATE.GAME);
			}
		}
		else if(getGameState() == STATE.QUIZ){
			if((x>400 && x<500 && y > 450 && y<500)||(x>700 && x<800 && y > 450 && y<500)){
				switchBackToGame();
			}
		}
	}

	public void timeUpdate(){
		time--;
	}

	/**
	 * Check whether there is a collision happened for all animal list
	 * @return whether there is a collision happened
	 */

	public boolean hasCollision (){
		return blueCrabList.hasCollision() || blueFishList.hasCollision();
	}

	/**
	 * switch to quiz model
	 */
	public void switchToQuiz(){
		boolean quizornot = hasCollision() && getQuizable();
		if(quizornot==true){
			setState(STATE.QUIZ);
			setQuizable(false);
		}
	}

	/**
	 *  swich back to GAME from QUIZ
	 */
	public void switchBackToGame(){
			setQuizable(false);
			setState(STATE.GAME);
	}

	public void update() {
		if(state == STATE.GAME) {
			blueFishList.update(net);
			blueCrabList.update(net);
			net.update();
			timeUpdate();
			switchToQuiz();
		}
	}
	
	public String toString() {
		return blueCrabList.toString();
	}

	public static void main(String[] args) {
		GameModel model = new GameModel();
		for(int i = 0; i < 1000; i++){
			if(i==10){
				model.clicked(100, 100);
			}
			model.update();
			System.out.println(model.getNet());
			System.out.println(" NumberOfBlueCrab: "+model.getBlueCrabList());
			System.out.println(" NumberOfBlueFish: "+model.getBlueFishList());
			System.out.println(" One " +model.getBlueCrabList().getAnimals().get(0));
			System.out.println(" One " +model.getBlueFishList().getAnimals().get(0));
			System.out.println(" ");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
