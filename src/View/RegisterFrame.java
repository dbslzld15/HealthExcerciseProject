package View;

import javax.swing.*;


import java.awt.*;

public class RegisterFrame extends JFrame{

	private JLabel titleLabel;
	

	private JPanel idPanel;
	private JPanel pwPanel; 
	private JPanel btnPanel; 
	private JLabel idLabel; 
	private JLabel pwLabel; 
	private JTextField idField; 
	private JPasswordField pwField; 

	private ImageIcon mainIcon;
	private Image img;
	private Image img2;
	private ImageIcon mainIcon2; 
	private JLabel mainIconLabel;
	private JButton joinButton;
	private JButton cancelButton;
	public RegisterFrame(){
		init();
	}
	
	public void init() {
		this.setTitle("회원가입");
		this.setLayout(new FlowLayout());
		titleLabel = new JLabel("회원가입 창");
		idPanel = new JPanel();
		pwPanel = new JPanel();
		btnPanel = new JPanel();
		idLabel = new JLabel("Username : ");
		pwLabel = new JLabel("Password : ");
		idField = new JTextField(12);
		pwField = new JPasswordField(12);
		joinButton = new JButton(new ImageIcon("images/가입하기.png"));
		cancelButton = new JButton(new ImageIcon("images/취소.png"));
		

		joinButton.setPreferredSize(new Dimension(80,40));
		cancelButton.setPreferredSize(new Dimension(60,40));
		
		mainIcon = new ImageIcon("images/register.png");
		img = mainIcon.getImage();
		img2 = img.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
		mainIcon2 = new ImageIcon(img2);
		mainIconLabel = new JLabel(mainIcon2); //이미지 아이콘 크기 조절 후 다시 설정
		
		titleLabel.setFont(new Font("맑은 고딕",Font.BOLD,30));
		
		idPanel.add(idLabel);
		idPanel.add(idField);

		pwPanel.add(pwLabel);
		pwPanel.add(pwField);
		
		btnPanel.add(joinButton);
		btnPanel.add(cancelButton);
		
		idPanel.setBackground(new Color(96,181,220));
		pwPanel.setBackground(new Color(96,181,220));
		btnPanel.setBackground(new Color(96,181,220));
		
		this.add(titleLabel,BorderLayout.NORTH);
		this.add(mainIconLabel,BorderLayout.CENTER);
	
		this.add(idPanel);
		this.add(pwPanel);
		this.add(btnPanel);
		this.getContentPane().setBackground(new Color(96,181,220));
		
		this.setVisible(true);
		this.setSize(350,500);
	}
	
	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JButton getJoinButton() {
		return joinButton;
	}

	public void setJoinButton(JButton joinButton) {
		this.joinButton = joinButton;
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
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
}
