package View;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExerciseStartView extends JPanel{

	private JPanel exerciseStartPanel;
	private JPanel cntPanel;
	private JPanel exerciseTimePanel;
	private JPanel timerBtnPanel;
	private JPanel myListPanel;

	private JButton startTimerBtn;
	private JButton stopTimerBtn;

	private JLabel setCntLb;
	private JLabel repCntLb;

	private JLabel setNumLb;
	private JLabel repNumLb;

	private JLabel exerciseTimeLb;
	private JLabel exerciseTimeNumLb;

	private JLabel myExerciseListLb;

	private JList myExerciseListList;


	public ExerciseStartView() {
		init();

	}

	public void init() {
		exerciseStartPanel = new JPanel();
		cntPanel = new JPanel();
		exerciseTimePanel = new JPanel();
		timerBtnPanel = new JPanel();
		myListPanel = new JPanel();

		startTimerBtn = new JButton("START");
		stopTimerBtn = new JButton("STOP");

		timerBtnPanel.add(startTimerBtn);
		timerBtnPanel.add(stopTimerBtn);
		
		setCntLb = new JLabel("세트수");
		repCntLb = new JLabel("횟수");

		setNumLb = new JLabel("0");
		repNumLb = new JLabel("0");
		
		cntPanel.add(setCntLb);
		cntPanel.add(repCntLb);
		cntPanel.add(setNumLb);
		cntPanel.add(repNumLb);

		exerciseTimeLb = new JLabel("운동시간");
		exerciseTimeNumLb = new JLabel("12:34:56");

		exerciseTimePanel.add(exerciseTimeLb);
		exerciseTimePanel.add(exerciseTimeNumLb);
		
		myExerciseListLb = new JLabel("나의 운동 리스트");

		myExerciseListList = new JList();

		myListPanel.add(myExerciseListLb);
		myListPanel.add(myExerciseListList);
		
		this.add(exerciseStartPanel);
		this.add(cntPanel);
		this.add(exerciseTimePanel);
		this.add(timerBtnPanel);
		this.add(myListPanel);
		this.setVisible(false);


	}

	public JPanel getExerciseStartPanel() {
		return exerciseStartPanel;
	}

	public void setExerciseStartPanel(JPanel exerciseStartPanel) {
		this.exerciseStartPanel = exerciseStartPanel;
	}

	public JPanel getCntPanel() {
		return cntPanel;
	}

	public void setCntPanel(JPanel cntPanel) {
		this.cntPanel = cntPanel;
	}

	public JPanel getExerciseTimePanel() {
		return exerciseTimePanel;
	}

	public void setExerciseTimePanel(JPanel exerciseTimePanel) {
		this.exerciseTimePanel = exerciseTimePanel;
	}

	public JPanel getTimerBtnPanel() {
		return timerBtnPanel;
	}

	public void setTimerBtnPanel(JPanel timerBtnPanel) {
		this.timerBtnPanel = timerBtnPanel;
	}

	public JPanel getMyListPanel() {
		return myListPanel;
	}

	public void setMyListPanel(JPanel myListPanel) {
		this.myListPanel = myListPanel;
	}

	public JButton getStartTimerBtn() {
		return startTimerBtn;
	}

	public void setStartTimerBtn(JButton startTimerBtn) {
		this.startTimerBtn = startTimerBtn;
	}

	public JButton getStopTimerBtn() {
		return stopTimerBtn;
	}

	public void setStopTimerBtn(JButton stopTimerBtn) {
		this.stopTimerBtn = stopTimerBtn;
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

	public JLabel getSetNumLb() {
		return setNumLb;
	}

	public void setSetNumLb(JLabel setNumLb) {
		this.setNumLb = setNumLb;
	}

	public JLabel getRepNumLb() {
		return repNumLb;
	}

	public void setRepNumLb(JLabel repNumLb) {
		this.repNumLb = repNumLb;
	}

	public JLabel getExerciseTimeLb() {
		return exerciseTimeLb;
	}

	public void setExerciseTimeLb(JLabel exerciseTimeLb) {
		this.exerciseTimeLb = exerciseTimeLb;
	}

	public JLabel getExerciseTimeNumLb() {
		return exerciseTimeNumLb;
	}

	public void setExerciseTimeNumLb(JLabel exerciseTimeNumLb) {
		this.exerciseTimeNumLb = exerciseTimeNumLb;
	}

	public JLabel getMyExerciseListLb() {
		return myExerciseListLb;
	}

	public void setMyExerciseListLb(JLabel myExerciseListLb) {
		this.myExerciseListLb = myExerciseListLb;
	}

	public JList getMyExerciseListList() {
		return myExerciseListList;
	}

	public void setMyExerciseListList(JList myExerciseListList) {
		this.myExerciseListList = myExerciseListList;
	}
}
