package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.JSONException;
import org.json.JSONObject;

import View.RegisterFrame;

public class RegisterController {
	private RequestHttpURLConnection urlConnection;
	private RegisterFrame registerFrame;
	private String id;
	private String pw;

	public RegisterController() {
		registerFrame = new RegisterFrame();
		registerFrame.getJoinButton().addActionListener(new joinListener());
		registerFrame.getCancelButton().addActionListener(new cancelListener());
		urlConnection = new RequestHttpURLConnection();
	}

	class joinListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			id = registerFrame.getIdField().getText();
			pw = new String(registerFrame.getPwField().getPassword());
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
			String result = urlConnection.registUser(user_data.toString());
			
			if(result.contains("success"))
			{
				registerFrame.getIdField().setText("");
				registerFrame.getPwField().setText("");
				registerFrame.dispose();
			}
			else {
				registerFrame.getIdField().setText("");
				registerFrame.getPwField().setText("");
			}
			
		}

	}

	class cancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			registerFrame.dispose();
		}

	}

}
