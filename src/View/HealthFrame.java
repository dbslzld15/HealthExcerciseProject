package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Controller.ExerciseStartController;
import Controller.HealthFrameController;

public class HealthFrame extends JFrame {
	private ExerciseStartController eSController;
	private HealthFrameController hFController;

	private JButton myPageBtn = new JButton("마이 페이지");
	private JButton healthBtn = new JButton("운동 리스트");
	private JButton startBtn = new JButton("운동 시작");
	private JPanel topPanel = new JPanel();
	private JPanel topPanel2 = new JPanel();
	private JPanel westPanel = new JPanel();
	private JPanel westPanel2 = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel eastPanel = new JPanel();
	private ExerciseStartView eSView = new ExerciseStartView();
	private JComboBox firstBox = new JComboBox();
	private JButton inButton = new JButton("입력");
	private JLabel inLabel = new JLabel("아픈 부위 입력 : ");
	private JLabel Label = new JLabel("상세 부위 설명");
	protected JTextArea explainArea = new JTextArea(200,250);
	protected JButton exButton[] = new JButton[9];
	protected JComboBox secondBox = new JComboBox();
	private JScrollPane scroll = new JScrollPane(explainArea);
	
	public HealthFrame() {
		setTitle("운동리스트");

		this.setLayout(null);


		startBtn.addActionListener(new BtnListener());
		healthBtn.addActionListener(new BtnListener());
		myPageBtn.addActionListener(new BtnListener());


		topPanel.setLayout(new FlowLayout());
		
		topPanel.add(myPageBtn);
		topPanel.add(healthBtn);
		topPanel.add(startBtn);
		topPanel.setBounds(0, 0, 700, 40);
		
		firstBox.setPreferredSize(new Dimension(100, 20));
		secondBox.setPreferredSize(new Dimension(100, 20)); // 콤보박스 가로 크기 조절

		topPanel2.setLayout(new FlowLayout());
		topPanel2.setPreferredSize(new Dimension(700,40));
		topPanel2.add(inLabel);
		topPanel2.add(firstBox);
		topPanel2.add(secondBox);
		topPanel2.add(inButton);

		topPanel2.setBounds(0, 40, 700, 40);
		
		westPanel.setLayout(new GridLayout(3,3,5,5));
		westPanel.setBounds(0,80,400,300);
		
		
		for(int i=0;i<9;i++)
		{
			exButton[i]= new JButton();
			westPanel.add(exButton[i]);
		}
		
		explainArea.setEditable(false);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		eastPanel.setLayout(new FlowLayout());
		eastPanel.setBounds(420,80,200,300);
		eastPanel.add(Label);
		eastPanel.add(scroll);
		
	
		this.add(topPanel);
		this.add(topPanel2);
		this.add(westPanel);
		this.add(eastPanel);

		this.add(topPanel);
		this.add(topPanel2, BorderLayout.CENTER);
		// 운동시작 패널 설정

		this.add(eSView, BorderLayout.SOUTH);


		setVisible(true);
		setSize(700, 500);
	}// 생성자


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

	public JPanel getTopPanel2() {
		return topPanel2;
	}

	public void setTopPanel2(JPanel topPanel2) {
		this.topPanel2 = topPanel2;
	}


	public JComboBox getFirstBox() {
		return firstBox;
	}

	public void setFirstBox(JComboBox firstBox) {
		this.firstBox = firstBox;
	}

	public JComboBox getSecondBox() {
		return secondBox;
	}

	public void setSecondBox(JComboBox secondBox) {
		this.secondBox = secondBox;
	}

	public JButton getInButton() {
		return inButton;
	}

	public void setInButton(JButton inButton) {
		this.inButton = inButton;
	}

	public JLabel getInLabel() {
		return inLabel;
	}

	public void setInLabel(JLabel inLabel) {
		this.inLabel = inLabel;
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
