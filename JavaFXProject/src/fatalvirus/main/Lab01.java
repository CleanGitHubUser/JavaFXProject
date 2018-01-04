package fatalvirus.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Lab01 extends Application {

	@Override
	public void start(Stage pStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/fatalvirus/view/Lab01.fxml"));

		pStage.setTitle("성적처리프로그램 v1");
		pStage.getIcons().add(new Image("/fatalvirus/icons/grades.png"));
		pStage.setScene(new Scene(root));

		pStage.setResizable(false); // 크기 조정불가

		pStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
