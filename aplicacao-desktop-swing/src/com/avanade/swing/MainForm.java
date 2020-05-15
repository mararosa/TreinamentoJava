package com.avanade.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainForm extends JFrame {
	
	private static final int FORM_WIDTH = 800;
	private static final int FORM_HEIGHT = 600;

	public static void main(String[] args) {
		MainForm main = new MainForm();
		main.setVisible(true); //dizendo que o form agora eh visivel	
	}

	// Metodo contrutor
	public MainForm() {
		formInit();
	}

	private void formInit() {
		setTitle("Meu Formulario");
		//Dando um tamanho para o formulario
		setSize(FORM_WIDTH, FORM_HEIGHT);
		
		//Atribuindo um tipo para o formulario
		setLayout(new FlowLayout()); //Normalmente declara os componentes de tela fora do corpo da classe, 
		JLabel lblOla = new JLabel("Ola, eu sou um label"); //mas quando a utilizacao sera apenas dentro do metodo, pode ser declarado no metodo
		JTextField txtEntrada = new JTextField(20);
		JButton btnConfirma = new JButton("Confirmar");
		
		//depois do label criado, add no formulario
		//getContentPane pega a tela do formulario
		getContentPane().add(lblOla);
		getContentPane().add(txtEntrada);
		getContentPane().add(btnConfirma);
	}
	
}
