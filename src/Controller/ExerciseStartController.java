package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.HealthFrame;

public class ExerciseStartController {
	private HealthFrame myFrame;
	
	public ExerciseStartController(HealthFrame myFrame) {
		this.myFrame = myFrame;
		myFrame.setExerciseStartController(this);
	}

	
}
