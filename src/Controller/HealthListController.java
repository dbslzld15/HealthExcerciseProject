package Controller;

import java.awt.event.*;
import java.util.*;

import View.HealthFrame;

public class HealthListController {

	private HealthFrame myFrame;
	private ActionListener FirstBoxActionListener;
	private ActionListener SecondBoxActionListener;
	private ActionListener InButtonActionListener;
	private ActionListener ExButtonActionListener;

	public HealthListController(HealthFrame myFrame) {
		this.myFrame = myFrame;
		myFrame.setHealthListController(this);

	}

	public void addHeathListListener() {
		myFrame.gethLView().getFirstBox().addActionListener(FirstBoxActionListener);
		myFrame.gethLView().getSecondBox().addActionListener(null);
		myFrame.gethLView().getInButton().addActionListener(null);
		for (int i = 0; i < 9; i++) {
			myFrame.gethLView().getExButton()[i].addActionListener(null);
		}

	}

	class FirstBoxActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class SecondBoxActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class InButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
