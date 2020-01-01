package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
	private String[] firstString= {"ÀüÃ¼º¸±â","¾î±ú","¹«¸­","Çã¸®"};
	private String[] secondString= {"ÀüÃ¼º¸±â"};
	private JComboBox<String> firstBox;
	private JButton inButton;
	private JButton registerButton;
	private JLabel inLabel;
	private JLabel Label;
	private JLabel exerciseNameLabel;
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
		registerButton = new JButton(new ImageIcon("images/µî·Ï.png"));
		inButton = new JButton(new ImageIcon("images/ÀÔ·Â.png"));
		inLabel = new JLabel("¾ÆÇÂ ºÎÀ§ ÀÔ·Â : ");
		Label = new JLabel("»ó¼¼ ºÎÀ§ ¼³¸í");
		explainArea = new JTextArea();
		exButton = new JButton[12];
		exerciseNameLabel = new JLabel("¿îµ¿ ÀÌ¸§");
		
		inLabel.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		
		explainArea.setLineWrap(true);
		firstBox.setPreferredSize(new Dimension(150, 40));
		firstBox.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		secondBox.setPreferredSize(new Dimension(150, 40)); // ÄÞº¸¹Ú½º °¡·Î Å©±â Á¶Àý
		secondBox.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		
		inButton.setPreferredSize(new Dimension(65,40));
		topPanel2.setLayout(new FlowLayout());
		topPanel2.setPreferredSize(new Dimension(1100, 50));
		topPanel2.add(inLabel);
		topPanel2.add(firstBox);
		topPanel2.add(secondBox);
		topPanel2.add(inButton);

		topPanel2.setBackground(new Color(96,181,220));
		topPanel2.setBounds(0, 0, 1100, 50);
		
		westPanel.setLayout(new GridLayout(0,3,5,5));
		westPanel.setBackground(new Color(96,181,220));
	
	
		
		btnScroll = new JScrollPane(westPanel); 
		btnScroll.setBounds(0, 80, 699, 167);
		btnScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		btnScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		btnScroll.getVerticalScrollBar().setUnitIncrement(10);

		btnScroll.setBackground(new Color(96,181,220));
		
		explainArea.setPreferredSize(new Dimension(340,285));
		explainArea.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,15));
		eastPanel.setLayout(new FlowLayout());
		eastPanel.setBounds(720, 80, 350,400);
		eastPanel.add(explainArea);
		
		exerciseNameLabel.setBounds(720, 100, 350, 50);
		exerciseNameLabel.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,20));
		exerciseNameLabel.setHorizontalAlignment(JLabel.CENTER);
		
		explainScroll = new JScrollPane(eastPanel);
		
		
		explainScroll.setBounds(720, 180, 350, 300);
		explainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		explainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		explainScroll.getVerticalScrollBar().setUnitIncrement(10);
		
		
		registerButton.setBounds(720,500,65,40);
		
		this.add(topPanel2);
		this.add(btnScroll);
		this.add(exerciseNameLabel);
		this.add(explainScroll);
		this.add(registerButton);
		this.setSize(1100,700);
		this.setBackground(new Color(96,181,220));
	
	}
	
	public JLabel getExerciseNameLabel() {
		return exerciseNameLabel;
	}

	public void setExerciseNameLabel(JLabel exerciseNameLabel) {
		this.exerciseNameLabel = exerciseNameLabel;
	}

	public JScrollPane getBtnScroll() {
		return btnScroll;
	}

	public void setBtnScroll(JScrollPane btnScroll) {
		this.btnScroll = btnScroll;
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
