package Controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
	private ImageIcon mainIcon;
	private Image img;
	private Image img2;
	private ImageIcon mainIcon2;
	private ImageIcon mainIcon3;
	private Image img3;
	private Image img4;
	private ImageIcon mainIcon4;

	private String[] exerciseSelectedLocation = { "images/15분-2.png", "images/30분-2.png", "images/45분-2.png",
			"images/60분-2.png", "images/75분-2.png" };
	private String[] setSelectedLocation = { "images/1세트-2.png", "images/4세트-2.png", "images/6세트-2.png",
			"images/8세트-2.png", "images/10세트-2.png" };
	private String[] repSelectedLocation = { "images/5회-2.png", "images/10회-2.png", "images/15회-2.png",
			"images/20회-2.png", "images/25회-2.png" };
	private String[] str1 = { "images/15분.png", "images/30분.png", "images/45분.png", "images/60분.png",
			"images/75분.png" };
	private String[] str2 = { "images/1세트.png", "images/4세트.png", "images/6세트.png", "images/8세트.png",
			"images/10세트.png" };
	private String[] str3 = { "images/5회.png", "images/10회.png", "images/15회.png", "images/20회.png", "images/25회.png" };

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

	class RepBtnActionListener implements ActionListener { // 횟수 설정 버튼
		int t;

		public void setIndex(int p) {
			t = p;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			myFrame.setRep(Integer.parseInt(myFrame.getpESView().getRepCntBtn()[t].getName().split("회")[0]));
			// myFrame.getpESView().getSetCntBtn()[t].setIcon(defaultIcon);

			mainIcon = new ImageIcon(repSelectedLocation[t]);
			img = mainIcon.getImage();
			img2 = img.getScaledInstance(120, 60, java.awt.Image.SCALE_SMOOTH);
			mainIcon2 = new ImageIcon(img2);
			myFrame.getpESView().getRepCntBtn()[t].setIcon(mainIcon2);

			for (int i = 0; i < 5; i++) {
				if (i != t) {
					mainIcon3 = new ImageIcon(str3[i]);
					img3 = mainIcon3.getImage();
					img4 = img3.getScaledInstance(120, 60, java.awt.Image.SCALE_SMOOTH);
					mainIcon4 = new ImageIcon(img4);
					myFrame.getpESView().getRepCntBtn()[i].setIcon(mainIcon4);
				}
			}

		}
	}

	class SetBtnActionListener implements ActionListener { // 세트수 설정 버튼
		int t;

		public void setIndex(int p) {
			t = p;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			myFrame.setSet(Integer.parseInt(myFrame.getpESView().getSetCntBtn()[t].getName().split("세트")[0]));
			mainIcon = new ImageIcon(setSelectedLocation[t]);
			img = mainIcon.getImage();
			img2 = img.getScaledInstance(120, 60, java.awt.Image.SCALE_SMOOTH);
			mainIcon2 = new ImageIcon(img2);
			myFrame.getpESView().getSetCntBtn()[t].setIcon(mainIcon2);

			for (int i = 0; i < 5; i++) {
				if (i != t) {
					mainIcon3 = new ImageIcon(str2[i]);
					img3 = mainIcon3.getImage();
					img4 = img3.getScaledInstance(120, 60, java.awt.Image.SCALE_SMOOTH);
					mainIcon4 = new ImageIcon(img4);
					myFrame.getpESView().getSetCntBtn()[i].setIcon(mainIcon4);
				}
			}
		}
	}

	class ExerciseBtnActionListener implements ActionListener { // 운동시간 설정 버튼
		int t;

		public void setIndex(int p) {
			t = p;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			myFrame.setTime(Integer.parseInt(myFrame.getpESView().getExerciseTimeBtn()[t].getName().split("분")[0]));
			mainIcon = new ImageIcon(exerciseSelectedLocation[t]);
			img = mainIcon.getImage();
			img2 = img.getScaledInstance(120, 60, java.awt.Image.SCALE_SMOOTH);
			mainIcon2 = new ImageIcon(img2);
			myFrame.getpESView().getExerciseTimeBtn()[t].setIcon(mainIcon2);

			for (int i = 0; i < 5; i++) {
				if (i != t) {
					mainIcon3 = new ImageIcon(str1[i]);
					img3 = mainIcon3.getImage();
					img4 = img3.getScaledInstance(120, 60, java.awt.Image.SCALE_SMOOTH);
					mainIcon4 = new ImageIcon(img4);
					myFrame.getpESView().getExerciseTimeBtn()[i].setIcon(mainIcon4);
				}
			}
		}
	}

	class BtnActionListener implements ActionListener { // 운동시작 버튼 리스너

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == myFrame.getpESView().getStartBtn()) {

				// myExercise 운동항목들을 가져옴
				try {
					result = urlConnection.ServeMyExerciseData(myFrame.id);

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
				if (exerciseJSONArray.length() == 0) {
					JOptionPane.showMessageDialog(myFrame, "운동을 하나라도 추가하고 오십시오!", "에러", JOptionPane.WARNING_MESSAGE);
				} else {
					DefaultTableModel m = (DefaultTableModel) myFrame.geteSView().getMyExerciseListList().getModel();
					m.setRowCount(0);// 초기화
					String[][] b = new String[arrayNo.size()][2];
					for (int i = 0; i < arrayNo.size(); i++) {
						b[i][0] = arrayName.get(i);
						b[i][1] = "미완료";
						m.insertRow(m.getRowCount(), b[i]);
					}

					myFrame.geteSView().getExerciseTimeNumLb().setText("0시 0분 0초");
					myFrame.geteSView().getSetTimeNumLb().setText(Integer.toString(0));
					myFrame.geteSView().getRepNumLb().setText(Integer.toString(myFrame.getRep()));
					myFrame.geteSView().getSetNumLb().setText(Integer.toString(myFrame.getSet()));
					myFrame.geteSView().getCurSetNumLb().setText(Integer.toString(0));

					myFrame.geteSView().getMyExerciseListList().updateUI();

					myFrame.geteSView().setVisible(true);
					myFrame.getpESView().setVisible(false);
				}
			}
		}

	}

}