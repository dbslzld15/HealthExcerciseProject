package Controller;

import java.util.ArrayList;

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
		myFrame.gethLView().setVisible(true);
		myFrame.getpESView().setVisible(false);
		myFrame.geteSView().setVisible(false);
		myFrame.getmPView().setVisible(false);
	}
	public void myPageBtnFunc() {
		myFrame.getmPController().printMyExerciseList();
		myFrame.getmPView().setVisible(true);
		myFrame.geteSView().setVisible(false);
		myFrame.getpESView().setVisible(false);
		myFrame.gethLView().setVisible(false);
	}
	public void startBtnFunc() {
		/*try {
			result = urlConnection.ServeExerciseData();

			if (result != "") {
                try {
                    exerciseJSONArray = new JSONArray(result);
                } catch (JSONException e) {
                    //TODO Auto-generated catch block
                    e.printStackTrace();
                }

                for (int i = exerciseJSONArray.length() - 1; i >= 0; i--) {
                    try {
                        JSONObject jsonObject = exerciseJSONArray.getJSONObject(i);
                        // Pulling items from the array
                        arrayNo.add(jsonObject.getString("no"));
                        arrayName.add(jsonObject.getString("name"));
                        //arrayDetail.add(jsonObject.getString("detail"));
                        arrayKind.add(jsonObject.getString("kind"));
                        arrayKindDetail.add(jsonObject.getString("kind_detail"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		myFrame.geteSView().setVisible(false);
		myFrame.getpESView().setVisible(true);
		myFrame.gethLView().setVisible(false);
		myFrame.getmPView().setVisible(false);

	}


}
