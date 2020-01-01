package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
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

public class MyPageView extends JPanel {

	private JPanel listPanel = new JPanel();
	private JLabel listLabel = new JLabel("���� � ����Ʈ");

	private JTable myExerciseListList;
	private JScrollPane myExerciseScrollPane;


	private DefaultTableModel model;
	
	private JButton deleteButton = new JButton("� ����");
	
	private ImageIcon mainIcon = new ImageIcon("images/main.jpg");
	private Image img = mainIcon.getImage();
	private Image img2 = img.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
	private ImageIcon mainIcon2 = new ImageIcon(img2);
	private JPanel imagePanel = new JPanel();
	
	private JPanel totalPanel = new JPanel();
	private JPanel totalDaysPanel = new JPanel();
	private JPanel totalTimePanel = new JPanel();
	private JLabel totalDaysLabel = new JLabel("�� �ϼ�");
	private JLabel totalDaysCntLabel = new JLabel("?111");
	private JLabel totalTimeLabel = new JLabel("�� � �ð�");
	private JLabel totalTimeCntLabel = new JLabel("?222");

	public MyPageView() {
		init();
	}

	public void init() {

		this.setLayout(null);
		
		listPanel.setLayout(null);
		listPanel.setBounds(0, 0, 250, 700);
		add(listPanel);
		
		totalPanel.setLayout(null);
		totalPanel.setBounds(950, 0, 150, 700);
		add(totalPanel);
		
		listLabel.setVerticalAlignment(SwingConstants.TOP);
		listLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		listLabel.setBounds(30, 10, 180, 50);
		listPanel.add(listLabel);
		
		String[] a = { "���" };
		String[][] b = { };
		model = new DefaultTableModel(b, a);// �𵨰� �����͸� ��������
		// �����͸� �����ؼ� �߰��� ���� �ƴ� ��ũ�ؼ� �߰��� ���̴�.
		// ���� �Ⱦ��ԵǸ� ���θ������Ѵ�.
		myExerciseListList = new JTable(model);				
//		myExerciseListList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //���� ����
//		myExerciseListList.addMouseListener(this);
	
		myExerciseScrollPane = new JScrollPane(myExerciseListList);
		myExerciseScrollPane.setBounds(40, 50, 160, 270);
		listPanel.add(myExerciseScrollPane);
	
		deleteButton.setBounds(60, 350, 120, 30);
		listPanel.add(deleteButton);
		imagePanel.setBounds(250, 0, 300, 400);
		listPanel.add(imagePanel);
		
		imagePanel.setLayout(null);
		
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