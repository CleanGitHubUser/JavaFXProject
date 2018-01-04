package fatalvirus.model;

import javafx.beans.property.SimpleStringProperty;

public class SungJukModel {

	// JavaFX의 뷰컨트롤에 바인딩하기 위해
	// JavaFX beans 규약에 따라 모델 클래스 작성

	private SimpleStringProperty name;
	private SimpleStringProperty kor;
	private SimpleStringProperty eng;
	private SimpleStringProperty mat;
	private SimpleStringProperty tot;
	private SimpleStringProperty avg;
	private SimpleStringProperty grd;

	// 매개변수를 이용한 생성자
	public SungJukModel(String name, String kor, String eng, String mat) {
		this.name = new SimpleStringProperty(name);
		this.kor = new SimpleStringProperty(kor);
		this.eng = new SimpleStringProperty(eng);
		this.mat = new SimpleStringProperty(mat);
		this.tot = new SimpleStringProperty("");
		this.avg = new SimpleStringProperty("");
		this.grd = new SimpleStringProperty("");

		getProcessSungJuk();
	}

	private void getProcessSungJuk() {
		int tot = Integer.parseInt(getKor()) + Integer.parseInt(getEng()) + Integer.parseInt(getMat());
		double avg = (double) tot / 3;
		String grd = "가";
		switch ((int) avg / 10) {
		case 10:
		case 9:
			grd = "수";
			break;
		case 8:
			grd = "우";
			break;
		case 7:
			grd = "미";
			break;
		case 6:
			grd = "양";
			break;
		}

		setTot(String.valueOf(tot));
		setAvg(String.format("%.1f", avg));
		setGrd(grd);
	}

	// setter/getter
	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getKor() {
		return kor.get();
	}

	public void setKor(String kor) {
		this.kor.set(kor);
	}

	public String getEng() {
		return eng.get();
	}

	public void setEng(String eng) {
		this.eng.set(eng);
	}

	public String getMat() {
		return mat.get();
	}

	public void setMat(String mat) {
		this.mat.set(mat);
	}

	public String getTot() {
		return tot.get();
	}

	public void setTot(String tot) {
		this.tot.set(tot);
	}

	public String getAvg() {
		return avg.get();
	}

	public void setAvg(String avg) {
		this.avg.set(avg);
	}

	public String getGrd() {
		return grd.get();
	}

	public void setGrd(String grd) {
		this.grd.set(grd);
	}

}
