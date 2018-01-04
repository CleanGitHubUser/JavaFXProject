package fatalvirus.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FXmain4 extends Application {

	@Override
	public void start(Stage pStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/fatalvirus/view/FXmain4.fxml"));

		pStage.setTitle("MVC를 이용한 JavaFX");
		pStage.getIcons().add(new Image("/fatalvirus/icons/scale" + ".png"));
		pStage.setScene(new Scene(root, 640, 480));

		pStage.setResizable(false); // 크기 조정불가

		pStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
