package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.ExerciseStartController;
import Controller.HealthFrameController;
import Controller.HealthListController;
import Controller.MyPageController;
import Controller.PreExerciseStartController;

public class HealthFrame extends JFrame {
	private ExerciseStartController eSController;
	private HealthFrameController hFController;
	private MyPageController mPController;
	private PreExerciseStartController pESController;
	private HealthListController hLController;

	private JButton myPageBtn;
	private JButton healthBtn;
	private JButton startBtn;

	private JPanel topPanel;

	private PreExerciseStartView pESView;
	private ExerciseStartView eSView;
	private HealthListView hLView;
	private MyPageView mPView;

	public static String id;
	
	private int rep = 10;
	private int set = 5;
	private int time = 60;

	public int getRep() {
		return rep;
	}

	public void setRep(int rep) {
		this.rep = rep;
	}

	public int getSet() {
		return set;
	}

	public MyPageController getmPController() {
		return mPController;
	}

	public void setmPController(MyPageController mPController) {
		this.mPController = mPController;
	}

	public void setSet(int set) {
		this.set = set;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public HealthFrame() {
		init();

	}// 생성자

	public void init() {

		topPanel = new JPanel();
		myPageBtn = new JButton(new ImageIcon("images/마이페이지.png"));
		healthBtn = new JButton(new ImageIcon("images/운동리스트.png"));
		startBtn = new JButton(new ImageIcon("images/운동시작.png"));

		myPageBtn.setPreferredSize(new Dimension(80, 40));
		healthBtn.setPreferredSize(new Dimension(80, 40));
		startBtn.setPreferredSize(new Dimension(80, 40));

		startBtn.addActionListener(new BtnListener());
		healthBtn.addActionListener(new BtnListener());
		myPageBtn.addActionListener(new BtnListener());

		setTitle("운동리스트");

		this.setLayout(null);
		topPanel.setLayout(new FlowLayout());
		topPanel.add(myPageBtn);
		topPanel.add(healthBtn);
		topPanel.add(startBtn);
		topPanel.setBackground(new Color(96, 181, 220));
		topPanel.setBounds(0, 0, 1100, 50);
		this.add(topPanel, BorderLayout.NORTH);

		mPView = new MyPageView();
		mPView.setBounds(0, 50, 1100, 700);
		this.add(mPView);

		eSView = new ExerciseStartView();
		eSView.setBounds(0, 50, 1100, 700);
		this.add(eSView);

		hLView = new HealthListView();
		hLView.setBounds(0, 50, 1100, 700);
		this.add(hLView);

		pESView = new PreExerciseStartView();
		pESView.setBounds(0, 50, 1100, 700);
		this.add(pESView);

		setVisible(true);
		setSize(1100, 700);

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

	public void setPreExerciseStartController(PreExerciseStartController controller) {
		this.pESController = controller;
	}

	public void setMyPageController(MyPageController controller) {
		this.mPController = controller;
	}

	public void setHealthListController(HealthListController controller) {
		this.hLController = controller;
	}

	public MyPageView getmPView() {
		return mPView;
	}

	public void setmPView(MyPageView mPView) {
		this.mPView = mPView;
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

	public PreExerciseStartView getpESView() {
		return pESView;
	}

	public void setpESView(PreExerciseStartView pESView) {
		this.pESView = pESView;
	}



	public ExerciseStartController geteSController() {
		return eSController;
	}

	public void seteSController(ExerciseStartController eSController) {
		this.eSController = eSController;
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