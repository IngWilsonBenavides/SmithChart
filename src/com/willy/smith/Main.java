package com.willy.smith;

import com.willy.smith.chart.SmithChart;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	private static final double width = 100.0;
	private static final double height = width * 0.618;
	private static final double scale = 8.0;
	private SmithChart smith = new SmithChart();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		Pane root = new Pane();
		root.setLayoutX(0.0D);
		root.setLayoutY(0.0D);
		primaryStage.setScene(createScene(root, width * scale, height * scale));
		primaryStage.show();
	}

	private Scene createScene(Pane root, double cWidth, double cHeight) {
		this.smith.setLayoutY(0.0D);
		this.smith.setLayoutX(-100.0D);
		root.getChildren().addAll(new Node[] { this.smith });
		Scene scene = new Scene(root, cWidth, cHeight);
		return scene;
	}

	public static double getWidth() {
		return width * scale;
	}

	public static double getHeight() {
		return height * scale;
	}
}
