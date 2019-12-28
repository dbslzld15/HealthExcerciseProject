package Controller;

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
		myFrame.getmPView().setVisible(false);
	}
	public void myPageBtnFunc() {
		myFrame.getmPView().setVisible(true);
		myFrame.geteSView().setVisible(false);
		myFrame.gethLView().setVisible(false);
	}
	public void startBtnFunc() {
		myFrame.geteSView().setVisible(true);
		myFrame.gethLView().setVisible(false);
		myFrame.getmPView().setVisible(false);
	}
}
