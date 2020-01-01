package Controller;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginController {
	String id;
	String pw;
	
	String check_id;
	String check_pw;
	
	RequestHttpURLConnection urlConnection;
	JSONObject loginObject = new JSONObject();

	boolean check;
	
	public LoginController(String id, String pw) {
		this.id = id;
		this.pw = pw;
		check = false;
	}
	
	public boolean checkID() {
		
		try {
			loginObject.put("user_id", id);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			loginObject.put("user_pw", pw);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			loginObject.put("check", check);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		urlConnection = new RequestHttpURLConnection();
		check = urlConnection.checkLogin(loginObject);
		System.out.println("check " + check);
		
		return check;
	}
	
	
}
