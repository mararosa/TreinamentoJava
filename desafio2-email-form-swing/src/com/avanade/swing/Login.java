package com.avanade.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField username;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 737, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(82, 119, 118, 24);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(82, 201, 118, 24);
		frame.getContentPane().add(lblPassword);
		
		username = new JTextField();
		username.setBounds(279, 115, 220, 33);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(279, 203, 220, 33);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = username.getText();
				String psd = passwordField.getText();
				
				if(uname.equals("name") && psd.equals("password")) {
					
					JOptionPane.showMessageDialog(frame, "Login realizado com sucesso");
					
				} else {
					JOptionPane.showMessageDialog(frame, "Login ou senha inválidos");
				}
			}
		});
		btnLogin.setBounds(295, 282, 89, 24);
		frame.getContentPane().add(btnLogin);
		
	}
}
