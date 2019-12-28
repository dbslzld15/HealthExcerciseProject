package Controller;

import View.HealthFrame;

public class PreExerciseStartController {
	private HealthFrame myFrame;

	public PreExerciseStartController(HealthFrame myFrame) {
		this.myFrame = myFrame;
		myFrame.setPreExerciseStartController(this);
	}

}
