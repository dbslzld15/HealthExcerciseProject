package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.ExerciseStartController;
import Controller.HealthFrameController;
import Controller.HealthListController;
import Controller.LoginController;
import Controller.MyPageController;
import Controller.PreExerciseStartController;
import Controller.RegisterController;

public class LoginView extends JFrame {
	
	private static LoginController loginController;
	
	private HealthFrame healthFrame;
	private MyPageController mPController;
	private HealthListController hLController;
	private PreExerciseStartController pESController;
	private HealthFrameController hFController;
	private ExerciseStartController eSController;
	private RegisterController rGController;
	private JLabel mainLabel = new JLabel("재활 운동 도우미");
	private Font mainfont = new Font("맑은 고딕", Font.BOLD, 30);
	private ImageIcon mainIcon = new ImageIcon("images/마이페이지초기아이콘.png");
	private Image img = mainIcon.getImage();
	private Image img2 = img.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
	private ImageIcon mainIcon2 = new ImageIcon(img2);
	private JLabel mainIconLabel = new JLabel(mainIcon2); // 이미지 아이콘 크기 조절 후 다시 설정
	private JPanel idPanel = new JPanel();
	private JPanel pwPanel = new JPanel();
	private JPanel btnPanel = new JPanel();
	private JLabel idLabel = new JLabel("Username : ");
	private JLabel pwLabel = new JLabel("Password : ");
	private JTextField idField = new JTextField(12);
	private JPasswordField pwField = new JPasswordField(12);
	private JButton loginBtn = new JButton(new ImageIcon("images/로그인.png"));
	private JButton registerBtn = new JButton(new ImageIcon("images/회원가입.png"));

	LoginView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("재활 도우미 프로그램");
		this.setLayout(new FlowLayout());

		idPanel.add(idLabel);
		idPanel.add(idField);

		pwPanel.add(pwLabel);
		pwPanel.add(pwField);

		idPanel.setBackground(new Color(96, 181, 220));
		pwPanel.setBackground(new Color(96, 181, 220));
		btnPanel.setBackground(new Color(96, 181, 220));

		btnPanel.add(loginBtn);
		btnPanel.add(registerBtn);

		loginBtn.setPreferredSize(new Dimension(80, 40));

		registerBtn.setPreferredSize(new Dimension(80, 40));
		registerBtn.addActionListener(new registerListener());

		mainLabel.setHorizontalAlignment(JLabel.CENTER); // 상단 재활 운동 도우미 가운데 정렬
		mainLabel.setFont(mainfont); // 재활 운동 도우미 폰트 설정
		this.add(mainLabel, BorderLayout.NORTH);
		this.add(mainIconLabel, BorderLayout.CENTER);
		this.add(idPanel);
		this.add(pwPanel);
		this.add(btnPanel);
		this.getContentPane().setBackground(new Color(96, 181, 220));

		this.setVisible(true);
		this.setSize(350, 500);
	}



	public void setLoginController(LoginController controller) {
		this.loginController = controller;
	}

	class registerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			rGController = new RegisterController();

		}

	}

	public static void main(String[] args) {

		loginController = new LoginController(new LoginView());
	}
	
	public JLabel getMainLabel() {
		return mainLabel;
	}

	public void setMainLabel(JLabel mainLabel) {
		this.mainLabel = mainLabel;
	}

	public Font getMainfont() {
		return mainfont;
	}

	public void setMainfont(Font mainfont) {
		this.mainfont = mainfont;
	}

	public ImageIcon getMainIcon() {
		return mainIcon;
	}

	public void setMainIcon(ImageIcon mainIcon) {
		this.mainIcon = mainIcon;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public Image getImg2() {
		return img2;
	}

	public void setImg2(Image img2) {
		this.img2 = img2;
	}

	public ImageIcon getMainIcon2() {
		return mainIcon2;
	}

	public void setMainIcon2(ImageIcon mainIcon2) {
		this.mainIcon2 = mainIcon2;
	}

	public JLabel getMainIconLabel() {
		return mainIconLabel;
	}

	public void setMainIconLabel(JLabel mainIconLabel) {
		this.mainIconLabel = mainIconLabel;
	}

	public JPanel getIdPanel() {
		return idPanel;
	}

	public void setIdPanel(JPanel idPanel) {
		this.idPanel = idPanel;
	}

	public JPanel getPwPanel() {
		return pwPanel;
	}

	public void setPwPanel(JPanel pwPanel) {
		this.pwPanel = pwPanel;
	}

	public JPanel getBtnPanel() {
		return btnPanel;
	}

	public void setBtnPanel(JPanel btnPanel) {
		this.btnPanel = btnPanel;
	}

	public JLabel getIdLabel() {
		return idLabel;
	}

	public void setIdLabel(JLabel idLabel) {
		this.idLabel = idLabel;
	}

	public JLabel getPwLabel() {
		return pwLabel;
	}

	public void setPwLabel(JLabel pwLabel) {
		this.pwLabel = pwLabel;
	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JPasswordField getPwField() {
		return pwField;
	}

	public void setPwField(JPasswordField pwField) {
		this.pwField = pwField;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(JButton loginBtn) {
		this.loginBtn = loginBtn;
	}

	public JButton getRegisterBtn() {
		return registerBtn;
	}

	public void setRegisterBtn(JButton registerBtn) {
		this.registerBtn = registerBtn;
	}
}
