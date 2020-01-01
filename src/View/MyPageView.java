package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.ScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.Panel;
import java.awt.Rectangle;
import javax.swing.ScrollPaneConstants;

public class MyPageView extends JPanel {

	private JPanel listPanel = new JPanel();
	private JLabel listLabel = new JLabel("나의 운동 리스트");

	

	private JTable myExerciseListList;
	private JScrollPane myExerciseScrollPane;
	private DefaultTableModel model;
	
	private JButton deleteButton = new JButton("운동 삭제");
	
	private ImageIcon mainIcon;// = new ImageIcon("images/main.jpg");
	private Image img;// = mainIcon.getImage();
	private Image img2;// = img.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
	private ImageIcon mainIcon2;// = new ImageIcon(img2);
	private JLabel mainIconLabel;// = new JLabel();
	private JPanel imagePanel = new JPanel();
	
	private JPanel totalPanel = new JPanel();
	private JPanel totalDaysPanel = new JPanel();
	private JPanel totalTimePanel = new JPanel();
	private JLabel totalDaysLabel = new JLabel("총 일수");
	private JLabel totalDaysCntLabel = new JLabel("?111");
	private JLabel totalTimeLabel = new JLabel("총 운동 시간");
	private JLabel totalTimeCntLabel = new JLabel("?222");

	public MyPageView() {
		init();
	}

	public void init() {

		this.setLayout(null);
		
		listPanel.setLayout(null);
		listPanel.setBounds(0, 0, 350, 650);
		add(listPanel);
		
		totalPanel.setLayout(null);
		totalPanel.setBounds(950, 0, 150, 650);
		add(totalPanel);
		listLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		listLabel.setBounds(80, 10, 180, 50);
		listPanel.add(listLabel);
		
		String[] a = { "운동명" };
		String[][] b = { };
		model = new DefaultTableModel(b, a);// 모델과 데이터를 연결해줌
		// 데이터를 복사해서 추가한 것이 아닌 링크해서 추가한 것이다.
		// 모델을 안쓰게되면 새로만들어야한다.
		myExerciseListList = new JTable(model);				
//		myExerciseListList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //단일 선택
//		myExerciseListList.addMouseListener(this);
		myExerciseScrollPane = new JScrollPane(myExerciseListList);
		myExerciseScrollPane.setBounds(70, 80, 200, 450);
		listPanel.add(myExerciseScrollPane);
	
		deleteButton.setBounds(110, 550, 120, 30);
		listPanel.add(deleteButton);
		
		imagePanel.setBounds(350, 0, 600, 650);
		imagePanel.setLayout(null);
		add(imagePanel);
		
		mainIcon = new ImageIcon("images/register.png");
		img = mainIcon.getImage();
		img2 = img.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
		mainIcon2 = new ImageIcon(img2);
		mainIconLabel = new JLabel(mainIcon2); //이미지 아이콘 크기 조절 후 다시 설정
		mainIconLabel.setBounds(10, 10, 580, 630);
		mainIconLabel.setLayout(null);
//		Rectangle r = new Rectangle(300, 400);
//		mainIconLabel.setBounds(r);
		mainIconLabel.setVerticalAlignment(SwingConstants.CENTER);
		mainIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imagePanel.add(mainIconLabel);
		
		totalDaysPanel.setBounds(0, 0, 150, 200);
		totalPanel.add(totalDaysPanel);
		totalTimePanel.setBounds(0, 200, 150, 200);
		totalPanel.add(totalTimePanel);
		totalDaysPanel.setLayout(null);
		totalTimePanel.setLayout(null);
		
		totalDaysLabel.setBounds(35, 0, 80, 50);
		totalDaysLabel.setVerticalAlignment(SwingConstants.CENTER);
		totalDaysPanel.add(totalDaysLabel);
		
		totalDaysCntLabel.setBounds(50, 50, 50, 150);
		totalDaysCntLabel.setVerticalAlignment(SwingConstants.CENTER);
		totalDaysPanel.add(totalDaysCntLabel);
		
		totalTimeLabel.setBounds(25, 0, 100, 50);
		totalTimeLabel.setVerticalAlignment(SwingConstants.CENTER);
		totalTimePanel.add(totalTimeLabel);
		
		totalTimeCntLabel.setBounds(50, 50, 50, 150);
		totalTimeCntLabel.setVerticalAlignment(SwingConstants.CENTER);
		totalTimePanel.add(totalTimeCntLabel);
		
		setSize(1100, 700);
		this.setVisible(false);

	}

	public JPanel getListPanel() {
		return listPanel;
	}

	public void setListPanel(JPanel listPanel) {
		this.listPanel = listPanel;
	}

	public JLabel getListLabel() {
		return listLabel;
	}

	public void setListLabel(JLabel listLabel) {
		this.listLabel = listLabel;
	}

	public ImageIcon getMainIcon() {
		return mainIcon;
	}

	public void setMainIcon(ImageIcon mainIcon) {
		this.mainIcon = mainIcon;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public Image getImg2() {
		return img2;
	}

	public void setImg2(Image img2) {
		this.img2 = img2;
	}

	public ImageIcon getMainIcon2() {
		return mainIcon2;
	}

	public void setMainIcon2(ImageIcon mainIcon2) {
		this.mainIcon2 = mainIcon2;
	}

	public JPanel getImagePanel() {
		return imagePanel;
	}

	public void setImagePanel(JPanel imagePanel) {
		this.imagePanel = imagePanel;
	}

	public JPanel getTotalPanel() {
		return totalPanel;
	}

	public void setTotalPanel(JPanel totalPanel) {
		this.totalPanel = totalPanel;
	}

	public JPanel getTotalDaysPanel() {
		return totalDaysPanel;
	}

	public void setTotalDaysPanel(JPanel totalDaysPanel) {
		this.totalDaysPanel = totalDaysPanel;
	}

	public JPanel getTotalTimePanel() {
		return totalTimePanel;
	}

	public void setTotalTimePanel(JPanel totalTimePanel) {
		this.totalTimePanel = totalTimePanel;
	}

	public JLabel getTotalDaysLabel() {
		return totalDaysLabel;
	}

	public void setTotalDaysLabel(JLabel totalDaysLabel) {
		this.totalDaysLabel = totalDaysLabel;
	}

	public JLabel getTotalDaysCntLabel() {
		return totalDaysCntLabel;
	}

	public void setTotalDaysCntLabel(JLabel totalDaysCntLabel) {
		this.totalDaysCntLabel = totalDaysCntLabel;
	}

	public JLabel getTotalTimeLabel() {
		return totalTimeLabel;
	}

	public void setTotalTimeLabel(JLabel totalTimeLabel) {
		this.totalTimeLabel = totalTimeLabel;
	}

	public JLabel getTotalTimeCntLabel() {
		return totalTimeCntLabel;
	}

	public void setTotalTimeCntLabel(JLabel totalTimeCntLabel) {
		this.totalTimeCntLabel = totalTimeCntLabel;
	}

	public JTable getMyExerciseListList() {
		return myExerciseListList;
	}

	public void setMyExerciseListList(JTable myExerciseListList) {
		this.myExerciseListList = myExerciseListList;
	}

	public JScrollPane getMyExerciseScrollPane() {
		return myExerciseScrollPane;
	}

	public void setMyExerciseScrollPane(JScrollPane myExerciseScrollPane) {
		this.myExerciseScrollPane = myExerciseScrollPane;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}
	
	public DefaultTableModel getListModel() {
		return model;
	}
	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	
	
	
}