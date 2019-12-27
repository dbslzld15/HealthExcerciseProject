import javax.swing.*;
import View.HealthFrame;
import javax.imageio.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Main extends JFrame{
	
	private JLabel mainLabel = new JLabel("��Ȱ � �����");
	private Font mainfont = new Font("���� ���",Font.BOLD,30);
	private ImageIcon mainIcon = new ImageIcon("images/main.jpg");
	private Image img = mainIcon.getImage();
	private Image img2 = img.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
	private ImageIcon mainIcon2 = new ImageIcon(img2);
	private JLabel mainIconLabel = new JLabel(mainIcon2); //�̹��� ������ ũ�� ���� �� �ٽ� ����
	private JPanel idPanel = new JPanel();
	private JPanel pwPanel = new JPanel();
	private JPanel btnPanel = new JPanel();
	private JLabel idLabel = new JLabel("ID : ");
	private JLabel pwLabel = new JLabel("PW : ");
	private JTextField idField = new JTextField(12);
	private JPasswordField pwField = new JPasswordField(12);
	private JButton loginBtn = new JButton("�α���");
	private JButton registerBtn = new JButton("ȸ������");
	
	Main()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("��Ȱ ����� ���α׷�");
		this.setLayout(new FlowLayout());
		
		idPanel.add(idLabel);
		idPanel.add(idField);

		pwPanel.add(pwLabel);
		pwPanel.add(pwField);
		
		btnPanel.add(loginBtn);
		btnPanel.add(registerBtn);
		
		loginBtn.addActionListener(new loginListener());
		
		mainLabel.setHorizontalAlignment(JLabel.CENTER); //��� ��Ȱ � ����� ��� ����
		mainLabel.setFont(mainfont); //��Ȱ � ����� ��Ʈ ����
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
			new HealthFrame();
		}
		
	}
	
	public static void main(String[] args) {

		new Main();
	}

}
