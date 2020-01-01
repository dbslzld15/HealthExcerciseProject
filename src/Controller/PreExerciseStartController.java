package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import View.ExerciseStartView;
import View.HealthFrame;

public class PreExerciseStartController {
   private HealthFrame myFrame;
   private ExerciseStartView eSView;
   private RequestHttpURLConnection urlConnection;
   private String result;
   private JSONArray exerciseJSONArray;
   private ArrayList<String> arrayNo;
   private ArrayList<String> arrayName;
   private RepBtnActionListener[] repListener;
   private SetBtnActionListener[] setListener;
   private ExerciseBtnActionListener[] exerciseListener;

   public PreExerciseStartController(HealthFrame myFrame) {
      this.myFrame = myFrame;
      arrayNo = new ArrayList<String>();
      arrayName = new ArrayList<String>();
      urlConnection = new RequestHttpURLConnection();
      myFrame.setPreExerciseStartController(this);
      myFrame.getpESView().getStartBtn().addActionListener(new BtnActionListener());
      repListener = new RepBtnActionListener[5];
      setListener = new SetBtnActionListener[5];
      exerciseListener = new ExerciseBtnActionListener[5];

      for (int i = 0; i < 5; i++) {
         repListener[i] = new RepBtnActionListener();
         repListener[i].setIndex(i);
         setListener[i] = new SetBtnActionListener();
         setListener[i].setIndex(i);
         exerciseListener[i] = new ExerciseBtnActionListener();
         exerciseListener[i].setIndex(i);

         myFrame.getpESView().getRepCntBtn()[i].addActionListener(repListener[i]);
         myFrame.getpESView().getSetCntBtn()[i].addActionListener(setListener[i]);
         myFrame.getpESView().getExerciseTimeBtn()[i].addActionListener(exerciseListener[i]);

      }
   }

   class RepBtnActionListener implements ActionListener { // Ƚ�� ���� ��ư
      int t;

      public void setIndex(int p) {
         t = p;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         myFrame.setRep(Integer.parseInt(myFrame.getpESView().getRepCntBtn()[t].getText().split("ȸ")[0]));

      }
   }

   class SetBtnActionListener implements ActionListener { // ��Ʈ�� ���� ��ư
      int t;

      public void setIndex(int p) {
         t = p;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub

         myFrame.setSet(Integer.parseInt(myFrame.getpESView().getSetCntBtn()[t].getText().split("��Ʈ")[0]));

      }
   }

   class ExerciseBtnActionListener implements ActionListener { // ��ð� ���� ��ư
      int t;

      public void setIndex(int p) {
         t = p;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         myFrame.setTime(Integer.parseInt(myFrame.getpESView().getExerciseTimeBtn()[t].getText().split("��")[0]));

      }
   }

   class BtnActionListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub

         if (e.getSource() == myFrame.getpESView().getStartBtn()) {
      
            // myExercise ��׸���� ������
            try {
               result = urlConnection.ServeMyExerciseData();

               if (result != "") {
                  try {
                     exerciseJSONArray = new JSONArray(result);
                  } catch (JSONException exception) {
                     // TODO Auto-generated catch block
                     exception.printStackTrace();
                  }
                  arrayNo.clear();
                  arrayName.clear();
                  for (int i = 0; i <= exerciseJSONArray.length() - 1; i++) {
                     try {
                        JSONObject jsonObject = exerciseJSONArray.getJSONObject(i);
                        // Pulling items from the array
                        arrayNo.add(jsonObject.getString("no"));
                        arrayName.add(jsonObject.getString("name"));

                     } catch (JSONException exception) {
                        exception.printStackTrace();
                     }
                  }
               }
            } catch (JSONException exception) {
               // TODO Auto-generated catch block
               exception.printStackTrace();
            }
            DefaultTableModel m = (DefaultTableModel) myFrame.geteSView().getMyExerciseListList().getModel();
            m.setRowCount(0);// �ʱ�ȭ
            String[][] b = new String[arrayNo.size()][2];
            for (int i = 0; i < arrayNo.size(); i++) {
               b[i][0] = arrayName.get(i);
               b[i][1] = "�̿Ϸ�";
               m.insertRow(m.getRowCount(), b[i]);
            }
            
            myFrame.geteSView().getRepNumLb().setText(Integer.toString(myFrame.getRep()));
            myFrame.geteSView().getSetNumLb().setText(Integer.toString(myFrame.getSet()));

            myFrame.geteSView().getMyExerciseListList().updateUI();

            myFrame.geteSView().setVisible(true);
            myFrame.getpESView().setVisible(false);
         }
      }

   }

}