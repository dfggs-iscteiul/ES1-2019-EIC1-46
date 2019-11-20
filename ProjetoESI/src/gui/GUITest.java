package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUITest {

	private JFrame frame;
	private GridBagConstraints gbc = new GridBagConstraints();
	String[] operadores = { "<", ">", "=", "<=", ">=" };

	public void createandShowGUI() {
		frame = new JFrame();
		frame.setTitle("Projeto ES1");
		frame.setSize(500, 300);
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		gbc.insets = new Insets(5, 5, 5, 5);

		JCheckBox c1 = new JCheckBox();
		gbc.gridx = 0;
		gbc.gridy = 0;
		frame.add(c1,gbc);
		JLabel label1 = new JLabel("LOC");
		gbc.gridx = 1;
		gbc.gridy = 0;
		frame.add(label1, gbc);
		JComboBox<String> listaOperadores = new JComboBox<>(operadores);
		gbc.gridx = 2;
		gbc.gridy = 0;
		frame.add(listaOperadores, gbc);
		String operadorSelecionado = (String) listaOperadores.getSelectedItem();
		JTextField tField1 = new JTextField();
		tField1.setPreferredSize(new Dimension(80, 20));
		gbc.gridx = 3;
		gbc.gridy = 0;
		frame.add(tField1, gbc);
		
		JCheckBox c2 = new JCheckBox();
		gbc.gridx = 0;
		gbc.gridy = 1;
		frame.add(c2,gbc);
		JLabel label2 = new JLabel("LOC");
		gbc.gridx = 1;
		gbc.gridy = 1;
		frame.add(label2, gbc);
		JComboBox<String> listaOperadores2 = new JComboBox<>(operadores);
		gbc.gridx = 2;
		gbc.gridy = 1;
		frame.add(listaOperadores2, gbc);
		String operadorSelecionado2 = (String) listaOperadores2.getSelectedItem();
		JTextField tField2 = new JTextField();
		tField2.setPreferredSize(new Dimension(80, 20));
		gbc.gridx = 3;
		gbc.gridy = 1;
		frame.add(tField2, gbc);
		
		JCheckBox c3 = new JCheckBox();
		gbc.gridx = 4;
		gbc.gridy = 0;
		frame.add(c3,gbc);
		JLabel label3 = new JLabel("LOC");
		gbc.gridx = 5;
		gbc.gridy = 0;
		frame.add(label3, gbc);
		JComboBox<String> listaOperadores3 = new JComboBox<>(operadores);
		gbc.gridx = 6;
		gbc.gridy = 0;
		frame.add(listaOperadores3, gbc);
		String operadorSelecionado3 = (String) listaOperadores3.getSelectedItem();
		JTextField tField3 = new JTextField();
		tField3.setPreferredSize(new Dimension(80, 20));
		gbc.gridx = 7;
		gbc.gridy = 0;
		frame.add(tField3, gbc);
	
		JCheckBox c4 = new JCheckBox();
		gbc.gridx = 4;
		gbc.gridy = 1;
		frame.add(c4,gbc);
		JLabel label4 = new JLabel("LOC");
		gbc.gridx = 5;
		gbc.gridy = 1;
		frame.add(label4, gbc);
		JComboBox<String> listaOperadores4 = new JComboBox<>(operadores);
		gbc.gridx = 6;
		gbc.gridy = 1;
		frame.add(listaOperadores4, gbc);
		String operadorSelecionado4 = (String) listaOperadores4.getSelectedItem();
		JTextField tField4 = new JTextField();
		tField4.setPreferredSize(new Dimension(80, 20));
		gbc.gridx = 7;
		gbc.gridy = 1;
		frame.add(tField4, gbc);
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		GUITest gui = new GUITest();
		gui.createandShowGUI();
	}

}
