package fatalvirus.controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXmain4Controller {

	@FXML
	BorderPane mainPane;

	public void exitApp(ActionEvent ae) {
		Platform.exit();
	}

	public void openAbout(ActionEvent ae) throws IOException {
		String fpath = "/fatalvirus/view/FXmain4About.fxml";
		Parent root = FXMLLoader.load(getClass().getResource(fpath));

		Stage about = new Stage();
		about.setScene(new Scene(root));
		about.getIcons().add(new Image("/fatalvirus/icons/scale" + ".png"));
		about.setTitle("프로그램 정보");

		Stage main = (Stage) mainPane.getScene().getWindow();
		about.initModality(Modality.WINDOW_MODAL);
		about.initOwner(main);

		about.show();
	}

}
