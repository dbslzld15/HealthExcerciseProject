package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import View.ExerciseStartView;
import View.HealthFrame;
import View.PreExerciseStartView;

public class PreExerciseStartController {
	private HealthFrame myFrame;
	private ExerciseStartView eSView;

	public PreExerciseStartController(HealthFrame myFrame) {
		this.myFrame = myFrame;
		myFrame.setPreExerciseStartController(this);
		myFrame.getpESView().getStartBtn().addActionListener(new BtnActionListener());
	}


	class BtnActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == myFrame.getpESView().getStartBtn()) {
				myFrame.geteSView().setVisible(true);
				myFrame.getpESView().setVisible(false);
			}
		}

	}

}
