package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI {

	private JFrame frame;
	private File file;

	// Modificar depois o titulo
	// Nao especifiquei o size porque ainda faltam acrescentar thresholds,
	// visualização de dados ,etc
	// Thresholds estão no código mas ainda não foram adicionados à frame,
	// Deixei comentado por agora, isto provavelmente vai ter que ser feito de outra forma e numa bar

	private void createAndShowGUI() {
		frame = new JFrame();
		frame.setTitle("Projeto ES1");
		frame.setPreferredSize(new Dimension(900, 900));
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JLabel dci = new JLabel("DCI");
		JLabel dii = new JLabel("DII");
		JLabel adci = new JLabel("ADCI");
		JLabel addi = new JLabel("ADII");
		JLabel thresholds = new JLabel("Thresholds");
//		JLabel loc = new JLabel("LOC");
//		JLabel cyclo = new JLabel("CYCLO");
//		JLabel atfd = new JLabel("ATFD");
//		JLabel laa = new JLabel("LAA");

		JTextField textField1 = new JTextField("");
		JTextField textField2 = new JTextField("");
		JTextField textField3 = new JTextField("");
		JTextField textField4 = new JTextField("");
		
		JPanel rowPanel1 = new JPanel();
		JPanel rowPanel2 = new JPanel();
		JPanel rowPanel3 = new JPanel();
		JPanel rowPanel4 = new JPanel();

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

		rowPanel4.add(dii);
		rowPanel4.add(textField4);
		
		

		frame.add(dci);
		frame.add(textField1);
		frame.add(rowPanel1);
		frame.add(dii);
		frame.add(textField2);
		frame.add(rowPanel2);
		frame.add(adci);
		frame.add(textField3);
		frame.add(rowPanel3);
		frame.add(addi);
		frame.add(textField4);
		frame.add(rowPanel2);
		frame.add(rowPanel3);
		frame.add(rowPanel4);
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
				}
			}
		});
		frame.add(button);
		frame.pack();
	}

	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.createAndShowGUI();
	}

}
