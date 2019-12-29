package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class ExerciseStartView extends JPanel{

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

	private JTable myExerciseListList;


	public ExerciseStartView() {
		init();

	}

	public void init() {
		this.setLayout(null);
		
		cntPanel = new JPanel();
		exerciseTimePanel = new JPanel();
		timerBtnPanel = new JPanel();
		myListPanel = new JPanel();
		
	
		cntPanel.setLayout(null);
		cntPanel.setBounds(440,100,150,80);
		exerciseTimePanel.setLayout(null);
		exerciseTimePanel.setBounds(400,220,150,80);
		timerBtnPanel.setLayout(null);
		timerBtnPanel.setBounds(400,300,220,60);
		myListPanel.setLayout(null);
		myListPanel.setBounds(50,50,250,350);

		startTimerBtn = new JButton("START");
		stopTimerBtn = new JButton("STOP");
		
		startTimerBtn.setBounds(0,0,80,40);
		stopTimerBtn.setBounds(100,0,80,40);

		timerBtnPanel.add(startTimerBtn);
		timerBtnPanel.add(stopTimerBtn);
		
		setCntLb = new JLabel("세트수");
		repCntLb = new JLabel("횟수");

		setNumLb = new JLabel("0");
		repNumLb = new JLabel("0");
		
		setCntLb.setBounds(0,0,40,30);
		repCntLb.setBounds(60,0,40,30);
		setNumLb.setBounds(0,40,40,30);
		repNumLb.setBounds(60,40,40,30);
		
		cntPanel.add(setCntLb);
		cntPanel.add(repCntLb);
		cntPanel.add(setNumLb);
		cntPanel.add(repNumLb);

		exerciseTimeLb = new JLabel("운동시간");
		exerciseTimeNumLb = new JLabel("0");
		
		exerciseTimeLb.setBounds(0,0,80,40);
		exerciseTimeNumLb.setBounds(100,0,80,40);

		exerciseTimePanel.add(exerciseTimeLb);
		exerciseTimePanel.add(exerciseTimeNumLb);
		
		myExerciseListLb = new JLabel("나의 운동 리스트");

		myExerciseListList = new JTable();
		
		myExerciseListLb.setBounds(0,0,120,30);
		myExerciseListList.setBounds(0,40,120,270);

		myListPanel.add(myExerciseListLb);
		myListPanel.add(myExerciseListList);
		
	
		this.add(cntPanel);
		this.add(exerciseTimePanel);
		this.add(timerBtnPanel);
		this.add(myListPanel);
		
		this.setSize(700,400);
		
		this.setVisible(false);
		

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

	public JTable getMyExerciseListList() {
		return myExerciseListList;
	}

	public void setMyExerciseListList(JTable myExerciseListList) {
		this.myExerciseListList = myExerciseListList;
	}
}
