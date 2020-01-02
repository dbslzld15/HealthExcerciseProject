package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import View.HealthFrame;

public class MyPageController {
   private HealthFrame myFrame;
   private RequestHttpURLConnection urlConnection;
   private String result;

   private JTable tmpTable;

   private JSONArray exerciseJSONArray;
   private ArrayList<String> arrayNo;
   private ArrayList<String> arrayName;

   private int row, column;

   private DefaultTableModel model;

   private JLabel dayLabel, timeLabel;
   private JSONObject totalJsonObject;
   String day, time;

   public MyPageController(HealthFrame myFrame) {
      this.myFrame = myFrame;
      arrayNo = new ArrayList<String>();
      arrayName = new ArrayList<String>();
      urlConnection = new RequestHttpURLConnection();
      myFrame.setMyPageController(this);

      printMyExerciseList();
      printDayAndTime();

      myFrame.getmPView().getDeleteButton().addActionListener(new BtnActionListener());

      tmpTable = myFrame.getmPView().getMyExerciseListList();
      model = (DefaultTableModel) tmpTable.getModel();
      
      day = "00"; time = "00";

   }

   class BtnActionListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         if (e.getSource() == myFrame.getmPView().getDeleteButton()) {
            try {
               row = tmpTable.getSelectedRow();
               System.out.println("row11 " + row);
               if (row < 0)
                  return;
               DefaultTableModel model = (DefaultTableModel) tmpTable.getModel();

               urlConnection.deleteMyExerciseData((String) model.getValueAt(row, 0));
               model.removeRow(row);

               printMyExerciseList();
            } catch (JSONException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
         }
      }
   }

   public void printMyExerciseList() {
      try {
         result = urlConnection.ServeMyExerciseData();
      } catch (JSONException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      if (result != "") {
         try {
            exerciseJSONArray = new JSONArray(result);
         } catch (JSONException exception) {
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

      DefaultTableModel m = (DefaultTableModel) myFrame.getmPView().getMyExerciseListList().getModel();
      m.setRowCount(0);// ÃÊ±âÈ­

      String[][] b = new String[arrayNo.size()][1];
      for (int i = 0; i < arrayNo.size(); i++) {
         b[i][0] = arrayName.get(i);
         m.insertRow(m.getRowCount(), b[i]);
      }
      myFrame.getmPView().getMyExerciseListList().updateUI();
   }

   public void printDayAndTime() {
      
      result = urlConnection.updateDayAndTime();         
      if(result != "") {
         try {
            JSONObject totalJsonObject = new JSONObject(result); 
            day = (String) totalJsonObject.get("user_total_day");
            time = (String) totalJsonObject.get("user_total_time");
         } catch(JSONException exception) {
            exception.printStackTrace();
         }
      }
      myFrame.getmPView().init(day, time);
   }

}