package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.HealthFrame;

public class HealthFrameController {
	private HealthFrame myFrame;

	public HealthFrameController(HealthFrame myFrame) {
		this.myFrame = myFrame;
		myFrame.setHealthFrameController(this);
	}
	
	public void healthBtnFunc() {
		myFrame.getTopPanel2().setVisible(true);
		myFrame.geteSView().setVisible(false);
	}
	public void myPageBtnFunc() {
		myFrame.getTopPanel2().setVisible(false);
		myFrame.geteSView().setVisible(false);
	}
	public void startBtnFunc() {
		myFrame.getTopPanel2().setVisible(false);
		myFrame.geteSView().setVisible(true);
	}
}
