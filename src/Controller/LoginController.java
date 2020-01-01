package Controller;

import javax.swing.JFrame;

import org.json.simple.JSONObject;

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
		
		loginObject.put("user_id", id);
		loginObject.put("user_pw", pw);
		loginObject.put("check", check);
		
		urlConnection = new RequestHttpURLConnection();
		check = urlConnection.checkLogin(loginObject);
		System.out.println("check " + check);
		
		return check;
	}
	
	
}
