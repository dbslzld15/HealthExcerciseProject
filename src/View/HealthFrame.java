package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class HealthFrame extends JFrame {

	private JButton myPageBtn = new JButton("마이 페이지");
	private JButton healthBtn = new JButton("운동 리스트");
	private JButton startBtn = new JButton("운동 시작");
	private JPanel topPanel = new JPanel();
	private JPanel topPanel2 = new JPanel();
	private JPanel midPanel = new JPanel();

	private JComboBox firstBox = new JComboBox();
	private JComboBox secondBox = new JComboBox();
	private JButton inButton = new JButton("입력");
	private JLabel inLabel = new JLabel("아픈 부위 입력 : ");
	private JList healthList = new JList();

	public HealthFrame() {
		setTitle("운동리스트");

		topPanel.setLayout(new FlowLayout());
		topPanel.add(myPageBtn);
		topPanel.add(healthBtn);
		topPanel.add(startBtn);

		firstBox.setPreferredSize(new Dimension(100, 20));
		secondBox.setPreferredSize(new Dimension(50, 20)); // 콤보박스 가로 크기 조절

		topPanel2.setLayout(new FlowLayout());
		topPanel2.add(inLabel);
		topPanel2.add(firstBox);
		topPanel2.add(secondBox);
		topPanel2.add(inButton);

		midPanel.setLayout(new GridLayout(3, 3));

		this.add(topPanel, BorderLayout.NORTH);
		this.add(topPanel2);
		setVisible(true);
		setSize(600, 400);
	}// 생성자

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

	public JPanel getMidPanel() {
		return midPanel;
	}

	public void setMidPanel(JPanel midPanel) {
		this.midPanel = midPanel;
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

	public JList getHealthList() {
		return healthList;
	}

	public void setHealthList(JList healthList) {
		this.healthList = healthList;
	}

}
