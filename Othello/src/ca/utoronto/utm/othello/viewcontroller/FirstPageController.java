package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.PlayerOppenent;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller used by first page opponent choice.
 * @author Xuwen Cai, LinFeng Zhou, Yang Liu, jiahe Xue
 *
 */
public class FirstPageController implements EventHandler<ActionEvent> {
	private Stage stage;
	private Timeline timer;
	private FirstPage firstPage;
	private Scene scene;
	private Othello othello;
	private GameController gamecontroller;
	private OthelloView view;

	public FirstPageController(Othello othello, Stage stage, Scene s, Timeline timer, GameController gamecontroller,
			OthelloView view) {
		this.setStage(stage);
		this.timer = timer;
		this.setFirstPage(firstPage);
		this.scene = s;
		this.othello = othello;
		this.gamecontroller = gamecontroller;
		this.view = view;
	}

	/**
	 * Handle the User's event when they see the first GUI and allows the user to
	 * switch scene.
	 */
	@Override
	public void handle(ActionEvent event) {
		Button source = (Button) event.getSource();
		if (source.getText() == "VS Greedy:") {
			this.gamecontroller.opponent = new PlayerOppenent(OppenentFactory.createPlayer("Greedy", othello, 'O'));
			this.view.P2.setText("P2: Greedy");
		} else if (source.getText() == "VS Alpha") {
			this.gamecontroller.opponent = new PlayerOppenent(OppenentFactory.createPlayer("Alpha", othello, 'O'));
			this.view.P2.setText("P2: Alpha");
		} else if (source.getText() == "VS Human") {
			this.gamecontroller.opponent = new PlayerOppenent(OppenentFactory.createPlayer("Human", othello, 'O'));
		}
		stage.setScene(scene);
		timer.setCycleCount(Animation.INDEFINITE);
		timer.play();

	}
	/**
	 * @return return stage
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * set a different stage
	 * @param stage
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	/**
	 * get first page
	 * @return return FirstPage
	 */
	public FirstPage getFirstPage() {
		return firstPage;
	}

	/**
	 * set a new first page
	 * @param firstPage
	 */
	public void setFirstPage(FirstPage firstPage) {
		this.firstPage = firstPage;
	}

}
