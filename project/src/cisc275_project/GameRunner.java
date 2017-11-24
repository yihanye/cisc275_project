package project.src.cisc275_project;

import project.src.cisc275_project.Model.GameModel;
import project.src.cisc275_project.View.GameView;

public class GameRunner {
	public static void main(String[] args) {
		GameModel model = new GameModel();
		GameView view = new GameView();
		GameController controller = new GameController(view,model);
		controller.start();
	}
}
