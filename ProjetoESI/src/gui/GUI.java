package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

import code.BuildObjectsFromExcel;
import code.CustomDataEntry;
import code.CustomRule;
import code.DataEntry;
import code.DefectCalculator;
import code.ExcelAccuracy;
import code.Thresholds;

//Isto ainda tem que ser otimizado
//1ºTab -> Criação de Thresholds
//2ºTab -> Importar e visualizar Excel | Visualizar listas de regras criadas | Aplicar regra escolhida | Obter resultados
//Os operadores AND e OR não sei para que tab devem ir, não sei se fazem parte da regra que vai ser criada
//ou a regra só tem os valores e depois quando aplicamos definimos os operadores.

/**
 * Represents the Interface of the program.
 *
 */
public class GUI {

	private JFrame frame;
	private File file;
	private GridBagConstraints gbc = new GridBagConstraints();
	private String[] operadores1 = { "AND", "OR" };
	private JTabbedPane jTabbedPane;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JPanel jPanel4;
	private JPanel jPanel5;
	private JLabel fileStatus;
	private JScrollPane jScrollPane;
	private DefectCalculator calculator;
	private JLabel label0p2;
	private JLabel label1p2;
	private JLabel label2p2;
	private JLabel label3p2;
	private JLabel label4p2;
	private JLabel field1;
	private JLabel field2;
	private JLabel field3;
	private JLabel field4;
	private JLabel fieldcr1;
	private JLabel fieldcr2;
	private JLabel fieldcr3;
	private JLabel fieldcr4;
	private JLabel cr1;
	private JLabel cr2;
	private JLabel cr3;
	private JLabel cr4;
	private JLabel pmd0;
	private JLabel pmd1;
	private JLabel pmd2;
	private JLabel pmd3;
	private JLabel pmd4;
	private JLabel fieldpmd1;
	private JLabel fieldpmd2;
	private JLabel fieldpmd3;
	private JLabel fieldpmd4;
	private JLabel labelmedia;
	private JLabel labelpercent;
	private JLabel labelmedia1;
	private CustomRule cr;
	private JScrollPane jScrollPaneDefect;
	private double customAccuracy = 0.0;
	private TableModel modelDefect;

	private ArrayList<DataEntry> entries;
	private ArrayList<JTextField> list = new ArrayList<>();
	private ArrayList<CustomRule> customRules;
	private DefaultListModel<CustomRule> listModel = new DefaultListModel<>();
	private JList<CustomRule> rulesList = new JList<>(listModel);
	private DefaultListModel<Thresholds> listThresholds = new DefaultListModel<>();
	private JList <Thresholds> threhsoldsList = new JList<>(listThresholds);

	/**
	 * Builds the structure of the interface and adds button listeners.
	 */
	public void createandShowGUI() {
		frame = new JFrame();
		frame.setTitle("Projeto ES1");
		frame.setSize(700, 500);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);

		jTabbedPane = new JTabbedPane();
		
		jPanel1 = new JPanel(new GridBagLayout());
		jPanel2 = new JPanel(new GridBagLayout());
		jPanel3 = new JPanel(new GridBagLayout());
		jPanel4 = new JPanel(new GridBagLayout());
		jPanel5 = new JPanel(new GridBagLayout());

		gbc.insets = new Insets(5, 5, 5, 5);


		//////////
		////////////////////// TAB1 ---- VISUALIZAR DADOS
		//////////
		
		fileStatus = new JLabel("FICHEIRO AINDA NÃO IMPORTADO");
		fileStatus.setForeground(Color.RED);
		JButton button = new JButton("Importar ficheiro");
		labelmedia = new JLabel();
		labelpercent = new JLabel();

		gbc.gridx = 0; gbc.gridy = 1; jPanel1.add(labelmedia, gbc);
		gbc.gridx = 0; gbc.gridy = 2; jPanel1.add(labelpercent, gbc);
		gbc.gridx = 0; gbc.gridy = 3; jPanel1.add(button, gbc);
		gbc.gridx = 0; gbc.gridy = 4; jPanel1.add(fileStatus,gbc); 
		
		////////////////
		////////////////////// TAB1 ---- CRIAR THRESHOLDS
		////////////////

		JLabel label00 = new JLabel("Regra ativa");
		JLabel label03 = new JLabel("Valor");
		JLabel label1 = new JLabel("LOC");
		JLabel label2 = new JLabel("CYCLO");
		JLabel label3 = new JLabel("AFTD");
		JLabel label4 = new JLabel("LAA");
		JLabel labelOp1 = new JLabel("Operador Long Method");
		JLabel labelOp2 = new JLabel("Operador Feature Envy");
		JLabel labelName = new JLabel("Nome do Threshold");
		JCheckBox c1 = new JCheckBox();
		JCheckBox c2 = new JCheckBox();
		JCheckBox c3 = new JCheckBox();
		JCheckBox c4 = new JCheckBox();
		
		JComboBox<String> listaOperadoresMethod1 = new JComboBox<>(operadores1);
		JComboBox<String> listaOperadoresMethod2 = new JComboBox<>(operadores1);
		String operadorLM = (String) listaOperadoresMethod1.getSelectedItem();
		String operadorFE = (String) listaOperadoresMethod2.getSelectedItem();

		JButton button2 = new JButton("Criar threshold");
		button2.setEnabled(false);

		JTextField tField1 = new JTextField();
		JTextField tField2 = new JTextField();
		JTextField tField3 = new JTextField();
		JTextField tField4 = new JTextField();
		JTextField tField5 = new JTextField();
		
		tField1.setPreferredSize(new Dimension(80, 20));
		tField2.setPreferredSize(new Dimension(80, 20));
		tField3.setPreferredSize(new Dimension(80, 20));
		tField4.setPreferredSize(new Dimension(80, 20));
		tField5.setPreferredSize(new Dimension(80, 20));
		
		gbc.gridx = 2; gbc.gridy = 0; jPanel2.add(label00, gbc);
		gbc.gridx = 1; gbc.gridy = 0; jPanel2.add(label03, gbc);
		gbc.gridx = 0; gbc.gridy = 3; jPanel2.add(label1, gbc);
		gbc.gridx = 0; gbc.gridy = 4; jPanel2.add(label2, gbc);
		gbc.gridx = 0; gbc.gridy = 6; jPanel2.add(label3, gbc);
		gbc.gridx = 0; gbc.gridy = 7; jPanel2.add(label4, gbc);
		gbc.gridx = 0; gbc.gridy = 5; jPanel2.add(labelOp1, gbc);
		gbc.gridx = 0; gbc.gridy = 8; jPanel2.add(labelOp2, gbc);
		gbc.gridx = 0; gbc.gridy = 1; jPanel2.add(labelName, gbc);
		gbc.gridx = 1; gbc.gridy = 3; jPanel2.add(tField1, gbc);
		gbc.gridx = 1; gbc.gridy = 4; jPanel2.add(tField2, gbc);
		gbc.gridx = 1; gbc.gridy = 6; jPanel2.add(tField3, gbc);
		gbc.gridx = 1; gbc.gridy = 7; jPanel2.add(tField4, gbc);
		gbc.gridx = 1; gbc.gridy = 1; jPanel2.add(tField5, gbc);
		gbc.gridx = 2; gbc.gridy = 3; jPanel2.add(c1, gbc);
		gbc.gridx = 2; gbc.gridy = 4; jPanel2.add(c2, gbc);
		gbc.gridx = 2; gbc.gridy = 6; jPanel2.add(c3, gbc);
		gbc.gridx = 2; gbc.gridy = 7; jPanel2.add(c4, gbc);
		gbc.gridx = 1; gbc.gridy = 5; jPanel2.add(listaOperadoresMethod1, gbc);
		gbc.gridx = 1; gbc.gridy = 8; jPanel2.add(listaOperadoresMethod2, gbc); 
		gbc.gridx = 1; gbc.gridy = 9; jPanel2.add(button2, gbc);
		gbc.gridx = 3; gbc.gridy = 6; jPanel2.add(new JScrollPane(threhsoldsList),gbc);
		
		list.add(tField1);
		list.add(tField2);
		list.add(tField3);
		list.add(tField4);

		///////////////
		///////////////////////////////// TAB3 -- DEFEITOS
		///////////////

		if (file == null) {
			label0p2 = new JLabel("IPlasma");
			label1p2 = new JLabel("DCI");
			label2p2 = new JLabel("DII");
			label3p2 = new JLabel("ADCI");
			label4p2 = new JLabel("ADII");
			
			field1 = new JLabel("0");
			field2 = new JLabel("0");
			field3 = new JLabel("0");
			field4 = new JLabel("0");
			
			fieldpmd1 = new JLabel("0");
			fieldpmd2 = new JLabel("0");
			fieldpmd3 = new JLabel("0");
			fieldpmd4 = new JLabel("0");
			
			fieldcr1 = new JLabel("0");
			fieldcr2 = new JLabel("0");
			fieldcr3 = new JLabel("0");
			fieldcr4 = new JLabel("0");
			
			pmd0 = new JLabel("PMD");
			pmd1 = new JLabel("DCI");
			pmd2 = new JLabel("DII");
			pmd3 = new JLabel("ADCI");
			pmd4 = new JLabel("ADII");
			
			cr1 = new JLabel("---");
			cr2 = new JLabel("DCI");
			cr2 = new JLabel("DII");
			cr3 = new JLabel("ADCI");
			cr4 = new JLabel("ADII");
			
			label0p2.setForeground(Color.RED);
			label1p2.setForeground(Color.BLUE);
			label2p2.setForeground(Color.BLUE);
			label3p2.setForeground(Color.BLUE);
			label4p2.setForeground(Color.BLUE);
			
			pmd0.setForeground(Color.RED);
			pmd1.setForeground(Color.BLUE);
			pmd2.setForeground(Color.BLUE);
			pmd3.setForeground(Color.BLUE);
			pmd4.setForeground(Color.BLUE);
			
			cr1.setForeground(Color.RED);
			cr2.setForeground(Color.BLUE);
			cr2.setForeground(Color.BLUE);
			cr3.setForeground(Color.BLUE);
			cr4.setForeground(Color.BLUE);
			
			gbc.gridx = 1; gbc.gridy = 1; jPanel3.add(label0p2, gbc);
			gbc.gridx = 2; gbc.gridy = 1; jPanel3.add(label1p2, gbc);
			gbc.gridx = 4; gbc.gridy = 1; jPanel3.add(label2p2, gbc);
			gbc.gridx = 6; gbc.gridy = 1; jPanel3.add(label3p2, gbc);
			gbc.gridx = 3; gbc.gridy = 1; jPanel3.add(field1, gbc);
			gbc.gridx = 7; gbc.gridy = 1; jPanel3.add(field3, gbc);
			gbc.gridx = 5; gbc.gridy = 1; jPanel3.add(field2, gbc);
			gbc.gridx = 8; gbc.gridy = 1; jPanel3.add(label4p2, gbc);
			gbc.gridx = 9; gbc.gridy = 1; jPanel3.add(field4, gbc);
			gbc.gridx = 1; gbc.gridy = 2; jPanel3.add(pmd0, gbc);
			gbc.gridx = 2; gbc.gridy = 2; jPanel3.add(pmd1, gbc);
			gbc.gridx = 3; gbc.gridy = 2; jPanel3.add(fieldpmd1, gbc);
			gbc.gridx = 4; gbc.gridy = 2; jPanel3.add(pmd2, gbc);
			gbc.gridx = 5; gbc.gridy = 2; jPanel3.add(fieldpmd2, gbc);
			gbc.gridx = 6; gbc.gridy = 2; jPanel3.add(pmd3, gbc);
			gbc.gridx = 7; gbc.gridy = 2; jPanel3.add(fieldpmd3, gbc);
			gbc.gridx = 8; gbc.gridy = 2; jPanel3.add(pmd4, gbc);
			gbc.gridx = 9; gbc.gridy = 2; jPanel3.add(fieldpmd4, gbc);
			gbc.gridx = 1; gbc.gridy = 3; jPanel3.add(cr1, gbc); 
			gbc.gridx = 2; gbc.gridy = 3; jPanel3.add(cr2, gbc);
			gbc.gridx = 3; gbc.gridy = 3; jPanel3.add(fieldcr1, gbc);
			gbc.gridx = 4; gbc.gridy = 3; jPanel3.add(cr2, gbc);
			gbc.gridx = 5; gbc.gridy = 3; jPanel3.add(fieldcr2, gbc);
			gbc.gridx = 6; gbc.gridy = 3; jPanel3.add(cr3, gbc);
			gbc.gridx = 7; gbc.gridy = 3; jPanel3.add(fieldcr3, gbc);
			gbc.gridx = 8; gbc.gridy = 3; jPanel3.add(cr4, gbc);
			gbc.gridx = 9; gbc.gridy = 3; jPanel3.add(fieldcr4, gbc);
		}

		///////////
		//////////////////// TAB4------ CRIAR REGRA
		///////////

		JLabel regra = new JLabel("Regra");
		JLabel valor = new JLabel("Valores");
		JLabel jl1 = new JLabel("Nome da regra");
		JLabel jl2 = new JLabel("LOC_Max");
		JLabel jl3 = new JLabel("LOC_Min");
		JLabel jl4 = new JLabel("CYCLO_Max");
		JLabel jl5 = new JLabel("CYCLO_Min");
		JLabel jl6 = new JLabel("ATFD_Max");
		JLabel jl7 = new JLabel("ATFD_Min");
		JLabel jl8 = new JLabel("LAA_Max");
		JLabel jl9 = new JLabel("LAA_Min");
		
		JTextField jtf1 = new JTextField();
		JTextField jtf2 = new JTextField();
		JTextField jtf3 = new JTextField();
		JTextField jtf4 = new JTextField();
		JTextField jtf5 = new JTextField();
		JTextField jtf6 = new JTextField();
		JTextField jtf7 = new JTextField();
		JTextField jtf8 = new JTextField();
		JTextField jtf9 = new JTextField();
		
		JButton createRule = new JButton("Cria Regra");

		regra.setFont(new Font("Arial", Font.BOLD, 20));
		valor.setFont(new Font("Arial", Font.BOLD, 20));
		jtf1.setPreferredSize(new Dimension(80, 20));
		jtf2.setPreferredSize(new Dimension(80, 20));
		jtf3.setPreferredSize(new Dimension(80, 20));
		jtf4.setPreferredSize(new Dimension(80, 20));
		jtf5.setPreferredSize(new Dimension(80, 20));
		jtf6.setPreferredSize(new Dimension(80, 20));
		jtf7.setPreferredSize(new Dimension(80, 20));
		jtf8.setPreferredSize(new Dimension(80, 20));
		jtf9.setPreferredSize(new Dimension(80, 20));
		createRule.setEnabled(false);


		// list.add(jtf1);
		list.add(jtf2);
		list.add(jtf3);
		list.add(jtf4);
		list.add(jtf5);
		list.add(jtf6);
		list.add(jtf7);
		list.add(jtf8);
		list.add(jtf9);

		gbc.gridx = 0; gbc.gridy = 0; jPanel4.add(regra, gbc);
		gbc.gridx = 0; gbc.gridy = 1; jPanel4.add(jl1, gbc);
		gbc.gridx = 0; gbc.gridy = 2; jPanel4.add(jl2, gbc);
		gbc.gridx = 0; gbc.gridy = 3; jPanel4.add(jl3, gbc);
		gbc.gridx = 0; gbc.gridy = 4; jPanel4.add(jl4, gbc);
		gbc.gridx = 0; gbc.gridy = 5; jPanel4.add(jl5, gbc);
		gbc.gridx = 0; gbc.gridy = 6; jPanel4.add(jl6, gbc);
		gbc.gridx = 0; gbc.gridy = 7; jPanel4.add(jl7, gbc);
		gbc.gridx = 0; gbc.gridy = 8; jPanel4.add(jl8, gbc);
		gbc.gridx = 0; gbc.gridy = 9; jPanel4.add(jl9, gbc);
		gbc.gridx = 0; gbc.gridy = 9; jPanel4.add(jl9, gbc);
		gbc.gridx = 1; gbc.gridy = 0; jPanel4.add(valor, gbc);
		gbc.gridx = 1; gbc.gridy = 1; jPanel4.add(jtf1, gbc);
		gbc.gridx = 1; gbc.gridy = 2; jPanel4.add(jtf2, gbc);
		gbc.gridx = 1; gbc.gridy = 3; jPanel4.add(jtf3, gbc);
		gbc.gridx = 1; gbc.gridy = 4; jPanel4.add(jtf4, gbc);
		gbc.gridx = 1; gbc.gridy = 5; jPanel4.add(jtf5, gbc);
		gbc.gridx = 1; gbc.gridy = 6; jPanel4.add(jtf6, gbc);
		gbc.gridx = 1; gbc.gridy = 7; jPanel4.add(jtf7, gbc);
		gbc.gridx = 1; gbc.gridy = 8; jPanel4.add(jtf8, gbc);
		gbc.gridx = 1; gbc.gridy = 9; jPanel4.add(jtf9, gbc);
		gbc.gridx = 0; gbc.gridy = 10; jPanel4.add(createRule, gbc);
		gbc.gridx = 3; gbc.gridy = 11;
		jPanel4.add(new JScrollPane(rulesList), gbc);
		customRules = new ArrayList<CustomRule>();

		////////////////////// TAB5 -- VER REGRA

		ArrayList<CustomDataEntry> results = new ArrayList<CustomDataEntry>();
		TableModel model1 = new CustomDataEntryTableModel(results);
		JTable table1 = new JTable(model1);
		
		JLabel RegrasDisponiveis = new JLabel("Regras Disponíveis:");
		JLabel Resultados = new JLabel("Resultados:");
		JButton applyRule = new JButton("Aplicar Regra");

		RegrasDisponiveis.setFont(new Font("Arial", Font.BOLD, 20));
		Resultados.setFont(new Font("Arial", Font.BOLD, 20));
		applyRule.setEnabled(false);
		
		labelmedia1 = new JLabel();

		gbc.gridx = 0; gbc.gridy = 0; jPanel5.add(RegrasDisponiveis, gbc);
		gbc.gridx = 2; gbc.gridy = 0; jPanel5.add(Resultados, gbc);
	    gbc.gridx = 0; gbc.gridy = 1; jPanel5.add(new JScrollPane(rulesList), gbc);
		gbc.gridx = 1; gbc.gridy = 1; jPanel5.add(applyRule, gbc);
		gbc.gridx = 2; gbc.gridy = 1; jPanel5.add(new JScrollPane(table1), gbc);
		gbc.gridx = 1; gbc.gridy = 2; jPanel5.add(labelmedia1, gbc);

		jTabbedPane.addTab("Visualizar dados", jPanel1);
		jTabbedPane.addTab("Criar Threshold", jPanel2);
		jTabbedPane.addTab("Defeitos", jPanel3);
		jTabbedPane.addTab("Criar Regra", jPanel4);
		jTabbedPane.addTab("Ver Regra", jPanel5);

		frame.add(jTabbedPane);
		frame.pack();
		frame.setVisible(true);

		///////////
		///////////////////////// LISTENERS
		///////////

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser filechooser = new JFileChooser("Importar ficheiro");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel file", "xls", "xlsx");
				filechooser.setFileFilter(filter);
				int returnVal = filechooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					file = filechooser.getSelectedFile();
					System.out.println("Escolheu abrir o ficheiro: " + file.getName());

					File excel = new File(file.toString());

					BuildObjectsFromExcel bofe = new BuildObjectsFromExcel();

					try {
						bofe.buildObjects(excel);
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					}

					entries = bofe.objects();
					
					TableModel model = new DataEntryTableModel(entries);
					JTable table = new JTable(model);
					jScrollPane = new JScrollPane(table);

					gbc.gridx = 0; gbc.gridy = 0; jPanel1.add(jScrollPane, gbc);

					calculator = new DefectCalculator(entries);
					calculator.CalculateDefects();
					jPanel1.add(jScrollPane, gbc);

					modelDefect = new DetectedDefectTableModel(calculator.getDefects());
					JTable tableDefect = new JTable(modelDefect);

					jScrollPaneDefect = new JScrollPane(tableDefect);

					gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 11; gbc.fill = GridBagConstraints.HORIZONTAL; 
					jPanel3.add(jScrollPaneDefect, gbc);

					field1.setText(Integer.toString(calculator.getDciIPlasma()));
					field2.setText(Integer.toString(calculator.getDiiIPlasma()));
					field3.setText(Integer.toString(calculator.getAdciIPlasma()));
					field4.setText(Integer.toString(calculator.getAdiiIPlasma()));

					fieldpmd1.setText(Integer.toString(calculator.getDciPMD()));
					fieldpmd2.setText(Integer.toString(calculator.getDiiPMD()));
					fieldpmd3.setText(Integer.toString(calculator.getAdciPMD()));
					fieldpmd4.setText(Integer.toString(calculator.getAdiiPMD()));

					ExcelAccuracy test = new ExcelAccuracy(bofe);
					labelmedia.setText(
							"Percentagem média da accuracy do iPlasma e PMD: " + test.getAverageAccuracy() + "%");
					labelpercent
							.setText("Linhas 100% certas(iPlasma=PMD=isLongMethod): " + test.getEntryAccuracy() + "%");

					fileStatus.setText("FICHEIRO IMPORTADO COM SUCESSO!");
					fileStatus.setForeground(Color.GREEN);
					button2.setEnabled(true);
					createRule.setEnabled(true);
					frame.pack();
					SwingUtilities.updateComponentTreeUI(frame);
				}
			}
		});

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (file != null) {
					File excel = new File(file.toString());

					BuildObjectsFromExcel bofe = new BuildObjectsFromExcel();

					try {
						bofe.buildObjects(excel);
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					}
					boolean logicalOperator1;
					boolean logicalOperator2;
					int text1;
					int text2;
					int text3;
					float text4;
					try {
						if (c1.isSelected())
							text1 = Integer.parseInt(tField1.getText());
						else
							text1 = 0;
						if (c2.isSelected())
							text2 = Integer.parseInt(tField2.getText());
						else
							text2 = 0;
						if (c3.isSelected())
							text3 = Integer.parseInt(tField3.getText());
						else
							text3 = 0;
						if (c4.isSelected())
							text4 = Float.parseFloat(tField4.getText());
						else
							text4 = 0;
						if (operadorLM.equals("AND"))
							logicalOperator1 = true;
						else
							logicalOperator1 = false;
						if (operadorFE.equals("AND"))
							logicalOperator2 = true;
						else
							logicalOperator2 = false;
						Thresholds th = new Thresholds(bofe,tField5.getText(), c1.isSelected(), c2.isSelected(), c3.isSelected(),
								c4.isSelected(), logicalOperator1, logicalOperator2, text1, text2, text3, text4);
						th.calcThresholds();
						listThresholds.addElement(th);
						jPanel1.remove(jScrollPane);
						entries = th.getInputs();
						TableModel model = new DataEntryTableModel(entries);
						JTable table = new JTable(model);
						jScrollPane = new JScrollPane(table);
						
						gbc.gridx = 0; gbc.gridy = 0; jPanel1.add(jScrollPane, gbc);
						calculator = new DefectCalculator(entries);
						calculator.CalculateDefects();
						// TODO

						TableModel modelDefect = new DetectedDefectTableModel(calculator.getDefects());
						JTable tableDefect = new JTable(modelDefect);

						jPanel3.remove(jScrollPaneDefect);

						jScrollPaneDefect = new JScrollPane(tableDefect);

						gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 11; gbc.fill = GridBagConstraints.HORIZONTAL;
						jPanel3.add(jScrollPaneDefect, gbc);

						field1.setText(Integer.toString(calculator.getDciIPlasma()));
						field2.setText(Integer.toString(calculator.getDiiIPlasma()));
						field3.setText(Integer.toString(calculator.getAdciIPlasma()));
						field4.setText(Integer.toString(calculator.getAdiiIPlasma()));

						fieldpmd1.setText(Integer.toString(calculator.getDciPMD()));
						fieldpmd2.setText(Integer.toString(calculator.getDiiPMD()));
						fieldpmd3.setText(Integer.toString(calculator.getAdciPMD()));
						fieldpmd4.setText(Integer.toString(calculator.getAdiiPMD()));

						ExcelAccuracy test = new ExcelAccuracy(bofe);
						labelmedia.setText(
								"Percentagem média da accuracy do iPlasma e PMD: " + test.getAverageAccuracy() + "%");
						labelpercent.setText(
								"Linhas 100% certas(iPlasma=PMD=isLongMethod): " + test.getEntryAccuracy() + "%");

						frame.pack();
						SwingUtilities.updateComponentTreeUI(frame);
					} catch (NumberFormatException ez) {
						JOptionPane.showMessageDialog(frame, "Please type a number or uncheck the checkbox!", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});

		applyRule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CustomRule rule = rulesList.getSelectedValue();
				try {
					rule.applyCustomRule(entries);
					DefectCalculator c = new DefectCalculator(entries, rule);
					c.CalculateDefects();
					c.CalculateDefectsCustomRule();
					cr1.setText(rule.getName());
					fieldcr1.setText(Integer.toString(c.getDciCR()));
					fieldcr2.setText(Integer.toString(c.getDiiCR()));
					fieldcr3.setText(Integer.toString(c.getAdciCR()));
					fieldcr4.setText(Integer.toString(c.getAdiiCR()));
					int a = 0;
					for (CustomDataEntry cde : rule.getCustomRuleData()) {
						((DetectedDefectTableModel) modelDefect).setDefectAt(cde.Is_CustomRule(), a, 3);
						a++;
					}
					ExcelAccuracy test1 = new ExcelAccuracy(entries, rulesList.getSelectedValue().getCustomRuleData());
					customAccuracy = test1.getCustomAccuracy();
					labelmedia1.setText("Percentagem média da accuracy da regra selecionada: " + customAccuracy + "%");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				results.addAll(rule.getCustomRuleData());
				table1.revalidate();
				frame.pack();
			}
		});

		createRule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				  
				cr = new CustomRule(jtf1.getText(),jtf2.getText(),jtf3.getText(),
						            jtf4.getText(),jtf5.getText(),jtf6.getText(),
						            jtf7.getText(),jtf8.getText(),jtf9.getText());
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
				jtf5.setText("");
				jtf6.setText("");
				jtf7.setText("");
				jtf8.setText("");
				jtf9.setText("");
				listModel.addElement(cr);
				customRules.add(cr);
				applyRule.setEnabled(true);
				}
				
		});

		rulesList.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (renderer instanceof JLabel && value instanceof CustomRule) {
					// Here value will be of the Type 'CD'
					((JLabel) renderer).setText(((CustomRule) value).getName());
				}
				return renderer;
			}
		});

		for (JTextField x : list) {
			x.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char input = e.getKeyChar();
					if ((input < '0' || input > '9') && input != '\b') {
						e.consume();
						System.out.println("Invalid character!");
					}
				}
			});
		}

	}

	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.createandShowGUI();
	}

}
