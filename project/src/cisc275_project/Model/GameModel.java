package project.src.cisc275_project.Model;

public class GameModel {
	private Animals blueFishList;
	private Animals blueCrabList;
	private Animals summerFlounderList;
	private Animals bassFishList;
	private int score;
	private int time;
	private int quizCorrect;
	private Net net;
	private QuizList quiz;
	private boolean quizable= true;
	public enum STATE{MENU,ASKHELP,INFO,GAME,QUIZ,EXPLAN,END}
	private STATE state;

	//Constructor
	public GameModel() {
		this.blueFishList = BlueFish.createBFList();
		this.blueCrabList = BlueCrab.createBCList();
		this.summerFlounderList = SummerFlounder.createSFList();
		this.bassFishList = BassFish.createBFList();
		this.net = Net.createNet();
		this.quiz = QuizList.createQuizList();
		this.quizCorrect = 0;
		this.score = 0;
		this.time = 200;
		this.state = STATE.MENU;
	}
	
	public Animals getBlueFishList() {
		return blueFishList;
	}
	public Animals getBlueCrabList() {
		return blueCrabList;
	}
	public Animals getSummerFlounderList() {
		return summerFlounderList;
	}

	public Animals getBassFishList() {
		return bassFishList;
	}

	public int getScore() {
		return score;
	}
	public QuizList getQuiz() { return quiz; }
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
			boolean startButton =x<705 && x>495 && y<425 && y>355;
				if(startButton){
				setState(STATE.ASKHELP);
			}
		}
		else if(getGameState() == STATE.ASKHELP){
			boolean ofCourseButton = x<600 && x>420 && y<550 && y>500;
			if(ofCourseButton){
				setState(STATE.INFO);
			}
		}
		else if(getGameState() == STATE.INFO){
			boolean button = x<1160 && x>910 && y<700 && y>640;
			if(button){
				setState(STATE.GAME);
			}
		}
		else if(getGameState() == STATE.QUIZ){
			boolean option1 = (x>370 && x<480 && y > 410 && y<470);
			boolean option2 = (x>650 && x<760 && y > 410 && y<470);
			if(getQuiz().getCurrentQuiz().checkAnswer(option1,option2)){
				getQuiz().getCurrentQuiz().setCorrectornot(true);
				quizCorrect++;
			}
			if(option1||option2){
				setState(STATE.EXPLAN);
			}
		}
		else if(getGameState() == STATE.EXPLAN){
			if(x<630 && x>470 && y<470 && y>410){
				switchBackToGame();
			}
		}
	}

	public void timeUpdate(){
		time--;
	}

	public void scoreUpdate(){
	   score = (4 - getBassFishList().getAnimals().size())*10+
			   (4 - getBlueFishList().getAnimals().size())*10+
			   (3 - getSummerFlounderList().getAnimals().size())*30+
			   (3 - getBlueCrabList().getAnimals().size())*50+
			   quizCorrect*100;
    }

	/**
	 * Check whether there is a collision happened for all animal list
	 * @return whether there is a collision happened
	 */

	public boolean hasCollision (){
		return blueCrabList.hasCollision() || blueFishList.hasCollision()||
				summerFlounderList.hasCollision()||bassFishList.hasCollision();
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
			quiz.nextQuiz();
			setState(STATE.GAME);
	}

	public void switchToEnd(){
		if(time == 0){
			setState(STATE.END);
		}
	}
	public void stateUpdate(){
		switchToQuiz();
		switchToEnd();
	}

	public void update() {
		if(state == STATE.GAME) {
			blueFishList.update(net);
			blueCrabList.update(net);
			summerFlounderList.update(net);
			bassFishList.update(net);
			net.update();
			timeUpdate();
			scoreUpdate();
			stateUpdate();
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
