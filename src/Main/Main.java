package Main;
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
import Controller.PreExerciseStartController;
import View.HealthFrame;


public class Main extends JFrame{
	
	private HealthFrame healthFrame;
	
	private HealthListController hLController;
	private PreExerciseStartController pESController;
	private HealthFrameController hFController;
	private ExerciseStartController eSController;
	
	private JLabel mainLabel = new JLabel("재활 운동 도우미");
	private Font mainfont = new Font("맑은 고딕",Font.BOLD,30);
	
	private ImageIcon mainIcon = new ImageIcon("images/main.jpg");
	private Image img = mainIcon.getImage();
	private Image img2 = img.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
	private ImageIcon mainIcon2 = new ImageIcon(img2);
	private JLabel mainIconLabel = new JLabel(mainIcon2); //이미지 아이콘 크기 조절 후 다시 설정
	
	private JPanel idPanel = new JPanel();
	private JPanel pwPanel = new JPanel();
	private JPanel btnPanel = new JPanel();
	private JLabel idLabel = new JLabel("Username : ");
	private JLabel pwLabel = new JLabel("Password : ");
	
	private JTextField idField = new JTextField(12);
	private JPasswordField pwField = new JPasswordField(12);
	private JButton loginBtn = new JButton(new ImageIcon("images/로그인.png"));
	private JButton registerBtn = new JButton(new ImageIcon("images/회원가입.png"));
	
	Main()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("재활 도우미 프로그램");
		this.setLayout(new FlowLayout());
		
		idPanel.add(idLabel);
		idPanel.add(idField);

		pwPanel.add(pwLabel);
		pwPanel.add(pwField);
		
		idPanel.setBackground(new Color(96,181,220));
		pwPanel.setBackground(new Color(96,181,220));
		btnPanel.setBackground(new Color(96,181,220));
		
		btnPanel.add(loginBtn);
		btnPanel.add(registerBtn);
		
		loginBtn.setPreferredSize(new Dimension(80,40));
		loginBtn.addActionListener(new loginListener());
		
		registerBtn.setPreferredSize(new Dimension(80,40));
		

		mainLabel.setHorizontalAlignment(JLabel.CENTER); //상단 재활 운동 도우미 가운데 정렬
		mainLabel.setFont(mainfont); //재활 운동 도우미 폰트 설정
		this.add(mainLabel,BorderLayout.NORTH);
		this.add(mainIconLabel,BorderLayout.CENTER);
		this.add(idPanel);
		this.add(pwPanel);
		this.add(btnPanel);
		this.getContentPane().setBackground(new Color(96,181,220));
		
		this.setVisible(true);
		this.setSize(350,500);
	}

	
	class loginListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			healthFrame = new HealthFrame();
			hLController = new HealthListController(healthFrame);
			hFController = new HealthFrameController(healthFrame);
			eSController = new ExerciseStartController(healthFrame);
			pESController = new PreExerciseStartController(healthFrame);
		}
		
	}
	
	public static void main(String[] args) {

		new Main();
	}

}
