
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();
	JLabel title;
	JLabel labelUsername = new JLabel();
	JLabel labelPassword = new JLabel();
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel container1 = new JPanel();
	JPanel container2 = new JPanel();
	JButton submit = new JButton();
	JButton register = new JButton();
	DBHelper db = new DBHelper();
	JFrame theFrame = this;
	Login() {
		this.setSize(850, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(78, 24, 102));
		this.setLayout(new GridLayout(0, 2, 0, 0));
		this.setLocationRelativeTo(null);
		// add to container
		container1.setLayout(null);
		container2.setLayout(null);
		container2.add(register);
		container1.add(submit);

		// Button
		submit.setText("Submit");
		submit.setFocusable(false);
		submit.addActionListener(this);
		Key lforKeyPress = new Key();
		username.addKeyListener(lforKeyPress);
		password.addKeyListener(lforKeyPress);
		submit.setBounds(65, 40, 100, 50);
		register.setText("Register");
		register.setFocusable(false);
		register.addActionListener(this);
		register.setBounds(30, 40, 100, 50);
		// Label for Username
		labelUsername.setText("Username");
		labelUsername.setBounds(185, 100, 250, 40);

		// Label for Password
		labelPassword.setText("Password");
		labelPassword.setBounds(185, 100, 250, 40);

		// TITLE
		title = new JLabel();
		title.setText("ECC Schedule System");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("MV Boli", Font.PLAIN, 20));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);

		// uTextField
		username.setPreferredSize(new Dimension(250, 40));
		username.setHorizontalAlignment(JTextField.CENTER);
		username.setBounds(90, 140, 250, 40);

		// pTextField
		password.setPreferredSize(new Dimension(250, 40));
		password.setHorizontalAlignment(JTextField.CENTER);
		password.setBounds(90, 140, 250, 40);
		// Left Panel
		leftPanel.setBackground(new Color(223, 75, 75));
		leftPanel.setLayout(new BorderLayout());

		// Right Panel
		rightPanel.setBackground(Color.gray);
		rightPanel.setLayout(new GridLayout(3, 0, 0, 0));
		// Adding Components to the right Panel
		rightPanel.add(panel1);
		rightPanel.add(panel2);
		rightPanel.add(panel3);

		// Adding Components to the left Panel
		leftPanel.add(title);

		// Adding Components to Panel 1
		panel1.add(labelUsername);
		panel1.add(username);
		panel1.setLayout(null);
		// Adding Components to Panel 2
		panel2.add(labelPassword);
		panel2.add(password);
		panel2.setLayout(null);
		// Adding Components to Panel 3

		panel3.add(container1);
		panel3.add(container2);
		panel3.setLayout(new GridLayout(0, 2, 10, 10));
		// Adding Components Frame
		this.add(leftPanel);
		this.add(rightPanel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {

		
		if(db.Authenticate(username.getText(), password.getPassword().toString())=="access granted") {
			this.dispose();
			Dashboard newDash = new Dashboard(username.getText());
		}
		else if(db.Authenticate(username.getText(), password.getText())=="There is no Record in database") {
			System.out.println("Invalid Username or Password");
		}
		else if (db.Authenticate(username.getText(), password.getText())=="no data") {
			System.out.println("Please fill up all the fields");
		}

		} else if (e.getSource() == register) {
			this.dispose();
			Register registerWindow = new Register();

		}

	}
	public class Key implements KeyListener{
	
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()==10) {
				if(db.Authenticate(username.getText(), password.getText())=="access granted") {
					theFrame.dispose();
					Dashboard newDash = new Dashboard(username.getText());
				}
				else if(db.Authenticate(username.getText(), password.getText())=="There is no Record in database") {
					System.out.println("Invalid Username or Password");
				}
			}
		}
		
	}

}
