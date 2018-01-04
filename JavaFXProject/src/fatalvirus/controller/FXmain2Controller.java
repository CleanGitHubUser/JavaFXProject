package fatalvirus.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class FXmain2Controller {

	// 확인하세요 버튼 클릭시 이벤트 처리
	public void showCheck(ActionEvent ae) {
		System.out.println("클릭됨!!");
	}

	// 프로그램 종료 버튼 클릭시 이벤트 처리
	public void exitApp(ActionEvent ae) {
		Platform.exit();
	}

}
