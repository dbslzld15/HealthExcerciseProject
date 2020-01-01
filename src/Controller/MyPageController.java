package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

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
	
	public MyPageController(HealthFrame myFrame) {
		this.myFrame = myFrame;
		arrayNo = new ArrayList<String>();
		arrayName = new ArrayList<String>();
		urlConnection = new RequestHttpURLConnection();
		myFrame.setMyPageController(this);
		printMyExerciseList();
		myFrame.getmPView().getDeleteButton().addActionListener(new BtnActionListener());
		
		tmpTable = myFrame.getmPView().getMyExerciseListList();
//		myFrame.getmPView().getMyExerciseListList().addMouseListener((MouseListener) new MouseActionListener());
		System.out.println("mypagecontroller 1");
		model = (DefaultTableModel) tmpTable.getModel();
	 
	}

	class BtnActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == myFrame.getmPView().getDeleteButton()) {
				try {
					row = tmpTable.getSelectedRow();
					System.out.println("row11 " + row);
					if(row < 0) return ;
					DefaultTableModel model = (DefaultTableModel) tmpTable.getModel(); 
					
					urlConnection.deleteMyExerciseData((String) model.getValueAt(row, 0)); 
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
			result = urlConnection.ServeMyExerciseData();
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
		m.setRowCount(0);// ÃÊ±âÈ­
		
		String[][] b = new String[arrayNo.size()][1];
		for (int i = 0; i < arrayNo.size(); i++) {
			b[i][0] = arrayName.get(i);
			m.insertRow(m.getRowCount(),b[i]);
		}
		myFrame.getmPView().getMyExerciseListList().updateUI();
		System.out.println("myexerciseList 3");

	}
	
}

