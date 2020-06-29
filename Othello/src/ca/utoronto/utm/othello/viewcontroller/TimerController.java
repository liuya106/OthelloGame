package ca.utoronto.utm.othello.viewcontroller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
/**
 * Time Controller 
 * 
 * @author Linfeng Zhou, Yang Liu, Xuwen Cai, Jiahe Xue
 *
 */
public class TimerController implements EventHandler<ActionEvent> {

	private int seconds;
	private int minutes;

	private TextField txt;

	public TimerController(TextField txt) {
		this.txt = txt;
	}

	/**
	 * Handle the user's event when they want to specify time
	 * @param event
	 * 
	 */
	@Override
	public void handle(ActionEvent event) {
		String s = txt.getText();
		try {
			String num1 = s.split(":")[0];
			String num2 = s.split(":")[1];
			minutes = Integer.parseInt(num1);
			seconds = Integer.parseInt(num2);
			this.txt.setText(minutes + ":" + seconds);
		} catch (Exception e) {
			this.txt.setText("minutes:seconds");
		}
		if (minutes == 0 && seconds == 0) {
			this.txt.setText("minutes:seconds");
		} else {
			if (seconds == 0) {
				minutes--;
				seconds = 60;
			}
			seconds--;
			this.txt.setText(minutes + ":" + seconds);
		}

	}
}
