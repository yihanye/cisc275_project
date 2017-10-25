package project.src.cisc275_project;

import java.awt.event.MouseAdapter;

public class GameController {
	GameView view;
	GameModel model;

	public GameController(GameView view, GameModel model) {
		this.view = view;
		this.model = model;
	}

	
	public void start() {	
		view.setModel(model);
	    	for(int i = 0; i < 10000; i++){
	    		model.update();
	    		view.update();
	    		try {
	    			Thread.sleep(100);
	    		} catch (InterruptedException e) {
	    			e.printStackTrace();
	    		}
	    	}
    	}

}
