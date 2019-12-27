package View;

import java.awt.*;
import javax.swing.*;

public class HealthFrame extends JFrame {

	private JButton myPageBtn = new JButton("마이 페이지");
	private JButton healthBtn = new JButton("운동 리스트");
	private JButton startBtn = new JButton("운동 시작");
	private JPanel topPanel = new JPanel();
	private JPanel topPanel2 = new JPanel();
	private JPanel westPanel = new JPanel();
	private JPanel westPanel2 = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel eastPanel = new JPanel();
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
		setVisible(true);
		setSize(700, 500);
	}// 생성자

	class topPanel extends JPanel{
		
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

	

}
