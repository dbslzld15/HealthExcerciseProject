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

	public PreExerciseStartController(HealthFrame myFrame) {
		this.myFrame = myFrame;
		arrayNo = new ArrayList<String>();
		arrayName = new ArrayList<String>();
		urlConnection = new RequestHttpURLConnection();
		myFrame.setPreExerciseStartController(this);
		myFrame.getpESView().getStartBtn().addActionListener(new BtnActionListener());
	}

	class BtnActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == myFrame.getpESView().getStartBtn()) {
				// myExercise 운동항목들을 가져옴
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
				m.setRowCount(0);// 초기화
				String[][] b = new String[arrayNo.size()][2];
				for (int i = 0; i < arrayNo.size(); i++) {
					b[i][0] = arrayName.get(i);
					b[i][1] = "미완료";
					m.insertRow(m.getRowCount(), b[i]);
				}

				myFrame.geteSView().getMyExerciseListList().updateUI();

				myFrame.geteSView().setVisible(true);
				myFrame.getpESView().setVisible(false);
			}
		}

	}

}
