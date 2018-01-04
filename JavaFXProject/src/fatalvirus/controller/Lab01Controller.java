package fatalvirus.controller;

import java.net.URL;
import java.util.ResourceBundle;

import fatalvirus.model.SungJukModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Lab01Controller implements Initializable {
	// 각종 컨트롤이 화면이 표시되기 전에
	// 미리 수행되어야 할 작업이 있다면
	// Initializable 인터페이스를 구현하고
	// initalize 라는 메서드를 재정의하면 된다.

	// 뷰에 정의된 컨트롤의 멤버변수 선언

	@FXML
	private TextField name;
	@FXML
	private TextField kor;
	@FXML
	private TextField eng;
	@FXML
	private TextField mat;

	// 테이블뷰와 테이블컬럼관련 멤버변수 선언
	@FXML
	private TableView<SungJukModel> sjtable;
	@FXML
	private TableColumn<SungJukModel, String> sjname;
	@FXML
	private TableColumn<SungJukModel, String> sjkor;
	@FXML
	private TableColumn<SungJukModel, String> sjeng;
	@FXML
	private TableColumn<SungJukModel, String> sjmat;
	@FXML
	private TableColumn<SungJukModel, String> sjtot;
	@FXML
	private TableColumn<SungJukModel, String> sjavg;
	@FXML
	private TableColumn<SungJukModel, String> sjgrd;

	// 컨트롤러에서 기타 목적으로 선언하는 변수
	private ObservableList<SungJukModel> sjlist = null;
	// Observer 패턴이 적용된 List 클래스
	// Observer 패턴 : 한 객체의 상태가 바뀌면
	// 그 객체에 의존하는 다른 객체들에게 그 정보를 알려주게 작성하는 방식
	// 하나의 주체를 여러 개체가 구독하는 1:다 관계

	private static int sjcnt = 0;
	// 전체 학생 수 저장용 변수

	// "추가"버튼클릭시 이벤트 처리 메서드
	public void addSungJuk(ActionEvent ae) {
		try {
			SungJukModel sj = new SungJukModel(name.getText(), kor.getText(), eng.getText(), mat.getText());
			sjlist.add(sj);

			name.setText("");
			kor.setText("");
			eng.setText("");
			mat.setText("");
		} catch (Exception ex) {
			showErrorDialog(1);
		}
	}

	// "수정"버튼클릭시 이벤트 처리 메서드
	public void modifySungJuk(ActionEvent ae) {
		try {
			int num = sjtable.getSelectionModel().getSelectedIndex();
			// 수정할 행의 순번index를 알아냄
			SungJukModel sj = new SungJukModel(name.getText(), kor.getText(), eng.getText(), mat.getText());
			// 수정된 값으로 성적 객체를 생성함
			sjlist.set(num, sj);
			// 수정된 객체를 지정한 위치에 저장
			sjtable.getSelectionModel().select(num);
			// 특정행을 선택상태로 만듦
		} catch (Exception ex) {
			showErrorDialog(2);
		}
	}

	// "삭제"버튼클릭시 이벤트 처리 메서드
	public void removeSungJuk(ActionEvent ae) {
		try {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("삭제 확인");
			confirm.setHeaderText("정말로 삭제하시겠습니까?");
			confirm.setContentText("삭제된 데이터는 복구할 수 없습니다.");
			confirm.showAndWait();
			int num = sjtable.getSelectionModel().getSelectedIndex();
			sjlist.remove(num);
		} catch (Exception ex) {
			showErrorDialog(3);
		}
	}

	// 마우스 버튼 더블클릭시 이벤트 처리 메서드
	public void clickSungJuk(MouseEvent me) {
		name.setText("");
		kor.setText("");
		eng.setText("");
		mat.setText("");
		// 마우스 버튼을 더블클릭하면
		if (me.getClickCount() == 2) {
			// 현재 선택한 행의 데이터를 성적모델 객체로 읽어옴
			SungJukModel sj = (SungJukModel) sjtable.getSelectionModel().getSelectedItem();
			// 선택한 모델 객체로 부터 성적데이터를 추출해서
			// 텍스트필드에 저장
			name.setText(sj.getName());
			kor.setText(sj.getKor());
			eng.setText(sj.getEng());
			mat.setText(sj.getMat());
		}
	}

	private void showErrorDialog(int etype) {
		String error = "";
		String errorText = "";
		switch (etype) {
		case 1:
			error = "성적추가오류!";
			errorText = "성적추가시 오류 발생 - 입력데이터 확인!!";
			break;
		case 2:
			error = "성적수정오류!";
			errorText = "성적수정시 오류 발생 - 입력데이터 확인!!";
			break;
		case 3:
			error = "성적삭제오류!";
			errorText = "성적삭제시 오류 발생 - 입력데이터 확인!!";
			break;
		}
		Alert dialog = new Alert(Alert.AlertType.ERROR);
		dialog.setTitle(error);
		dialog.setHeaderText(error);
		dialog.setContentText(errorText);
		dialog.showAndWait();
	}

	// Lab01.fxml이 읽혀지고 load 한후
	// 각종 UI 요소에 대한 초기화 작업을 수행
	// 또는 기타 초기화 작업(DB/파일 연결, 종료 등) 수행
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// javafx 빈즈규약에 따라 작성된 SungJuk모델과
		// TableView의 각 컬럼과 바인딩 시키는 작업 필요
		// 즉, 해당 컬럼에 표시될 데이터와 종류를 결정
		sjname.setCellValueFactory(new PropertyValueFactory<SungJukModel, String>("name"));
		sjkor.setCellValueFactory(new PropertyValueFactory<SungJukModel, String>("kor"));
		sjeng.setCellValueFactory(new PropertyValueFactory<SungJukModel, String>("eng"));
		sjmat.setCellValueFactory(new PropertyValueFactory<SungJukModel, String>("mat"));
		sjtot.setCellValueFactory(new PropertyValueFactory<SungJukModel, String>("tot"));
		sjavg.setCellValueFactory(new PropertyValueFactory<SungJukModel, String>("avg"));
		sjgrd.setCellValueFactory(new PropertyValueFactory<SungJukModel, String>("grd"));

		sjlist = FXCollections.observableArrayList();
		// JavaFX에서 지원하는 collection 중
		// 옵져버패턴이 적용된 ArrayList 객체 생성

		// observableArrayList에 성적데이터 추가
		SungJukModel sj = new SungJukModel("혜교", 99 + "", 98 + "", 99 + "");
		sjlist.add(sj);
		sj = new SungJukModel("지현", 45 + "", 56 + "", 98 + "");
		sjlist.add(sj);
		sj = new SungJukModel("수지", 78 + "", 23 + "", 65 + "");
		sjlist.add(sj);

		// 테이블뷰에 생성된 성적데이터 객체를 지정
		sjtable.setItems(sjlist);

		sjcnt = sjlist.size();

		// 시스템 오동작으로 인한 오류 처리 대화상자

	};
}
