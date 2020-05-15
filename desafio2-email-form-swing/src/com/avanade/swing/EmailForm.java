package com.avanade.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmailForm extends JFrame{

	private static final int FORM_WIDTH = 600;
	private static final int FORM_HEIGHT = 300;

	public static void main(String[] args) {
		EmailForm main = new EmailForm();
		main.setVisible(true); //dizendo que o form agora eh visivel	
	}

	// Metodo contrutor
	public EmailForm() {
		formInit();
	}

	private void formInit() {
		setTitle("Mail Message");
		//Dando um tamanho para o formulario
		setSize(FORM_WIDTH, FORM_HEIGHT);
		
		//Atribuindo um tipo para o formulario
		setLayout(new FlowLayout()); //Normalmente declara os componentes de tela fora do corpo da classe, 
		JLabel lblTo = new JLabel("To: "); //mas quando a utilizacao sera apenas dentro do metodo, pode ser declarado no metodo
		JLabel lblSubject = new JLabel("Subject: ");
		JLabel lblMessage = new JLabel("Message: ");
		
		JTextField txtTo = new JTextField(30);
		JTextField txtSubject = new JTextField(30);
		JTextArea txtMessage = new JTextArea(45,60);
		
		JButton btnSend = new JButton("Send");
		
		//depois do label criado, add no formulario
		//getContentPane pega a tela do formulario
		getContentPane().add(lblTo);
		getContentPane().add(txtTo);
		getContentPane().add(lblSubject);
		getContentPane().add(txtSubject);
		getContentPane().add(lblMessage);
		getContentPane().add(txtMessage);
		getContentPane().add(btnSend);
	}
	
}
