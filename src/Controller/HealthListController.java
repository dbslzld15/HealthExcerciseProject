package Controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import View.HealthFrame;

public class HealthListController {

   private HealthFrame myFrame;

   private RequestHttpURLConnection urlConnection;
   private String additem = "12323121";
   private JSONArray exerciseJSONArray;
   private ArrayList<String> arrayNo;
   private ArrayList<String> arrayName;
   private ArrayList<String> arrayDetail;
   private ArrayList<String> arrayKind;
   private ArrayList<String> arrayKindDetail;
   private String result;
   private DefaultListModel addModel;
   private String selectedString;
   private ActionListener FirstBoxItemListener;
   private ActionListener SecondBoxActionListener;
   private ActionListener InButtonActionListener;
   private ActionListener ExButtonActionListener;
   private ArrayList<JButton> arrayBtn;
 
  
   public HealthListController(HealthFrame myFrame) {
      this.myFrame = myFrame;
      myFrame.setHealthListController(this);
      addHeathListListener();
      urlConnection = new RequestHttpURLConnection();
      arrayNo = new ArrayList<String>();
      arrayName = new ArrayList<String>();
      arrayDetail = new ArrayList<String>();
      arrayKind = new ArrayList<String>();
      arrayKindDetail = new ArrayList<String>();
      arrayBtn = new ArrayList<JButton>();
   }

   public void addHeathListListener() {
      myFrame.gethLView().getFirstBox().addItemListener(new FirstBoxItemListener());
      myFrame.gethLView().getInButton().addActionListener(new InButtonActionListener());
      myFrame.gethLView().getRegisterButton().addActionListener(new RegisterActionListener());

   }

   class RegisterActionListener implements ActionListener { // ��� ��ư Ŭ����

      @Override
      public void actionPerformed(ActionEvent e) {

//          myFrame.getmPView().getMyExerciseListList().addElement(additem);
      }
   }

   class pictureBtnListener implements ActionListener { // ��׸� ��ư Ŭ����
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub

         JButton btn = (JButton) e.getSource();
         additem = "��ư�� �������ִ� �����̸� btn.�޼ҵ� Ȱ�� ����";
         myFrame.gethLView().getExplainArea().setText("db�� �ִ� � �� ���� ������ ����");
      }

   }

   class FirstBoxItemListener implements ItemListener { // ù��° �޺��ڽ� ������

      @Override
      public void itemStateChanged(ItemEvent e) {
         // TODO Auto-generated method stub

         ArrayList<String> array = new ArrayList<>();
         Iterator<String> iter;
         if (myFrame.gethLView().getFirstBox().getSelectedItem().equals("��ü����")) {
            myFrame.gethLView().getSecondBox().removeAllItems();
            array.add("��ü����");
            iter = array.iterator();
            while (iter.hasNext()) {
               myFrame.gethLView().getSecondBox().addItem(iter.next());
            }

         } else if (myFrame.gethLView().getFirstBox().getSelectedItem().equals("���")) {
            myFrame.gethLView().getSecondBox().removeAllItems();
            array.add("��ü����");
            array.add("���� �ﰢ��");
            array.add("�ĸ� �ﰢ��");
            array.add("���� �ﰢ��");
            iter = array.iterator();
            while (iter.hasNext()) {
               myFrame.gethLView().getSecondBox().addItem(iter.next());
            }

         } else if (myFrame.gethLView().getFirstBox().getSelectedItem().equals("����")) {
            myFrame.gethLView().getSecondBox().removeAllItems();
            array.add("��ü����");
            array.add("�����δ�");
            array.add("����");
            array.add("���� �δ�");
            iter = array.iterator();
            while (iter.hasNext()) {
               myFrame.gethLView().getSecondBox().addItem(iter.next());
            }

         } else if (myFrame.gethLView().getFirstBox().getSelectedItem().equals("�㸮")) {
            myFrame.gethLView().getSecondBox().removeAllItems();
            array.add("��ü����");
            array.add("�㸮 ������");
            array.add("��ũ");
            array.add("����");
            iter = array.iterator();
            while (iter.hasNext()) {
               myFrame.gethLView().getSecondBox().addItem(iter.next());
            }

         }

      }

   }

   class InButtonActionListener implements ActionListener { // �Է� ��ư �����ÿ�

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub

         try {
            result = urlConnection.ServeExerciseData();
            if (result != "") {
               try {
                  exerciseJSONArray = new JSONArray(result);
               } catch (JSONException e1) {
                  // TODO Auto-generated catch block
                  e1.printStackTrace();
               }
               arrayNo.clear();
               arrayName.clear();
               arrayDetail.clear();
               arrayKind.clear();
               arrayKindDetail.clear();

               for (int i = 0; i <= exerciseJSONArray.length() - 1; i++) {
                  try {
                     JSONObject jsonObject = exerciseJSONArray.getJSONObject(i);
                     // Pulling items from the array
                     arrayNo.add(jsonObject.getString("no"));
                     arrayName.add(jsonObject.getString("name"));
                     arrayDetail.add(jsonObject.getString("detail"));
                     arrayKind.add(jsonObject.getString("kind"));
                     arrayKindDetail.add(jsonObject.getString("kind_detail"));

                  } catch (JSONException e1) {
                     e1.printStackTrace();
                  }
               }
            }
         } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }

         category(myFrame.gethLView().getFirstBox().getSelectedIndex(),
               myFrame.gethLView().getSecondBox().getSelectedIndex());

      }

   }

   public void category(int kind, int kindDetail) {
      
      String findKind = "";
      int BtnCnt=0;
      findKind = Character.toString((char) (kind + 64));//A,B,C
      arrayBtn.clear();
      
      myFrame.gethLView().getWestPanel().removeAll();

      DetailListener[] listeners = new DetailListener[arrayNo.size()];
  
      for (int i = 0; i < arrayNo.size(); i++) {
         listeners[i] = new DetailListener();
         listeners[i].setIndex(i);
         if (arrayKind.get(i).contains(findKind)) {
            if (kindDetail == 0) {
               arrayBtn.add(new JButton());
               arrayBtn.get(BtnCnt).setPreferredSize(new Dimension(200, 160));
               arrayBtn.get(BtnCnt).setText(arrayName.get(i));
               arrayBtn.get(BtnCnt).addActionListener(listeners[i]);
               myFrame.gethLView().getWestPanel().add(arrayBtn.get(BtnCnt));
               BtnCnt++;
            } else if (arrayKindDetail.get(i).charAt(kindDetail - 1) == '1') {
     
               arrayBtn.add(new JButton());
               arrayBtn.get(BtnCnt).setPreferredSize(new Dimension(200, 160));
               arrayBtn.get(BtnCnt).setText(arrayName.get(i));
               arrayBtn.get(BtnCnt).addActionListener(listeners[i]);                     
               myFrame.gethLView().getWestPanel().add(arrayBtn.get(BtnCnt));
               BtnCnt++;
            }

         } 
         else if(findKind.contains("@")){ // ��з� ��ü ����
            arrayBtn.add(new JButton());
            arrayBtn.get(BtnCnt).setPreferredSize(new Dimension(200, 160));

            arrayBtn.get(BtnCnt).addActionListener(listeners[i]);
            myFrame.gethLView().getWestPanel().add(arrayBtn.get(BtnCnt));
            arrayBtn.get(BtnCnt).setText(arrayName.get(i));
            BtnCnt++;
         }
         
      }
    
      myFrame.gethLView().getWestPanel().revalidate();
      myFrame.gethLView().getWestPanel().repaint();


      if(BtnCnt<=3) //ù��° �ٸ� �ʿ�
      {
         myFrame.gethLView().getBtnScroll().setBounds(0, 80, 699, 167);
      }
      else if(BtnCnt<=6) //�ι�° �ٱ��� �ʿ�
      {    
         myFrame.gethLView().getBtnScroll().setBounds(0, 80, 699, 334);
      }
      else  //3��° �� �̻�
      {
         myFrame.gethLView().getBtnScroll().setBounds(0, 80, 699, 501);    
      }

   }
   class DetailListener implements ActionListener{
       int t;
       public void setIndex(int p)
       {
          t = p;
       }
       
       @Override
       public void actionPerformed(ActionEvent e) {
          myFrame.gethLView().getExplainArea().setText(arrayDetail.get(t));
       }
       
    }
   
   
      
   
}