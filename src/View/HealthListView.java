package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HealthListView extends JPanel {
	private JPanel topPanel2;
	private JPanel westPanel;
	private JPanel westPanel2;
	private JScrollPane scrollPane;
	private JPanel eastPanel;

	private JComboBox firstBox;
	private JButton inButton;
	private JLabel inLabel;
	private JLabel Label;
	protected JTextArea explainArea;
	protected JButton exButton[];
	protected JComboBox secondBox;
	private JScrollPane scroll;
	
	public HealthListView() {
		init();
	}
	
	public void init() {
		this.setLayout(null);
		topPanel2 = new JPanel();
		westPanel = new JPanel();
		westPanel2 = new JPanel();
		scrollPane = new JScrollPane();
		eastPanel = new JPanel();
		firstBox = new JComboBox();
		inButton = new JButton("입력");
		inLabel = new JLabel("아픈 부위 입력 : ");
		Label = new JLabel("상세 부위 설명");
		explainArea = new JTextArea(200, 250);
		exButton = new JButton[9];
		secondBox = new JComboBox();
		JScrollPane scroll = new JScrollPane(explainArea);

		firstBox.setPreferredSize(new Dimension(150, 30));
		secondBox.setPreferredSize(new Dimension(150, 30)); // 콤보박스 가로 크기 조절

		topPanel2.setLayout(new FlowLayout());
		topPanel2.setPreferredSize(new Dimension(700, 40));
		topPanel2.add(inLabel);
		topPanel2.add(firstBox);
		topPanel2.add(secondBox);
		topPanel2.add(inButton);

		topPanel2.setBounds(0, 0, 700, 40);
		westPanel.setLayout(new GridLayout(3, 3, 5, 5));
		westPanel.setBounds(0, 80, 400, 300);

		for (int i = 0; i < 9; i++) {
			exButton[i] = new JButton();
			westPanel.add(exButton[i]);
		}

		explainArea.setEditable(false);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		eastPanel.setLayout(new FlowLayout());
		eastPanel.setBounds(420, 80, 200, 300);
		eastPanel.add(Label);
		eastPanel.add(scroll);

		this.add(topPanel2);
		this.add(westPanel);
		this.add(eastPanel);
		this.setSize(700,400);
	
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

	public JPanel getWestPanel2() {
		return westPanel2;
	}

	public void setWestPanel2(JPanel westPanel2) {
		this.westPanel2 = westPanel2;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
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

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

}
