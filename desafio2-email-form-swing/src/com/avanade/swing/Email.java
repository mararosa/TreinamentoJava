package com.avanade.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Email {

	private JFrame frame;
	private JTextField txtTo;
	private JTextField txtCc;
	private JLabel lblSubject;
	private JTextField txtSubject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Email window = new Email();
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
	public Email() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 721, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String to = txtTo.getText();
				String cc = txtCc.getText();
				String subject = txtSubject.getText();
				
				if(to.equals("mara.rosa@avanade.com") && cc.equals("") && subject.equals("Meu formulario!!!")) {
					
					JOptionPane.showMessageDialog(frame, "Mensagem enviada");
					
				} else {
					JOptionPane.showMessageDialog(frame, "Preencha os dados");
				}
			}
		});
		btnSend.setBounds(28, 57, 69, 100);
		frame.getContentPane().add(btnSend);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(135, 72, 69, 33);
		frame.getContentPane().add(lblTo);
		
		JLabel lblCc = new JLabel("Cc");
		lblCc.setBounds(135, 124, 61, 33);
		frame.getContentPane().add(lblCc);
		
		txtTo = new JTextField();
		txtTo.setBounds(211, 72, 312, 33);
		frame.getContentPane().add(txtTo);
		txtTo.setColumns(10);
		
		txtCc = new JTextField();
		txtCc.setBounds(211, 124, 312, 33);
		frame.getContentPane().add(txtCc);
		txtCc.setColumns(10);
		
		lblSubject = new JLabel("Subject");
		lblSubject.setBounds(135, 183, 49, 14);
		frame.getContentPane().add(lblSubject);
		
		txtSubject = new JTextField();
		txtSubject.setBounds(211, 180, 312, 33);
		frame.getContentPane().add(txtSubject);
		txtSubject.setColumns(10);
		
		JTextArea txtarMessage = new JTextArea();
		txtarMessage.setBounds(10, 224, 687, 157);
		frame.getContentPane().add(txtarMessage);
		
		JLabel lblClassification = new JLabel("Data Classification:");
		lblClassification.setBounds(25, 11, 131, 14);
		frame.getContentPane().add(lblClassification);
		
		JCheckBox chckbxUnrestricted = new JCheckBox("Unrestricted");
		chckbxUnrestricted.setBounds(162, 7, 99, 23);
		frame.getContentPane().add(chckbxUnrestricted);
		
		JCheckBox chckbxConfidential = new JCheckBox("Confidential");
		chckbxConfidential.setBounds(263, 7, 99, 23);
		frame.getContentPane().add(chckbxConfidential);
		
		JCheckBox chckbxHighlyConfidential = new JCheckBox("Highly Confidential");
		chckbxHighlyConfidential.setBounds(377, 7, 146, 23);
		frame.getContentPane().add(chckbxHighlyConfidential);
		
		JCheckBox chckbxRestricted = new JCheckBox("Restricted");
		chckbxRestricted.setBounds(530, 7, 99, 23);
		frame.getContentPane().add(chckbxRestricted);
	}
}
