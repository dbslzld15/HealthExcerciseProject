package Controller;

import java.awt.event.*;
import View.RegisterFrame;

public class RegisterController {

	private RegisterFrame registerFrame;
	private String id;
	private String pw;
	
	public RegisterController(){
		registerFrame = new RegisterFrame();
		registerFrame.getJoinButton().addActionListener(new joinListener());
		registerFrame.getCancelButton().addActionListener(new cancelListener());
	}
	
	class joinListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			id = registerFrame.getIdField().getText();
			pw="";
			char[] secret_pw = registerFrame.getPwField().getPassword();
			for(char cha : secret_pw)
			{
				Character.toString(cha);
				pw+= cha;
			}
			
			
			
			registerFrame.getIdField().setText("");
			registerFrame.getPwField().setText("");
		}
		
	}
	
	class cancelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			registerFrame.dispose();
		}
		
	}
	
}
