package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import code.BuildObjectsFromExcel;
import code.DataEntry;

//Ainda faltam acrescentam algumas coisas
//Isto ainda tem que ser otimizado

/**
 * Represents the Interface of the program.
 *
 */
public class GUI {

	private JFrame frame;
	private File file;
	private GridBagConstraints gbc = new GridBagConstraints();
	String[] operadores = { "<", ">", "=", "<=", ">=" };

	/**
	 * Builds the structure of the interface and adds button listeners.
	 */
	public void createandShowGUI() {
		frame = new JFrame();
		frame.setTitle("Projeto ES1");
		frame.setSize(700, 400);
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		gbc.insets = new Insets(5, 5, 5, 5);
		
		JLabel label00 = new JLabel("Regra ativa");
		gbc.gridx = 0;
		gbc.gridy = 0;
		frame.add(label00,gbc);
		JLabel label01 = new JLabel("Threshold");
		gbc.gridx = 1;
		gbc.gridy = 0;
		frame.add(label01, gbc);
		JLabel label02 = new JLabel("Operador");
		gbc.gridx = 2;
		gbc.gridy = 0;
		frame.add(label02, gbc);
		JLabel label03 = new JLabel("Valor");
		gbc.gridx = 3;
		gbc.gridy = 0;
		frame.add(label03, gbc);
		
		JLabel label10 = new JLabel("Regra ativa");
		gbc.gridx = 4;
		gbc.gridy = 0;
		frame.add(label10,gbc);
		JLabel label11 = new JLabel("Threshold");
		gbc.gridx = 5;
		gbc.gridy = 0;
		frame.add(label11, gbc);
		JLabel label12 = new JLabel("Operador");
		gbc.gridx = 6;
		gbc.gridy = 0;
		frame.add(label12, gbc);
		JLabel label13 = new JLabel("Valor");
		gbc.gridx = 7;
		gbc.gridy = 0;
		frame.add(label13, gbc);

		JCheckBox c1 = new JCheckBox();
		gbc.gridx = 0;
		gbc.gridy = 1;
		frame.add(c1,gbc);
		JLabel label1 = new JLabel("LOC");
		gbc.gridx = 1;
		gbc.gridy = 1;
		frame.add(label1, gbc);
		JComboBox<String> listaOperadores = new JComboBox<>(operadores);
		gbc.gridx = 2;
		gbc.gridy = 1;
		frame.add(listaOperadores, gbc);
		String operadorSelecionado = (String) listaOperadores.getSelectedItem();
		JTextField tField1 = new JTextField();
		tField1.setPreferredSize(new Dimension(80, 20));
		gbc.gridx = 3;
		gbc.gridy = 1;
		frame.add(tField1, gbc);
		
		JCheckBox c2 = new JCheckBox();
		gbc.gridx = 0;
		gbc.gridy = 2;
		frame.add(c2,gbc);
		JLabel label2 = new JLabel("CYCLO");
		gbc.gridx = 1;
		gbc.gridy = 2;
		frame.add(label2, gbc);
		JComboBox<String> listaOperadores2 = new JComboBox<>(operadores);
		gbc.gridx = 2;
		gbc.gridy = 2;
		frame.add(listaOperadores2, gbc);
		String operadorSelecionado2 = (String) listaOperadores2.getSelectedItem();
		JTextField tField2 = new JTextField();
		tField2.setPreferredSize(new Dimension(80, 20));
		gbc.gridx = 3;
		gbc.gridy = 2;
		frame.add(tField2, gbc);
		
		JCheckBox c3 = new JCheckBox();
		gbc.gridx = 4;
		gbc.gridy = 1;
		frame.add(c3,gbc);
		JLabel label3 = new JLabel("AFTD");
		gbc.gridx = 5;
		gbc.gridy = 1;
		frame.add(label3, gbc);
		JComboBox<String> listaOperadores3 = new JComboBox<>(operadores);
		gbc.gridx = 6;
		gbc.gridy = 1;
		frame.add(listaOperadores3, gbc);
		String operadorSelecionado3 = (String) listaOperadores3.getSelectedItem();
		JTextField tField3 = new JTextField();
		tField3.setPreferredSize(new Dimension(80, 20));
		gbc.gridx = 7;
		gbc.gridy = 1;
		frame.add(tField3, gbc);
	
		JCheckBox c4 = new JCheckBox();
		gbc.gridx = 4;
		gbc.gridy = 2;
		frame.add(c4,gbc);
		JLabel label4 = new JLabel("LAA");
		gbc.gridx = 5;
		gbc.gridy = 2;
		frame.add(label4, gbc);
		JComboBox<String> listaOperadores4 = new JComboBox<>(operadores);
		gbc.gridx = 6;
		gbc.gridy = 2;
		frame.add(listaOperadores4, gbc);
		String operadorSelecionado4 = (String) listaOperadores4.getSelectedItem();
		JTextField tField4 = new JTextField();
		tField4.setPreferredSize(new Dimension(80, 20));
		gbc.gridx = 7;
		gbc.gridy = 2;
		frame.add(tField4, gbc);
		
		JButton button = new JButton("Importar ficheiro");
		button.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser filechooser = new JFileChooser("Importar ficheiro");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel file", "xls", "xlsx");
			filechooser.setFileFilter(filter);
			int returnVal = filechooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				
				file = filechooser.getSelectedFile();
				System.out.println("Escolheu abrir o ficheiro: " + file.getName());
				try {
					BuildObjectsFromExcel bofe = new BuildObjectsFromExcel();
					bofe.buildObjects(file);
					
					ArrayList<DataEntry> dados = bofe.objects();
					for (DataEntry a: dados) {
						//TODO a. mostrar informação na GUI
					}
					
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}

				File excel = new File(file.toString()); 
			}
		}
	});
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 8;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		frame.add(button,gbc);
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.createandShowGUI();
	}

}
