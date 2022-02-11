package calculadora;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.undo.AbstractUndoableEdit;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class calculadoraprueba extends JFrame {

	private JPanel panelInferior;
	private int pulsaciones;
	JLabel label = new JLabel();
	String numeroString = "";
	String tipoOperacion;
	int operacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculadoraprueba frame = new calculadoraprueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
public void calculacion() {
	if(tipoOperacion == "+") {
		Sumar();
	}
	else if(tipoOperacion == "-") {
		Restar();
	}
}
	
	
	
	
	
	private  class EscuchadorInterno implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String comando = e.getActionCommand();
			numeroString = numeroString + comando;
			System.out.println("Has pulsado un boton :) " + comando);
			label.setText(numeroString);
			//actualizaPulsaciones();
		}
	}
	
	public void Sumar() {
		numeroString = label.getText();
		int sum = Integer.parseInt(numeroString);
		operacion = operacion + sum;
		numeroString = String.valueOf(operacion);
		label.setText(numeroString);
	}
	public void Restar() {
		numeroString = label.getText();
		int sum = Integer.parseInt(numeroString);
		operacion = operacion - sum;
		numeroString = String.valueOf(operacion);
		label.setText(numeroString);
	}
	
	public class BSumar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			numeroString = label.getText();
			operacion = Integer.parseInt(numeroString);
			numeroString = "";
			label.setText(numeroString);
		}
	}
	private class BotonOperacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String comando = e.getActionCommand();
			label.setText(comando);
			tipoOperacion = label.getText();
			//operacion = Integer.parseInt(numeroString);
			numeroString = "";
			label.setText(tipoOperacion);
		}
	}
	private class Igual implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			/*numeroString = label.getText();
			int sum = Integer.parseInt(numeroString);
			operacion = operacion + sum;
			numeroString = String.valueOf(operacion);
			label.setText(numeroString);*/
			calculacion();
		}
	}
	
	private class Ce implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			numeroString = "";
			operacion = 0;
			label.setText(numeroString);
		}
	}
	

	public calculadoraprueba() {
		
		EscuchadorInterno ei = new EscuchadorInterno();
		BSumar sumar = new BSumar();
		Igual igual = new Igual();
		Ce ce = new Ce();
		BotonOperacion bo = new BotonOperacion();
		
		JPanel panelFondo = new JPanel();
		panelFondo.setLayout(new BorderLayout());
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 373);
		
		JPanel panelSuperior = new JPanel ();
		GridBagLayout gbl_panelSuperior = new GridBagLayout();
		gbl_panelSuperior.columnWidths = new int[]{46, 486, 0};
		gbl_panelSuperior.rowHeights = new int[]{100, 19, 0, 0, 0};
		gbl_panelSuperior.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelSuperior.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelSuperior.setLayout(gbl_panelSuperior);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelFondo);
		GridBagLayout gbl_panelInferior = new GridBagLayout();
		gbl_panelInferior.columnWidths = new int[]{113, 113, 113, 113, 113, 0};
		gbl_panelInferior.rowHeights = new int[]{21, 21, 21, 21, 0};
		gbl_panelInferior.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelInferior.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelInferior.setLayout(gbl_panelInferior);
		
		JButton btnNewButton_7 = new JButton("7");
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridx = 0;
		gbc_btnNewButton_7.gridy = 0;
		panelInferior.add(btnNewButton_7, gbc_btnNewButton_7);
		btnNewButton_7.addActionListener(ei);
		
		JButton btnNewButton_8 = new JButton("8");
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 1;
		gbc_btnNewButton_8.gridy = 0;
		panelInferior.add(btnNewButton_8, gbc_btnNewButton_8);
		btnNewButton_8.addActionListener(ei);
		
		JButton btnNewButton_9 = new JButton("9");
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_9.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_9.gridx = 2;
		gbc_btnNewButton_9.gridy = 0;
		panelInferior.add(btnNewButton_9, gbc_btnNewButton_9);
		btnNewButton_9.addActionListener(ei);
		
		JButton btnNewButton_MaMe = new JButton("+/-");
		GridBagConstraints gbc_btnNewButton_MaMe = new GridBagConstraints();
		gbc_btnNewButton_MaMe.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_MaMe.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_MaMe.gridx = 3;
		gbc_btnNewButton_MaMe.gridy = 0;
		panelInferior.add(btnNewButton_MaMe, gbc_btnNewButton_MaMe);
		btnNewButton_MaMe.addActionListener(bo);
		
		JButton btnNewButton_Back = new JButton("Atras");
		GridBagConstraints gbc_btnNewButton_Back = new GridBagConstraints();
		gbc_btnNewButton_Back.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_Back.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_Back.gridx = 4;
		gbc_btnNewButton_Back.gridy = 0;
		panelInferior.add(btnNewButton_Back, gbc_btnNewButton_Back);
		btnNewButton_Back.addActionListener(bo);
		
		JButton btnNewButton_4 = new JButton("4");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 1;
		panelInferior.add(btnNewButton_4, gbc_btnNewButton_4);
		btnNewButton_4.addActionListener(ei);
				
				JButton btnNewButton_5 = new JButton("5");
				GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
				gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
				gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton_5.gridx = 1;
				gbc_btnNewButton_5.gridy = 1;
				panelInferior.add(btnNewButton_5, gbc_btnNewButton_5);
				btnNewButton_5.addActionListener(ei);
				
				JButton btnNewButton_6 = new JButton("6");
				GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
				gbc_btnNewButton_6.fill = GridBagConstraints.BOTH;
				gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton_6.gridx = 2;
				gbc_btnNewButton_6.gridy = 1;
				panelInferior.add(btnNewButton_6, gbc_btnNewButton_6);
				btnNewButton_6.addActionListener(ei);
				
				JButton btnNewButton_Mult = new JButton("X");
				GridBagConstraints gbc_btnNewButton_Mult = new GridBagConstraints();
				gbc_btnNewButton_Mult.fill = GridBagConstraints.BOTH;
				gbc_btnNewButton_Mult.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton_Mult.gridx = 3;
				gbc_btnNewButton_Mult.gridy = 1;
				panelInferior.add(btnNewButton_Mult, gbc_btnNewButton_Mult);
				btnNewButton_Mult.addActionListener(bo);
		
				JButton btnNewButton_Div = new JButton("/");
				GridBagConstraints gbc_btnNewButton_Div = new GridBagConstraints();
				gbc_btnNewButton_Div.fill = GridBagConstraints.BOTH;
				gbc_btnNewButton_Div.insets = new Insets(0, 0, 5, 0);
				gbc_btnNewButton_Div.gridx = 4;
				gbc_btnNewButton_Div.gridy = 1;
				panelInferior.add(btnNewButton_Div, gbc_btnNewButton_Div);
				btnNewButton_Div.addActionListener(bo);
		
		JButton btnNewButton_1 = new JButton("1");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 2;
		panelInferior.add(btnNewButton_1, gbc_btnNewButton_1);
		
		btnNewButton_1.addActionListener(ei);
				
				JButton btnNewButton_2 = new JButton("2");
				GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
				gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
				gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton_2.gridx = 1;
				gbc_btnNewButton_2.gridy = 2;
				panelInferior.add(btnNewButton_2, gbc_btnNewButton_2);
				btnNewButton_2.addActionListener(ei);
		
				JButton btnNewButton_3 = new JButton("3");
				GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
				gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
				gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton_3.gridx = 2;
				gbc_btnNewButton_3.gridy = 2;
				panelInferior.add(btnNewButton_3, gbc_btnNewButton_3);
				btnNewButton_3.addActionListener(ei);
		
		JButton btnNewButton_Res = new JButton("-");
		GridBagConstraints gbc_btnNewButton_Res = new GridBagConstraints();
		gbc_btnNewButton_Res.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_Res.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_Res.gridx = 3;
		gbc_btnNewButton_Res.gridy = 2;
		panelInferior.add(btnNewButton_Res, gbc_btnNewButton_Res);
		btnNewButton_Res.addActionListener(bo);
		
				JButton btnNewButton_Igu = new JButton("=");
				GridBagConstraints gbc_btnNewButton_Igu = new GridBagConstraints();
				gbc_btnNewButton_Igu.gridheight = 2;
				gbc_btnNewButton_Igu.fill = GridBagConstraints.BOTH;
				gbc_btnNewButton_Igu.insets = new Insets(0, 0, 5, 0);
				gbc_btnNewButton_Igu.gridx = 4;
				gbc_btnNewButton_Igu.gridy = 2;
				panelInferior.add(btnNewButton_Igu, gbc_btnNewButton_Igu);
				btnNewButton_Igu.addActionListener(igual);
		
		JButton btnNewButton_C = new JButton("C");
		GridBagConstraints gbc_btnNewButton_C = new GridBagConstraints();
		gbc_btnNewButton_C.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_C.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_C.gridx = 0;
		gbc_btnNewButton_C.gridy = 3;
		panelInferior.add(btnNewButton_C, gbc_btnNewButton_C);
		btnNewButton_C.addActionListener(bo);
		
		JButton btnNewButton_0 = new JButton("0");
		GridBagConstraints gbc_btnNewButton_0 = new GridBagConstraints();
		gbc_btnNewButton_0.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_0.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_0.gridx = 1;
		gbc_btnNewButton_0.gridy = 3;
		panelInferior.add(btnNewButton_0, gbc_btnNewButton_0);
		btnNewButton_0.addActionListener(ei);
		
		JButton btnNewButton_Pun = new JButton(".");
		GridBagConstraints gbc_btnNewButton_Pun = new GridBagConstraints();
		gbc_btnNewButton_Pun.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_Pun.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_Pun.gridx = 2;
		gbc_btnNewButton_Pun.gridy = 3;
		panelInferior.add(btnNewButton_Pun, gbc_btnNewButton_Pun);
		btnNewButton_Pun.addActionListener(ei);
		
		JButton btnNewButton_Sum = new JButton("+");
		GridBagConstraints gbc_btnNewButton_Sum = new GridBagConstraints();
		gbc_btnNewButton_Sum.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_Sum.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_Sum.gridx = 3;
		gbc_btnNewButton_Sum.gridy = 3;
		panelInferior.add(btnNewButton_Sum, gbc_btnNewButton_Sum);
		btnNewButton_Sum.addActionListener(bo);
		
		panelFondo.add(panelInferior, BorderLayout.SOUTH);
		panelFondo.add(panelSuperior, BorderLayout.CENTER);
		
		label = new JLabel("New label");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 2;
		gbc_label.gridheight = 4;
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panelSuperior.add(label, gbc_label);
		

	}

}
