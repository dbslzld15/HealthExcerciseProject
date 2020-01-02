package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.json.JSONException;
import org.json.JSONObject;

import View.HealthFrame;
import View.LoginView;

public class LoginController {

	private HealthFrame healthFrame;
	private MyPageController mPController;
	private HealthListController hLController;
	private PreExerciseStartController pESController;
	private HealthFrameController hFController;
	private ExerciseStartController eSController;
	private RegisterController rGController;

	String id;
	String pw;
	LoginView loginFrame;
	String check_id;
	String check_pw;

	RequestHttpURLConnection urlConnection;
	JSONObject loginObject = new JSONObject();

	boolean check;

	public LoginController(LoginView loginFrame) {
		this.loginFrame = loginFrame;
		urlConnection = new RequestHttpURLConnection();
		loginFrame.getLoginBtn().addActionListener(new LoginListener());
	}

	class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			id = loginFrame.getIdField().getText();
			pw = new String(loginFrame.getPwField().getPassword());
			JSONObject user_data = new JSONObject();
			try {
				user_data.put("user_id", id);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				user_data.put("user_pw", pw);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String result = urlConnection.loginUser(user_data.toString());

			if (result.contains("success")) {
				loginFrame.dispose();
				healthFrame = new HealthFrame();
				healthFrame.id= id;
				mPController = new MyPageController(healthFrame);
				hLController = new HealthListController(healthFrame);
				hFController = new HealthFrameController(healthFrame);
				eSController = new ExerciseStartController(healthFrame);
				pESController = new PreExerciseStartController(healthFrame);
			} else if(result.contains("NOTFOUND")){
				JOptionPane.showMessageDialog(null, "아이디가 존재하지 않거나 비밀번호를 잘못 입력하셨습니다.", "에러",
						JOptionPane.WARNING_MESSAGE);

				loginFrame.getIdField().setText("");
				loginFrame.getPwField().setText("");
			}
			else {
				JOptionPane.showMessageDialog(null, "서버가 연결되지 않았습니다 ", "에러",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}
}
