package fatalvirus.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FXmain extends Application {

	// JavaFX 응용프로그램 개발시 Application 추상클래스 상속

	public static void main(String[] args) {

		launch(args); // JavaFX 실행 진입점

	}

	@Override
	public void start(Stage pStage) throws Exception {

		// JavaFX 프로그램은 여기서부터 시작함
		// 순수 자바코드만으로 UI 및 비지니스 로직을 작성

		// 윈도우(scene) 외관(look and feel) 정의
		pStage.setWidth(640);
		pStage.setHeight(480);
		pStage.setTitle("안녕, JavaFX!!"); // 제목
		pStage.getIcons().add(new Image("/fatalvirus/icons/scale.png"));

		// GUI 구성요소 배치
		VBox root = new VBox();
		// 구성요소를 배치하기 전에 먼저 scene을 만듦
		root.setAlignment(Pos.CENTER);
		// 구성요소들을 컨테이너 정중앙에 배치

		Label mainText = new Label();
		mainText.setText("Hello, JavaFX!!");
		mainText.setFont(new Font(50));
		// 화면 중앙에 문자열을 출력하기 위해
		// GUI 구성요소 중 Label 컨트롤을 하나 만듦
		// 문자열 크기는 50px로 지정

		Button btn = new Button();
		btn.setText("확인하세요");
		btn.setOnAction(event -> {
			System.out.println("클릭함!");
		});

		// 버튼을 출력하기 위해
		// GUI 구성요소 중 Button 컨트롤을 하나 만듦
		// "확인하세요"라는 문자가 표시되고
		// 클릭했을때 콘솔에 메세지가 출력

		Button exitBtn = new Button();
		exitBtn.setText("프로그램 종료");
		btn.setOnAction(event -> {
			Platform.exit();
		});
		// "프로그램 종료"라는 버튼을 하나 만들고
		// 클릭시 프로그램이 종료되는 이벤트를 추가
		// System.exit(0); 도 가능

		root.getChildren().add(mainText);
		root.getChildren().add(btn);
		root.getChildren().add(exitBtn);
		// 생성한 GUI 구성요소를 레이아웃 컨테이너(Vbox)에 추가

		Scene scene = new Scene(root);
		// 레이아웃 컨테이너를 화면에 표시하기 위해
		// 새로운 scene을 하나 만든다

		pStage.setScene(scene);
		// 생성된 scene 객체를 현재 stage로 지정하고

		pStage.show();
		// 화면에 출력

	}

}
