package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.ScrollPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import java.awt.Panel;

public class MyPageView extends JPanel {

	private JPanel myPagePanel = new JPanel();
	private JPanel listPanel = new JPanel();
	private JLabel listLabel = new JLabel("나의 운동 리스트");
	private JList exerciseList = new JList();
	private ArrayList<String> arr = new ArrayList<>();

	private ImageIcon mainIcon = new ImageIcon("images/main.jpg");
	private Image img = mainIcon.getImage();
	private Image img2 = img.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
	private ImageIcon mainIcon2 = new ImageIcon(img2);
	private JPanel imagePanel = new JPanel();
	
	private JPanel totalPanel = new JPanel();
	private JPanel totalDaysPanel = new JPanel();
	private JPanel totalTimePanel = new JPanel();
	private JLabel totalDaysLabel = new JLabel("총 일수");
	private JLabel totalDaysCntLabel = new JLabel("?111");
	private JLabel totalTimeLabel = new JLabel("총 운동 시간");
	private JLabel totalTimeCntLabel = new JLabel("?222");
	private final JPanel panel = new JPanel();

	public MyPageView() {
		init();
	}

	public void init() {
		this.setLayout(null);
		listPanel.setLayout(null);
		listPanel.setBounds(0, 0, 200, 350);
		add(listPanel);
		
		imagePanel.setLayout(null);
		imagePanel.setBounds(200, 0, 300, 350);
		add(imagePanel);
		
		totalPanel.setLayout(null);
		totalPanel.setBounds(500, 0, 100, 350);
		add(totalPanel);
		
		listLabel.setVerticalAlignment(SwingConstants.TOP);
		listLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		listLabel.setBounds(10, 10, 180, 50);
		listPanel.add(listLabel);
		exerciseList.setBounds(10, 50, 180, 270);
		listPanel.add(exerciseList);
	
		totalDaysPanel.setBounds(0, 0, 100, 175);
		totalPanel.add(totalDaysPanel);
		totalTimePanel.setBounds(0, 175, 100, 175);
		totalPanel.add(totalTimePanel);
		totalDaysPanel.setLayout(null);
		totalTimePanel.setLayout(null);
		
		totalDaysLabel.setBounds(0, 0, 100, 50);
		totalDaysLabel.setVerticalAlignment(SwingConstants.CENTER);
		totalDaysPanel.add(totalDaysLabel);
		
		totalDaysCntLabel.setBounds(0, 50, 100, 130);
		totalDaysCntLabel.setVerticalAlignment(SwingConstants.CENTER);
		totalDaysPanel.add(totalDaysCntLabel);
		
		totalTimeLabel.setBounds(0, 0, 100, 50);
		totalTimeLabel.setVerticalAlignment(SwingConstants.CENTER);
		totalTimePanel.add(totalTimeLabel);
		
		totalTimeCntLabel.setBounds(0, 50, 100, 130);
		totalTimeCntLabel.setVerticalAlignment(SwingConstants.CENTER);
		totalTimePanel.add(totalTimeCntLabel);
		
		setSize(600,400);	
		
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

	public JList getExerciseList() {
		return exerciseList;
	}

	public void setExerciseList(JList exerciseList) {
		this.exerciseList = exerciseList;
	}

	public ArrayList<String> getArr() {
		return arr;
	}

	public void setArr(ArrayList<String> arr) {
		this.arr = arr;
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

	public JPanel getPanel() {
		return panel;
	}
}