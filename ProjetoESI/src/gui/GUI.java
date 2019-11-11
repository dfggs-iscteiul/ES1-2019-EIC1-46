package gui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import code.BuildObjectsFromExcel;

/**
 * Represents the Interface of the program.
 *
 */
public class GUI {

	private JFrame frame;
	private File file;

	// Modificar depois o titulo

	/**
	 * Builds the structure of the interface and adds button listeners.
	 */
	public void createAndShowGUI() {
		frame = new JFrame();
		frame.setTitle("Projeto ES1");
		frame.setPreferredSize(new Dimension(900, 900));
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JLabel
			dci = new JLabel("DCI"),
			dii = new JLabel("DII"),
			adci = new JLabel("ADCI"),
			addi = new JLabel("ADII");

		JTextField
			textField1 = new JTextField(""),
			textField2 = new JTextField(""),
			textField3 = new JTextField(""),
			textField4 = new JTextField("");
		
		JPanel
			rowPanel1 = new JPanel(),
			rowPanel2 = new JPanel(),
			rowPanel3 = new JPanel(),
			rowPanel4 = new JPanel(),
			controlPanel = new JPanel();

		textField1.setPreferredSize(new Dimension(80, 20));
		textField2.setPreferredSize(new Dimension(80, 20));
		textField3.setPreferredSize(new Dimension(80, 20));
		textField4.setPreferredSize(new Dimension(80, 20));

		textField4.setEditable(false);
		textField1.setEditable(false);
		textField2.setEditable(false);
		textField3.setEditable(false);

		rowPanel1.add(dci);
		rowPanel1.add(textField1);

		rowPanel2.add(dii);
		rowPanel2.add(textField2);

		rowPanel3.add(adci);
		rowPanel3.add(textField3);

		rowPanel4.add(addi);
		rowPanel4.add(textField4);
		
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
						
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
	
					File excel = new File(file.toString()); 
					try {
						Desktop.getDesktop().open(excel);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
        controlPanel.add(rowPanel1);
        controlPanel.add(rowPanel2);
        controlPanel.add(rowPanel3);
        controlPanel.add(rowPanel4);
        controlPanel.add(button);
		
		JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Definir Thresholds");
        mb.add(m1);
        JMenuItem m11 = new JMenuItem("LOC");
        JMenuItem m22 = new JMenuItem("CYCLO");
        m1.add(m11);
        m1.add(m22);
		
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER,controlPanel);	
		frame.pack();
	}
}
