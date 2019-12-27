package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.ExerciseStartController;
import Controller.HealthFrameController;

public class HealthFrame extends JFrame {
	private ExerciseStartController eSController;
	private HealthFrameController hFController;
	private JButton myPageBtn;
	private JButton healthBtn;
	private JButton startBtn;

	private JPanel topPanel;
	
	private ExerciseStartView eSView;
	private HealthListView hLView;
	
	

	public HealthFrame() {
		init();

	}// 생성자

	public void init() {

		topPanel = new JPanel();
		myPageBtn = new JButton("마이 페이지");
		healthBtn = new JButton("운동 리스트");
		startBtn = new JButton("운동 시작");

		startBtn.addActionListener(new BtnListener());
		healthBtn.addActionListener(new BtnListener());
		myPageBtn.addActionListener(new BtnListener());

		setTitle("운동리스트");

		this.setLayout(null);
		topPanel.setLayout(new FlowLayout());
		topPanel.add(myPageBtn);
		topPanel.add(healthBtn);
		topPanel.add(startBtn);
		topPanel.setBounds(0, 0, 700, 40);
		this.add(topPanel, BorderLayout.NORTH);
		
		eSView = new ExerciseStartView();
		this.add(eSView, BorderLayout.SOUTH);

		
		hLView = new HealthListView();
		hLView.setBounds(0,40, 700, 400);
		
		this.add(hLView);

		
		setVisible(true);
		setSize(700, 500);

		

	}

	public HealthListView gethLView() {
		return hLView;
	}

	public void sethLView(HealthListView hLView) {
		this.hLView = hLView;
	}

	public void setHealthFrameController(HealthFrameController controller) {
		this.hFController = controller;
	}

	public void setExerciseStartController(ExerciseStartController controller) {
		this.eSController = controller;
	}

	public JButton getMyPageBtn() {
		return myPageBtn;
	}

	public void setMyPageBtn(JButton myPageBtn) {
		this.myPageBtn = myPageBtn;
	}

	public JButton getHealthBtn() {
		return healthBtn;
	}

	public void setHealthBtn(JButton healthBtn) {
		this.healthBtn = healthBtn;
	}

	public JButton getStartBtn() {
		return startBtn;
	}

	public void setStartBtn(JButton startBtn) {
		this.startBtn = startBtn;
	}

	public JPanel getTopPanel() {
		return topPanel;
	}

	public void setTopPanel(JPanel topPanel) {
		this.topPanel = topPanel;
	}

	
	public ExerciseStartView geteSView() {
		return eSView;
	}

	public void seteSView(ExerciseStartView eSView) {
		this.eSView = eSView;
	}

	public class BtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == startBtn) {
				hFController.startBtnFunc();
			}
			if (e.getSource() == healthBtn) {
				hFController.healthBtnFunc();
			}
			if (e.getSource() == myPageBtn) {
				hFController.myPageBtnFunc();
			}
		}

	}

}
