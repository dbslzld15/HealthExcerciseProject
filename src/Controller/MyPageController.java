package Controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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
   private ArrayList<String> arrayDetail;
   private ArrayList<String> arrayKind;
   private ArrayList<String> arrayKindDetail;
   private ArrayList<String> imgLocation;
   
   private JSONObject totalJsonObject;	
   
   private int row, column;
   private String day,time;
   private DefaultTableModel model;
   
   public MyPageController(HealthFrame myFrame) {
      this.myFrame = myFrame;
      arrayNo = new ArrayList<String>();
      arrayName = new ArrayList<String>();
      arrayDetail = new ArrayList<String>();
      arrayKind =new ArrayList<String>();
      arrayKindDetail= new ArrayList<String>();
      imgLocation =new ArrayList<String>();
      
      urlConnection = new RequestHttpURLConnection();
      myFrame.setMyPageController(this);
      printDayAndTime();

      myFrame.getmPView().getDeleteButton().addActionListener(new BtnActionListener());
      
      tmpTable = myFrame.getmPView().getMyExerciseListList();
      myFrame.getmPView().getMyExerciseListList().setFocusable(true);
      myFrame.getmPView().getMyExerciseListList().addMouseListener(new tableMouseAdapter());
      System.out.println("mypagecontroller 1");
      model = (DefaultTableModel) tmpTable.getModel();
    
   }

   class tableMouseAdapter extends MouseAdapter{

	   @Override
	   public void mouseClicked(MouseEvent e) {
	      // TODO Auto-generated method stub
	      int index = myFrame.getmPView().getMyExerciseListList().getSelectedRow();
	      String name = (String) myFrame.getmPView().getMyExerciseListList().getModel().getValueAt(index, 0);
	      String setLocation="";
	   
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
	            imgLocation.clear();
	            for (int i = 0; i <= exerciseJSONArray.length() - 1; i++) {
	               try {
	                  JSONObject jsonObject = exerciseJSONArray.getJSONObject(i);
	                  // Pulling items from the array
	                  arrayNo.add(jsonObject.getString("no"));
	                  arrayName.add(jsonObject.getString("name"));
	                  arrayDetail.add(jsonObject.getString("detail"));
	                  arrayKind.add(jsonObject.getString("kind"));
	                  arrayKindDetail.add(jsonObject.getString("kind_detail"));
	                  imgLocation.add(jsonObject.getString("img_location"));
	                  if(arrayName.get(i).equals(name))
	                  {
	                     setLocation=imgLocation.get(i);
	                  }

	               } catch (JSONException e1) {
	                  e1.printStackTrace();
	               }
	            }
	         }
	      } catch (JSONException e1) {
	         // TODO Auto-generated catch block
	         e1.printStackTrace();
	      }
	      
	      ImageIcon mainIcon = new ImageIcon(setLocation);
	       Image img = mainIcon.getImage();
	       Image img2 = img.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
	       ImageIcon mainIcon2 = new ImageIcon(img2);
	       
	      myFrame.getmPView().getMainIconLabel().setIcon(mainIcon2);
	      
	      
	   }

	   
	      
	  }
   
   class BtnActionListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         if (e.getSource() == myFrame.getmPView().getDeleteButton()) { //삭제 버튼 
            try {
               row = tmpTable.getSelectedRow();
               System.out.println("row11 " + row);
               if(row < 0) return ;
               DefaultTableModel model = (DefaultTableModel) tmpTable.getModel(); 
               JSONObject jsonObject = new JSONObject();
               jsonObject.put("user_id", myFrame.id);
               jsonObject.put("health_name", (String) model.getValueAt(row, 0));
               urlConnection.deleteMyExerciseData(jsonObject); 
               model.removeRow(row);

               printMyExerciseList();
               System.out.println("mypagecontroller 2");
            } catch (JSONException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
               System.out.println("btnListner delete");
            }
         }
      }
   }
   
   public void printMyExerciseList() {
      try {
         result = urlConnection.ServeMyExerciseData(myFrame.id);
      } catch (JSONException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println(result);
      if(result != "") {
         try {
            exerciseJSONArray = new JSONArray(result); 
         } catch(JSONException exception) {
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
            } catch(JSONException exception) {
               exception.printStackTrace();
               System.out.println("myexerciseList 2");
            }
         }
      }
   
      DefaultTableModel m = (DefaultTableModel) myFrame.getmPView().getMyExerciseListList().getModel();
      m.setRowCount(0);// 초기화
      
      String[][] b = new String[arrayNo.size()][1];
      for (int i = 0; i < arrayNo.size(); i++) {
         b[i][0] = arrayName.get(i);
         m.insertRow(m.getRowCount(),b[i]);
      }
      myFrame.getmPView().getMyExerciseListList().updateUI();
      System.out.println("myexerciseList 3");

   }
   



   public void printDayAndTime() {
      
      result = urlConnection.updateDayAndTime(myFrame.id);         
      if(result != "") {
         try {
            JSONObject totalJsonObject = new JSONObject(result); 
            day = (String) totalJsonObject.get("user_total_day");
            time = (String) totalJsonObject.get("user_total_time");
         } catch(JSONException exception) {
            exception.printStackTrace();
         }
      }
      myFrame.getmPView().getTotalDaysCntLabel().setText(day+"일");
      int secs,sec,min,hour;
      secs=Integer.parseInt(time);
      sec=secs%60;
      min=secs/60 %60;
      hour = secs/3600;
      
      myFrame.getmPView().getTotalTimeCntLabel().setText(hour+"시 "+min+"분 "+sec+"초");

   }

}