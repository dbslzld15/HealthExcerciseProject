package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HealthListView extends JPanel {
	private JPanel topPanel2;
	private JPanel westPanel;
	private JPanel eastPanel;
	private String[] firstString= {"전체보기","어깨","무릎","허리"};
	private String[] secondString= {"전체보기"};
	private JComboBox<String> firstBox;
	private JButton inButton;
	private JButton registerButton;
	private JLabel inLabel;
	private JLabel Label;
	protected JTextArea explainArea;
	protected JButton exButton[];
	protected JComboBox<String> secondBox;
	private JScrollPane btnScroll;
	private JScrollPane explainScroll;
	
	public HealthListView() {
		init();
	}
	
	public void init() {
		this.setLayout(null);
		topPanel2 = new JPanel();
		westPanel = new JPanel();
		eastPanel = new JPanel();
		firstBox = new JComboBox<>(firstString);
		secondBox = new JComboBox<>(secondString);
		registerButton = new JButton(new ImageIcon("images/등록.png"));
		inButton = new JButton(new ImageIcon("images/입력.png"));
		inLabel = new JLabel("아픈 부위 입력 : ");
		Label = new JLabel("상세 부위 설명");
		explainArea = new JTextArea(30,30);
		exButton = new JButton[12];
		
		explainArea.setLineWrap(true);
		firstBox.setPreferredSize(new Dimension(150, 40));
		secondBox.setPreferredSize(new Dimension(150, 40)); // 콤보박스 가로 크기 조절
		
		inButton.setPreferredSize(new Dimension(65,40));
		topPanel2.setLayout(new FlowLayout());
		topPanel2.setPreferredSize(new Dimension(1100, 50));
		topPanel2.add(inLabel);
		topPanel2.add(firstBox);
		topPanel2.add(secondBox);
		topPanel2.add(inButton);

		topPanel2.setBounds(0, 0, 1100, 50);
		westPanel.setLayout(null);
		
		int k=0;
		for (int i = 0; i < 3; i++) {
			
			for(int j=0;j<3;j++)
			{
				exButton[k] = new JButton(new ImageIcon("운동사진"));
				exButton[k].setBounds(233*j, 167*i, 233, 167);
				westPanel.add(exButton[k]);
				k++;
			}
		}
		
		btnScroll = new JScrollPane(westPanel);
		btnScroll.setBounds(0, 80, 699, 501);
		btnScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		btnScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
	
		
		
		eastPanel.setLayout(new FlowLayout());
		eastPanel.setBounds(720, 80, 350,400);
		//eastPanel.add(Label);
		eastPanel.add(explainArea);
		explainScroll = new JScrollPane(eastPanel);
		explainScroll.setBounds(720, 80, 350, 400);
		explainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		explainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		registerButton.setBounds(720,500,65,40);
		
		this.add(topPanel2);
		this.add(btnScroll);
		this.add(explainScroll);
		this.add(registerButton);
		this.setSize(1100,700);
	
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

	public JPanel getWestPanel() {
		return westPanel;
	}

	public void setWestPanel(JPanel westPanel) {
		this.westPanel = westPanel;
	}


	public JPanel getEastPanel() {
		return eastPanel;
	}

	public void setEastPanel(JPanel eastPanel) {
		this.eastPanel = eastPanel;
	}

	public JLabel getLabel() {
		return Label;
	}

	public void setLabel(JLabel label) {
		Label = label;
	}

	public JTextArea getExplainArea() {
		return explainArea;
	}

	public void setExplainArea(JTextArea explainArea) {
		this.explainArea = explainArea;
	}

	public JButton[] getExButton() {
		return exButton;
	}

	public void setExButton(JButton[] exButton) {
		this.exButton = exButton;
	}


	public String[] getFirstString() {
		return firstString;
	}

	public void setFirstString(String[] firstString) {
		this.firstString = firstString;
	}

	public String[] getSecondString() {
		return secondString;
	}

	public void setSecondString(String[] secondString) {
		secondString = secondString;
	}

	public JButton getRegisterButton() {
		return registerButton;
	}

	public void setRegisterButton(JButton registerButton) {
		this.registerButton = registerButton;
	}
}
