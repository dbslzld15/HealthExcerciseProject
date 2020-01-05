package Controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import View.HealthFrame;

public class HealthFrameController {
	private HealthFrame myFrame;
	private RequestHttpURLConnection urlConnection;
	private String result;
	private JSONArray exerciseJSONArray;
	private ArrayList<String> arrayNo;
	private ArrayList<String> arrayName;
	private ArrayList<String> arrayKind;
	private ArrayList<String> arrayKindDetail;

	public HealthFrameController(HealthFrame myFrame) {
		this.myFrame = myFrame;
		myFrame.setHealthFrameController(this);
		urlConnection = new RequestHttpURLConnection();
		arrayNo = new ArrayList<String>();
		arrayName = new ArrayList<String>();
		arrayKind = new ArrayList<String>();
		arrayKindDetail = new ArrayList<String>();

	}

	public void healthBtnFunc() {
		if (myFrame.geteSController().stop == false) {
			int result = JOptionPane.showConfirmDialog(myFrame, "근손실.. 감당되시겠습니까? ", "운동중입니다!!!!",
					JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.YES_OPTION) {
				myFrame.geteSController().stop = true;
				myFrame.gethLView().setVisible(true);
				myFrame.getpESView().setVisible(false);
				myFrame.geteSView().setVisible(false);
				myFrame.getmPView().setVisible(false);
			} else {

			}
		}
		else {
			myFrame.gethLView().setVisible(true);
			myFrame.getpESView().setVisible(false);
			myFrame.geteSView().setVisible(false);
			myFrame.getmPView().setVisible(false);
		}

	}

	public void myPageBtnFunc() {
		if (myFrame.geteSController().stop == false) {
			int result = JOptionPane.showConfirmDialog(myFrame, "근손실.. 감당되시겠습니까? ", "운동중입니다!!!!",
					JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.YES_OPTION) {
				myFrame.geteSController().stop = true;
				myFrame.geteSController().setCurExercise(0);

				myFrame.getmPController().printMyExerciseList();
				myFrame.getmPController().printDayAndTime();
				myFrame.getmPView().setVisible(true);
				myFrame.geteSView().setVisible(false);
				myFrame.getpESView().setVisible(false);
				myFrame.gethLView().setVisible(false);
			} else {

			}
		}
		else {
			myFrame.getmPController().printMyExerciseList();
			myFrame.getmPController().printDayAndTime();
			myFrame.getmPView().setVisible(true);
			myFrame.geteSView().setVisible(false);
			myFrame.getpESView().setVisible(false);
			myFrame.gethLView().setVisible(false);
		}
	}

	public void startBtnFunc() {
		if (myFrame.geteSController().stop == false) {
			int result = JOptionPane.showConfirmDialog(myFrame, "근손실.. 감당되시겠습니까? ", "운동중입니다!!!!",
					JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.YES_OPTION) {
				myFrame.geteSController().stop = true;
				myFrame.geteSController().setCurExercise(0);
				
				myFrame.geteSView().setVisible(false);
				myFrame.getpESView().setVisible(true);
				myFrame.gethLView().setVisible(false);
				myFrame.getmPView().setVisible(false);
			} else {

			}
		}
		else {
			myFrame.geteSController().stop = true;
			myFrame.geteSController().setCurExercise(0);

			myFrame.geteSView().setVisible(false);
			myFrame.getpESView().setVisible(true);
			myFrame.gethLView().setVisible(false);
			myFrame.getmPView().setVisible(false);
		}

	}

}
