package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.PreExerciseStartController;

public class PreExerciseStartView extends JPanel {

   private PreExerciseStartController pESController;

   private JPanel exerciseTimePanel;
   private JPanel setCntPanel;
   private JPanel repCntPanel;
   private JLabel exerciseTimeLb;
   private JLabel setCntLb;
   private JLabel repCntLb;
   private JButton exerciseTimeBtn[];
   private JButton setCntBtn[];
   private JButton repCntBtn[];

   private JButton startBtn;
 
   private ImageIcon mainIcon;
   private Image img;
   private Image img2 ;
   private ImageIcon mainIcon2 ;
   
   private ImageIcon mainIcon3;
   private Image img3;
   private Image img4 ;
   private ImageIcon mainIcon4;
   private ButtonGroup exerciseGroup;
   private ButtonGroup setGroup;
   private ButtonGroup repGroup;
   
   private ImageIcon mainIcon5;
   private Image img5;
   private Image img6;
   private ImageIcon mainIcon6 ;

   private String str1[]= {"images/15분.png","images/30분.png","images/45분.png","images/60분.png","images/75분.png"};
   private String str2[]= {"images/1세트.png","images/4세트.png","images/6세트.png","images/8세트.png","images/10세트.png"};
   private String str3[]= {"images/5회.png","images/10회.png","images/15회.png","images/20회.png","images/25회.png"};


   public PreExerciseStartView() {
      init();
   }

   public void init() {
      this.setLayout(null);

      exerciseGroup = new ButtonGroup();
      setGroup = new ButtonGroup();
      repGroup = new ButtonGroup();

      exerciseTimePanel = new JPanel();
      exerciseTimePanel.setLayout(null);
      exerciseTimePanel.setBounds(150, 60, 800, 60);

      setCntPanel = new JPanel();
      setCntPanel.setLayout(null);
      setCntPanel.setBounds(150, 150, 800, 60);

      repCntPanel = new JPanel();
      repCntPanel.setLayout(null);
      repCntPanel.setBounds(150, 240, 800, 60);

      exerciseTimeLb = new JLabel("운동시간");
      exerciseTimeLb.setFont(new Font("맑은 고딕",Font.BOLD,20));
      exerciseTimeLb.setBounds(0, 0, 120, 60);
      exerciseTimePanel.add(exerciseTimeLb);

      setCntLb = new JLabel("세트수");
      setCntLb.setFont(new Font("맑은 고딕",Font.BOLD,20));
      setCntLb.setBounds(0, 0, 120, 60);
      setCntPanel.add(setCntLb);

      repCntLb = new JLabel("횟수");
      repCntLb.setFont(new Font("맑은 고딕",Font.BOLD,20));
      repCntLb.setBounds(0, 0, 120, 60);
      repCntPanel.add(repCntLb);

      exerciseTimeBtn = new JButton[5];
      setCntBtn = new JButton[5];
      repCntBtn = new JButton[5];
      for (int i = 0; i < 5; i++) {
         
        ImageIcon mainIcon = new ImageIcon(str1[i]);
         Image img = mainIcon.getImage();
         Image img2 = img.getScaledInstance(120, 60, java.awt.Image.SCALE_SMOOTH);
         ImageIcon mainIcon2 = new ImageIcon(img2);
         
         ImageIcon mainIcon3 = new ImageIcon(str2[i]);
         Image img3 = mainIcon3.getImage();
         Image img4 = img3.getScaledInstance(120, 60, java.awt.Image.SCALE_SMOOTH);
         ImageIcon mainIcon4 = new ImageIcon(img4);
         
         ImageIcon mainIcon5 = new ImageIcon(str3[i]);
         Image img5 = mainIcon5.getImage();
         Image img6 = img5.getScaledInstance(120, 60, java.awt.Image.SCALE_SMOOTH);
         ImageIcon mainIcon6 = new ImageIcon(img6);
         
         
         exerciseTimeBtn[i] = new JButton(mainIcon2);
         exerciseTimeBtn[i].setName(Integer.toString(15*(i+1))+"분");
         setCntBtn[i] = new JButton(mainIcon4);
         if(i==0)
         {
             setCntBtn[i].setName(Integer.toString(1)+"세트");
         }
         else {
             setCntBtn[i].setName(Integer.toString(2*(i+1))+"세트");
         }
         repCntBtn[i] = new JButton(mainIcon6);
         repCntBtn[i].setName(Integer.toString(5*(i+1))+"회");
         exerciseTimePanel.add(exerciseTimeBtn[i]);
         exerciseTimeBtn[i].setBounds(120 + i * 120, 0, 120, 60);
         setCntPanel.add(setCntBtn[i]);
         setCntBtn[i].setBounds(120 + i * 120, 0, 120, 60);
         repCntPanel.add(repCntBtn[i]);
         repCntBtn[i].setBounds(120 + i * 120, 0, 120, 60);

         exerciseGroup.add(exerciseTimeBtn[i]);
         setGroup.add(setCntBtn[i]);
         repGroup.add(repCntBtn[i]);   
      }

      startBtn = new JButton(new ImageIcon("images/운동시작.png"));
      startBtn.setBounds(500, 400, 100, 40);

      exerciseTimePanel.setBackground(new Color(96,181,220));
      setCntPanel.setBackground(new Color(96,181,220));
      repCntPanel.setBackground(new Color(96,181,220));
      this.setBackground(new Color(96,181,220));

      this.add(exerciseTimePanel);
      this.add(setCntPanel);
      this.add(repCntPanel);
      this.add(startBtn);

      this.setSize(700, 400);
      this.setVisible(false);
   }

   public void setPreExerciseStartController(PreExerciseStartController controller) {
      this.pESController = controller;
   }

   public JPanel getExerciseTimePanel() {
      return exerciseTimePanel;
   }

   public void setExerciseTimePanel(JPanel exerciseTimePanel) {
      this.exerciseTimePanel = exerciseTimePanel;
   }

   public JPanel getSetCntPanel() {
      return setCntPanel;
   }

   public void setSetCntPanel(JPanel setCntPanel) {
      this.setCntPanel = setCntPanel;
   }

   public JPanel getRepCntPanel() {
      return repCntPanel;
   }

   public void setRepCntPanel(JPanel repCntPanel) {
      this.repCntPanel = repCntPanel;
   }

   public JLabel getExerciseTimeLb() {
      return exerciseTimeLb;
   }

   public void setExerciseTimeLb(JLabel exerciseTimeLb) {
      this.exerciseTimeLb = exerciseTimeLb;
   }

   public JLabel getSetCntLb() {
      return setCntLb;
   }

   public void setSetCntLb(JLabel setCntLb) {
      this.setCntLb = setCntLb;
   }

   public JLabel getRepCntLb() {
      return repCntLb;
   }

   public void setRepCntLb(JLabel repCntLb) {
      this.repCntLb = repCntLb;
   }

   public JButton[] getExerciseTimeBtn() {
      return exerciseTimeBtn;
   }

   public void setExerciseTimeBtn(JButton[] exerciseTimeBtn) {
      this.exerciseTimeBtn = exerciseTimeBtn;
   }

   public JButton[] getSetCntBtn() {
      return setCntBtn;
   }

   public void setSetCntBtn(JButton[] setCntBtn) {
      this.setCntBtn = setCntBtn;
   }

   public JButton[] getRepCntBtn() {
      return repCntBtn;
   }

   public void setRepCntBtn(JButton[] repCntBtn) {
      this.repCntBtn = repCntBtn;
   }

   public JButton getStartBtn() {
      return startBtn;
   }

   public void setStartBtn(JButton startBtn) {
      this.startBtn = startBtn;
   }
}