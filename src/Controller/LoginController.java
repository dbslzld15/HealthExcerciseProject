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
				JOptionPane.showMessageDialog(null, "���̵� �������� �ʰų� ��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.", "����",
						JOptionPane.WARNING_MESSAGE);

				loginFrame.getIdField().setText("");
				loginFrame.getPwField().setText("");
			}
			else {
				JOptionPane.showMessageDialog(null, "������ ������� �ʾҽ��ϴ� ", "����",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}
}
