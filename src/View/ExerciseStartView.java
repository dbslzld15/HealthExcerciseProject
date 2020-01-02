package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ExerciseStartView extends JPanel{

   private JPanel cntPanel;
   private JPanel exerciseTimePanel;
   private JPanel timerBtnPanel;
   private JPanel myListPanel;
   private JPanel setTimePanel;
   private JPanel curSetPanel;

   

   
   
   private JButton startTimerBtn;
   private JButton stopTimerBtn;

   private JLabel setCntLb;
   private JLabel repCntLb;
   
   private JLabel curSetCntLb;
   private JLabel curSetNumLb;

   private JLabel setNumLb;
   private JLabel repNumLb;

   private JLabel exerciseTimeLb;
   private JLabel exerciseTimeNumLb;
   
   private JLabel setTimeLb;
   private JLabel setTimeNumLb;

   private JLabel myExerciseListLb;

   private JTable myExerciseListList;
   private JScrollPane myExerciseScrollPane;

   private MyRenderer myRenderer;
   public ExerciseStartView() {
      init();

   }

   public void init() {
      this.setLayout(null);
      
      cntPanel = new JPanel();
      exerciseTimePanel = new JPanel();
      timerBtnPanel = new JPanel();
      myListPanel = new JPanel();
      setTimePanel = new JPanel();
      curSetPanel = new JPanel();
      
   
      cntPanel.setLayout(null);
      cntPanel.setBounds(750,150,150,80);
      exerciseTimePanel.setLayout(null);
      exerciseTimePanel.setBounds(710,50,170,80);
      timerBtnPanel.setLayout(null);
      timerBtnPanel.setBounds(450,440,220,60);
      myListPanel.setLayout(null);
      myListPanel.setBounds(40,40,300,500);
      setTimePanel.setLayout(null);
      setTimePanel.setBounds(450,100,300,300);
      curSetPanel.setLayout(null);
      curSetPanel.setBounds(750,300,300,200);

      startTimerBtn = new JButton(new ImageIcon("images/START.png"));
      stopTimerBtn = new JButton(new ImageIcon("images/STOP.png"));
      
      startTimerBtn.setBounds(0,0,80,40);
      stopTimerBtn.setBounds(100,0,75,40);

      timerBtnPanel.add(startTimerBtn);
      timerBtnPanel.add(stopTimerBtn);
      
      setCntLb = new JLabel("��Ʈ��");
      repCntLb = new JLabel("Ƚ��");
      
      setCntLb.setFont(new Font("���� ���",Font.BOLD,20));
      repCntLb.setFont(new Font("���� ���",Font.BOLD,20));


      setNumLb = new JLabel("0");
      repNumLb = new JLabel("0");
      
      setNumLb.setFont(new Font("���� ���",Font.BOLD,20));
      repNumLb.setFont(new Font("���� ���",Font.BOLD,20));
      
      
      setCntLb.setBounds(0,0,60,30);
      repCntLb.setBounds(100,0,40,30);
      setNumLb.setBounds(0,40,40,30);
      repNumLb.setBounds(100,40,40,30);
      
      cntPanel.add(setCntLb);
      cntPanel.add(repCntLb);
      cntPanel.add(setNumLb);
      cntPanel.add(repNumLb);

      curSetCntLb = new JLabel("���� ��Ʈ ��");
      curSetNumLb = new JLabel("0");
      
      curSetCntLb.setFont(new Font("���� ���",Font.BOLD,20));
      curSetNumLb.setFont(new Font("���� ���",Font.BOLD,20));


      curSetCntLb.setBounds(0,0,200,50);
      curSetNumLb.setBounds(50,40,150,50);

      curSetPanel.add(curSetCntLb);
      curSetPanel.add(curSetNumLb);
      
      setTimeLb = new JLabel("� �غ�!");
      setTimeLb.setFont(new Font("�ü�ü",Font.BOLD, 30));
      setTimeNumLb = new JLabel("60");
      setTimeNumLb.setFont(new Font("�ü�ü",Font.BOLD, 40));
      setTimeLb.setBounds(20,50,200,150);
      setTimeNumLb.setBounds(70,150,150,150);

      setTimePanel.add(setTimeLb);
      setTimePanel.add(setTimeNumLb);

      exerciseTimeLb = new JLabel("��ð�");
      exerciseTimeLb.setFont(new Font("���� ���",Font.BOLD,20));
      
      exerciseTimeNumLb = new JLabel("0");

      exerciseTimeNumLb.setFont(new Font("���� ���",Font.BOLD,20));

      exerciseTimeLb.setBounds(40,0,80,40);
      exerciseTimeNumLb.setBounds(140,0,80,40);

      exerciseTimePanel.add(exerciseTimeLb);
      exerciseTimePanel.add(exerciseTimeNumLb);
      
      myExerciseListLb = new JLabel("���� � ����Ʈ");

      myExerciseListLb.setFont(new Font("���� ���",Font.PLAIN,20));
      
      
      String[] a = { "���", "�ϷῩ��" };
      String[][] b = {};
      DefaultTableModel model = new DefaultTableModel(b, a);// �𵨰� �����͸� ��������
      // �����͸� �����ؼ� �߰��� ���� �ƴ� ��ũ�ؼ� �߰��� ���̴�.
      // ���� �Ⱦ��ԵǸ� ���θ������Ѵ�.
      myExerciseListList = new JTable(model);            
      myExerciseListList.setRowHeight(30);//�����
      
      myRenderer = new MyRenderer();
  
      myExerciseListList.setDefaultRenderer(Object.class, myRenderer);
      
      myExerciseScrollPane = new JScrollPane(myExerciseListList);
      
      myExerciseListLb.setBounds(70,0,200,30);
      myExerciseScrollPane.setBounds(0,40,300,400);

      
      myListPanel.add(myExerciseListLb);
      myListPanel.add(myExerciseScrollPane);
      
      cntPanel.setBackground(new Color(96,181,220));      
      exerciseTimePanel.setBackground(new Color(96,181,220));      
      timerBtnPanel.setBackground(new Color(96,181,220));      
      myListPanel.setBackground(new Color(96,181,220));      
      setTimePanel.setBackground(new Color(96,181,220));      
      curSetPanel.setBackground(new Color(96,181,220));      
      this.setBackground(new Color(96,181,220));
      
      this.add(cntPanel);
      this.add(exerciseTimePanel);
      this.add(timerBtnPanel);
      this.add(myListPanel);
      this.add(setTimePanel);
      this.add(curSetPanel);
      
      this.setSize(1100,700);
      
      this.setVisible(false);
      

   }
   
   class MyRenderer extends DefaultTableCellRenderer 
   {
       @Override
       public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
       {
           Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
           
               if(table.getValueAt(row, 1).toString().equals("�̿Ϸ�")) {
                   c.setBackground(Color.red);
               }else if(table.getValueAt(row, 1).toString().equals("���")){
                   c.setBackground(Color.yellow);
               }else {
                   c.setBackground(Color.green);
               }

           return c;
       }
   }



   public JPanel getCurSetPanel() {
      return curSetPanel;
   }

   public void setCurSetPanel(JPanel curSetPanel) {
      this.curSetPanel = curSetPanel;
   }

   public JLabel getCurSetCntLb() {
      return curSetCntLb;
   }

   public void setCurSetCntLb(JLabel curSetCntLb) {
      this.curSetCntLb = curSetCntLb;
   }

   public JLabel getCurSetNumLb() {
      return curSetNumLb;
   }

   public void setCurSetNumLb(JLabel curSetNumLb) {
      this.curSetNumLb = curSetNumLb;
   }

   public JPanel getSetTimePanel() {
      return setTimePanel;
   }

   public void setSetTimePanel(JPanel setTimePanel) {
      this.setTimePanel = setTimePanel;
   }

   public JLabel getSetTimeLb() {
      return setTimeLb;
   }

   public void setSetTimeLb(JLabel setTimeLb) {
      this.setTimeLb = setTimeLb;
   }

   public JLabel getSetTimeNumLb() {
      return setTimeNumLb;
   }

   public void setSetTimeNumLb(JLabel setTimeNumLb) {
      this.setTimeNumLb = setTimeNumLb;
   }

   public JScrollPane getMyExerciseScrollPane() {
      return myExerciseScrollPane;
   }

   public void setMyExerciseScrollPane(JScrollPane myExerciseScrollPane) {
      this.myExerciseScrollPane = myExerciseScrollPane;
   }

   public JPanel getCntPanel() {
      return cntPanel;
   }

   public void setCntPanel(JPanel cntPanel) {
      this.cntPanel = cntPanel;
   }

   public JPanel getExerciseTimePanel() {
      return exerciseTimePanel;
   }

   public void setExerciseTimePanel(JPanel exerciseTimePanel) {
      this.exerciseTimePanel = exerciseTimePanel;
   }

   public JPanel getTimerBtnPanel() {
      return timerBtnPanel;
   }

   public void setTimerBtnPanel(JPanel timerBtnPanel) {
      this.timerBtnPanel = timerBtnPanel;
   }

   public JPanel getMyListPanel() {
      return myListPanel;
   }

   public void setMyListPanel(JPanel myListPanel) {
      this.myListPanel = myListPanel;
   }

   public JButton getStartTimerBtn() {
      return startTimerBtn;
   }

   public void setStartTimerBtn(JButton startTimerBtn) {
      this.startTimerBtn = startTimerBtn;
   }

   public JButton getStopTimerBtn() {
      return stopTimerBtn;
   }

   public void setStopTimerBtn(JButton stopTimerBtn) {
      this.stopTimerBtn = stopTimerBtn;
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

   public JLabel getSetNumLb() {
      return setNumLb;
   }

   public void setSetNumLb(JLabel setNumLb) {
      this.setNumLb = setNumLb;
   }

   public JLabel getRepNumLb() {
      return repNumLb;
   }

   public void setRepNumLb(JLabel repNumLb) {
      this.repNumLb = repNumLb;
   }

   public JLabel getExerciseTimeLb() {
      return exerciseTimeLb;
   }

   public void setExerciseTimeLb(JLabel exerciseTimeLb) {
      this.exerciseTimeLb = exerciseTimeLb;
   }

   public JLabel getExerciseTimeNumLb() {
      return exerciseTimeNumLb;
   }

   public void setExerciseTimeNumLb(JLabel exerciseTimeNumLb) {
      this.exerciseTimeNumLb = exerciseTimeNumLb;
   }

   public JLabel getMyExerciseListLb() {
      return myExerciseListLb;
   }

   public void setMyExerciseListLb(JLabel myExerciseListLb) {
      this.myExerciseListLb = myExerciseListLb;
   }

   public JTable getMyExerciseListList() {
      return myExerciseListList;
   }

   public void setMyExerciseListList(JTable myExerciseListList) {
      this.myExerciseListList = myExerciseListList;
   }
}