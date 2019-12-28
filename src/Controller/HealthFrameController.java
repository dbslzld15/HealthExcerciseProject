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
		myFrame.gethLView().setVisible(true);
		myFrame.geteSView().setVisible(false);
		
	}
	public void myPageBtnFunc() {
		
		myFrame.geteSView().setVisible(false);
		myFrame.gethLView().setVisible(false);
	}
	public void startBtnFunc() {
	
		myFrame.geteSView().setVisible(true);
		myFrame.gethLView().setVisible(false);
	}
}
