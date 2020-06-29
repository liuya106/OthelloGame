package ca.utoronto.utm.othello.viewcontroller;

import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
/**
 * First page appears an iron man image with three 
 * opponent choices available.
 * @author Xuwen Cai, LinFeng Zhou, Yang Liu, jiahe Xue
 *
 */
public class FirstPage {
	public Pane pane; Button x1; Button x2; Button x3;
	public FirstPage() {
		Image background = new Image("file:ironman3.jpg");
		Image button_greedy = new Image("file:greedygem.jpg");
		Image button_alpha = new Image("file:alphagem.gif");
		Image button_human = new Image("file:humangem.jpg");
		ImageView Background = new ImageView(background);
		ImageView Button_greedy = new ImageView(button_greedy);
		ImageView Button_alpha = new ImageView(button_alpha);
		ImageView Button_human = new ImageView(button_human);
		Button_greedy.setFitHeight(50);
		Button_greedy.setFitWidth(50);
		Button_alpha.setFitHeight(50);
		Button_alpha.setFitWidth(50);
		Button_human.setFitHeight(50);
		Button_human.setFitWidth(50);
		Background.setFitWidth(550);
		Background.setFitHeight(500);
		this.pane = new Pane();
		this.x1 = new Button("VS Greedy:", Button_greedy);
		this.x2 = new Button("VS Alpha", Button_alpha);
		this.x3 = new Button("VS Human", Button_human);
		x1.setStyle("-fx-background-color: black");
		x2.setStyle("-fx-background-color: black");
		x3.setStyle("-fx-background-color: black");
		pane.getChildren().addAll(Background, x1, x2, x3);
		x1.setLayoutX(400);x1.setLayoutY(150);
		x2.setLayoutX(400);x2.setLayoutY(240);
		x3.setLayoutX(400);x3.setLayoutY(330);

	}

}
