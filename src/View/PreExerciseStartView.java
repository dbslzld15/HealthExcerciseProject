package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.PreExerciseStartController;

public class PreExerciseStartView extends JPanel {

	private PreExerciseStartController pESController;

	private JPanel exerciseTimePanel;
	private JPanel setCntPanel;
	private JPanel repCntPanel;

	private JLabel exerciseTimeLb;
	private JLabel setCntLb;
	private JLabel repCntLb;

	private JButton exerciseTimeBtn[];
	private JButton setCntBtn[];
	private JButton repCntBtn[];

	private JButton startBtn;

	public PreExerciseStartView() {
		init();
	}

	public void init() {
		this.setLayout(null);

		exerciseTimePanel = new JPanel();
		exerciseTimePanel.setLayout(null);
		exerciseTimePanel.setBounds(90, 40, 500, 40);

		setCntPanel = new JPanel();
		setCntPanel.setLayout(null);
		setCntPanel.setBounds(90, 90, 500, 40);

		repCntPanel = new JPanel();
		repCntPanel.setLayout(null);
		repCntPanel.setBounds(90, 150, 500, 40);

		exerciseTimeLb = new JLabel("운동시간");
		exerciseTimeLb.setBounds(0, 0, 80, 40);
		exerciseTimePanel.add(exerciseTimeLb);

		setCntLb = new JLabel("세트수");
		setCntLb.setBounds(0, 0, 80, 40);
		setCntPanel.add(setCntLb);

		repCntLb = new JLabel("횟수");
		repCntLb.setBounds(0, 0, 80, 40);
		repCntPanel.add(repCntLb);

		exerciseTimeBtn = new JButton[5];
		setCntBtn = new JButton[5];
		repCntBtn = new JButton[5];
		for (int i = 0; i < 5; i++) {
			exerciseTimeBtn[i] = new JButton();
			setCntBtn[i] = new JButton();
			repCntBtn[i] = new JButton();
			exerciseTimePanel.add(exerciseTimeBtn[i]);
			exerciseTimeBtn[i].setBounds(80 + i * 80, 0, 80, 40);
			setCntPanel.add(setCntBtn[i]);
			setCntBtn[i].setBounds(80 + i * 80, 0, 80, 40);
			repCntPanel.add(repCntBtn[i]);
			repCntBtn[i].setBounds(80 + i * 80, 0, 80, 40);
		}

		startBtn = new JButton(new ImageIcon("images/운동시작.png"));
		startBtn.setBounds(300, 300, 100, 40);

		this.add(exerciseTimePanel);
		this.add(setCntPanel);
		this.add(repCntPanel);
		this.add(startBtn);

		this.setSize(700, 400);
		this.setVisible(false);
	}

	public void setPreExerciseStartController(PreExerciseStartController controller) {
		this.pESController = controller;
	}

	public JPanel getExerciseTimePanel() {
		return exerciseTimePanel;
	}

	public void setExerciseTimePanel(JPanel exerciseTimePanel) {
		this.exerciseTimePanel = exerciseTimePanel;
	}

	public JPanel getSetCntPanel() {
		return setCntPanel;
	}

	public void setSetCntPanel(JPanel setCntPanel) {
		this.setCntPanel = setCntPanel;
	}

	public JPanel getRepCntPanel() {
		return repCntPanel;
	}

	public void setRepCntPanel(JPanel repCntPanel) {
		this.repCntPanel = repCntPanel;
	}

	public JLabel getExerciseTimeLb() {
		return exerciseTimeLb;
	}

	public void setExerciseTimeLb(JLabel exerciseTimeLb) {
		this.exerciseTimeLb = exerciseTimeLb;
	}

	public JLabel getSetCntLb() {
		return setCntLb;
	}

	public void setSetCntLb(JLabel setCntLb) {
		this.setCntLb = setCntLb;
	}

	public JLabel getRepCntLb() {
		return repCntLb;
	}

	public void setRepCntLb(JLabel repCntLb) {
		this.repCntLb = repCntLb;
	}

	public JButton[] getExerciseTimeBtn() {
		return exerciseTimeBtn;
	}

	public void setExerciseTimeBtn(JButton[] exerciseTimeBtn) {
		this.exerciseTimeBtn = exerciseTimeBtn;
	}

	public JButton[] getSetCntBtn() {
		return setCntBtn;
	}

	public void setSetCntBtn(JButton[] setCntBtn) {
		this.setCntBtn = setCntBtn;
	}

	public JButton[] getRepCntBtn() {
		return repCntBtn;
	}

	public void setRepCntBtn(JButton[] repCntBtn) {
		this.repCntBtn = repCntBtn;
	}

	public JButton getStartBtn() {
		return startBtn;
	}

	public void setStartBtn(JButton startBtn) {
		this.startBtn = startBtn;
	}
}