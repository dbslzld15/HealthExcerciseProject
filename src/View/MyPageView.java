package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;

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
import java.awt.Font;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.Panel;
import java.awt.Rectangle;
import javax.swing.ScrollPaneConstants;

public class MyPageView extends JPanel {

   private JPanel listPanel;
   private JLabel listLabel;

   private JTable myExerciseListList;
   private JScrollPane myExerciseScrollPane;
   private DefaultTableModel model;
   
   private JButton deleteButton;
   
   private ImageIcon mainIcon;
   private Image img;
   private Image img2;
   private ImageIcon mainIcon2;
   private JLabel mainIconLabel;

   
   String day = "00", time = "00";

   private JPanel totalPanel;
   private JPanel totalDaysPanel;
   private JPanel totalTimePanel;
   private JLabel totalDaysLabel;
   private JLabel totalDaysCntLabel;
   private JLabel totalTimeLabel;
   private JLabel totalTimeCntLabel;
   

   public MyPageView() {
      init();
   }

   public void init() {
      this.setLayout(null);

      listPanel = new JPanel();
      listLabel = new JLabel("나의 운동 리스트");
      deleteButton = new JButton(new ImageIcon("images/운동삭제.png"));
      totalPanel = new JPanel();
      totalDaysPanel = new JPanel();
      totalTimePanel = new JPanel();
      totalDaysLabel = new JLabel("총 일수 :");
      totalDaysCntLabel = new JLabel(day + "일");
      totalTimeLabel = new JLabel("총 운동 시간 :");
      totalTimeCntLabel = new JLabel(time);
      

      
      listPanel.setLayout(null);
      listPanel.setBounds(0, 0, 350, 650);
      add(listPanel);
      
      totalPanel.setLayout(null);
      totalPanel.setBounds(750, 100, 300, 700);
      add(totalPanel);
      listLabel.setHorizontalAlignment(SwingConstants.CENTER);
      
      listLabel.setBounds(125, 10, 180, 50);
      listLabel.setFont(new Font("맑은 고딕",Font.BOLD,20));
      totalDaysLabel.setFont(new Font("맑은 고딕",Font.BOLD,20));
      totalDaysCntLabel.setFont(new Font("맑은 고딕",Font.BOLD,20));
      totalTimeCntLabel.setFont(new Font("맑은 고딕",Font.BOLD,20));  
      totalTimeLabel.setFont(new Font("맑은 고딕",Font.BOLD,20));
      
      listPanel.add(listLabel);
      
      String[] a = { "운동명" };
      String[][] b = { };
      model = new DefaultTableModel(b, a);// 모델과 데이터를 연결해줌
      // 데이터를 복사해서 추가한 것이 아닌 링크해서 추가한 것이다.
      // 모델을 안쓰게되면 새로만들어야한다.
      myExerciseListList = new JTable(model);            
     
      myExerciseListList.setFont(new Font("맑은 고딕",Font.PLAIN,15));
      myExerciseListList.setRowHeight(30);//행높이
      myExerciseListList.getTableHeader().setFont(new Font("맑은 고딕",Font.BOLD,20));
      myExerciseListList.getTableHeader().setOpaque(true);
      myExerciseListList.getTableHeader().setBackground(new Color(32,136,203));
      myExerciseListList.getTableHeader().setForeground(new Color(255,255,255));
      
//    myExerciseListList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //단일 선택
//    myExerciseListList.addMouseListener(this);
      myExerciseScrollPane = new JScrollPane(myExerciseListList);
      myExerciseScrollPane.setBounds(70, 80, 300, 450);
      listPanel.add(myExerciseScrollPane);
   
      deleteButton.setBounds(150, 550, 100, 40);
      listPanel.add(deleteButton);
    
      
      mainIcon = new ImageIcon("images/마이페이지초기아이콘.png");
      img = mainIcon.getImage();
      img2 = img.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
      mainIcon2 = new ImageIcon(img2);
      mainIconLabel = new JLabel(mainIcon2); //이미지 아이콘 크기 조절 후 다시 설정
      mainIconLabel.setBounds(300, 0, 500, 550);
      mainIconLabel.setVerticalAlignment(SwingConstants.CENTER);
      mainIconLabel.setHorizontalAlignment(SwingConstants.CENTER);

      this.add(mainIconLabel);

      listPanel.setBackground(new Color(96,181,220));      
      totalDaysPanel.setBackground(new Color(96,181,220));      
      totalTimePanel.setBackground(new Color(96,181,220));           
      totalPanel.setBackground(new Color(96,181,220));
      this.setBackground(new Color(96,181,220));
  
      
      totalDaysPanel.setBounds(0, 0, 300, 200);
      totalPanel.add(totalDaysPanel);
      totalTimePanel.setBounds(0, 200, 300, 200);
      totalPanel.add(totalTimePanel);
      totalDaysPanel.setLayout(null);
      totalTimePanel.setLayout(null);
      
      totalDaysLabel.setBounds(0, 30, 300, 50);
      totalDaysPanel.add(totalDaysLabel);
      
      totalDaysCntLabel.setBounds(150, 30, 130, 50);
      totalDaysCntLabel.setText(day);
      totalDaysPanel.add(totalDaysCntLabel);
      
      totalTimeLabel.setBounds(0, 30, 170, 50);
      totalTimePanel.add(totalTimeLabel);
      
      totalTimeCntLabel.setBounds(170, 30, 130, 50);
      totalTimeCntLabel.setText(time);
      totalTimePanel.add(totalTimeCntLabel);
      
      setSize(1100, 700);
      this.setVisible(false);

   }
   
   
   public JLabel getMainIconLabel() {
   return mainIconLabel;
   }
   
   public void setMainIconLabel(JLabel mainIconLabel) {
   this.mainIconLabel = mainIconLabel;
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

   public String getDay() {
      return day;
   }

   public void setDay(String day) {
      this.day = day;
   }

   public String getTime() {
      return time;
   }

   public void setTime(String time) {
      this.time = time;
   }
   
   
   
}