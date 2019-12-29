package Controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JLabel;

import Controller.PreExerciseStartController.BtnActionListener;
import View.HealthFrame;

public class ExerciseStartController {
	private HealthFrame myFrame;
	private TimerThread timerThread;
	public static int y = 1;
	public boolean stop = true;
	public boolean work = false;

	public ExerciseStartController(HealthFrame myFrame) {
		this.myFrame = myFrame;
		myFrame.setExerciseStartController(this);
		myFrame.geteSView().getStartTimerBtn().addActionListener(new BtnActionListener());
		myFrame.geteSView().getStopTimerBtn().addActionListener(new BtnActionListener());

	}

	class BtnActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == myFrame.geteSView().getStartTimerBtn()) {
				if (stop == true) {
					work = true;
					stop = false;
					timerThread = new TimerThread(myFrame.geteSView().getExerciseTimeNumLb());
					timerThread.start();
				}

				else {
					work = true;
				}
			}
			if (e.getSource() == myFrame.geteSView().getStopTimerBtn()) {
				System.out.println("tlqkf");
				work = false;
			}
		}

	}

	class TimerThread extends Thread {
		JLabel timerLabel = null;

		public TimerThread(JLabel timerLabel) {
			this.timerLabel = timerLabel;

		}

		public void run() {
			while (!stop) {
				if (work) {
					timerLabel.setText("" + y);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					y++;
				} else {
					Thread.yield();
				}
			}

		}
	}
}
