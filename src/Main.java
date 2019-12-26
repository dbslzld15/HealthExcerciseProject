import javax.swing.*;
import javax.imageio.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class healthFrame extends JFrame{
	

	private JButton myPageBtn = new JButton("마이 페이지");
	private JButton healthBtn = new JButton("운동 리스트");
	private JButton startBtn = new JButton("운동 시작");
	private JPanel topPanel = new JPanel();
	private JPanel topPanel2 = new JPanel();
	private JPanel midPanel = new JPanel();
	
	private JComboBox firstBox = new JComboBox();
	private JComboBox secondBox = new JComboBox();
	private JButton inButton = new JButton("입력");
	private JLabel inLabel = new JLabel("아픈 부위 입력 : ");
	private JList healthList = new JList();
	
	
	healthFrame(){
		setTitle("운동리스트");
		
		topPanel.setLayout(new FlowLayout());
		topPanel.add(myPageBtn);
		topPanel.add(healthBtn);
		topPanel.add(startBtn);
		
		firstBox.setPreferredSize(new Dimension(100,20));
		secondBox.setPreferredSize(new Dimension(50,20)); //콤보박스 가로 크기 조절
		
		topPanel2.setLayout(new FlowLayout());
		topPanel2.add(inLabel);
		topPanel2.add(firstBox);
		topPanel2.add(secondBox);
		topPanel2.add(inButton);
		
		midPanel.setLayout(new GridLayout(3,3));
		
		
		this.add(topPanel,BorderLayout.NORTH);
		this.add(topPanel2);
		setVisible(true);
		setSize(600,400);
	}
	
	
}

public class Main extends JFrame{
	
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
	private JLabel idLabel = new JLabel("ID : ");
	private JLabel pwLabel = new JLabel("PW : ");
	private JTextField idField = new JTextField(12);
	private JPasswordField pwField = new JPasswordField(12);
	private JButton loginBtn = new JButton("로그인");
	private JButton registerBtn = new JButton("회원가입");
	
	Main()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("재활 도우미 프로그램");
		this.setLayout(new FlowLayout());
		
		idPanel.add(idLabel);
		idPanel.add(idField);

		pwPanel.add(pwLabel);
		pwPanel.add(pwField);
		
		btnPanel.add(loginBtn);
		btnPanel.add(registerBtn);
		
		loginBtn.addActionListener(new loginListener());
		
		mainLabel.setHorizontalAlignment(JLabel.CENTER); //상단 재활 운동 도우미 가운데 정렬
		mainLabel.setFont(mainfont); //재활 운동 도우미 폰트 설정
		this.add(mainLabel,BorderLayout.NORTH);
		this.add(mainIconLabel,BorderLayout.CENTER);
		this.add(idPanel);
		this.add(pwPanel);
		this.add(btnPanel);
		this.setVisible(true);
		this.setSize(350,500);
	}

	
	class loginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			new healthFrame();
		}
		
	}
	
	public static void main(String[] args) {

		new Main();
	}

}
