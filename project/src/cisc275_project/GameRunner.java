package cisc275_project;

public class GameRunner {
	public static void main(String[] args) {
		GameModel model = new GameModel();
		GameView view = new GameView();
		GameController controller = new GameController(view,model);
		controller.start();
	}
}
