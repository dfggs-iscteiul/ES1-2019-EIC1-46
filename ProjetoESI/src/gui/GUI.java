package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUI {

	private JFrame frame;

	//Modificar depois o titulo
	//Nao especifiquei o size porque ainda faltam acrescentar thresholds, visualização de dados ,etc

	private void createAndShowGUI() {
		frame = new JFrame();
		frame.setTitle("Projeto ES1");
		frame.setSize(900, 900);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

		JLabel dci = new JLabel("DCI");
		frame.add(dci);
		JTextField textField1 = new JTextField("");
		textField1.setPreferredSize(new Dimension(80, 20));
		textField1.setEditable(false);
		frame.add(textField1);
		JPanel rowPanel1 = new JPanel();
		rowPanel1.add( dci );
		rowPanel1.add( textField1 );
		frame.add( rowPanel1 );
		JLabel dii = new JLabel("DII");
		frame.add(dii);
		JTextField textField2 = new JTextField("");
		textField2.setPreferredSize(new Dimension(80, 20));
		textField2.setEditable(false);
		frame.add(textField2);
		JPanel rowPanel2 = new JPanel();
		rowPanel2.add( dii );
		rowPanel2.add( textField2 );
		frame.add( rowPanel2 );
		JLabel adci = new JLabel("ADCI");
		frame.add(adci);
		JTextField textField3 = new JTextField("");
		textField3.setPreferredSize(new Dimension(80, 20));
		textField3.setEditable(false);
		frame.add(textField3);
		JPanel rowPanel3 = new JPanel();
		rowPanel3.add( adci );
		rowPanel3.add( textField3 );
		frame.add( rowPanel3 );
		JLabel addi = new JLabel("ADII");
		frame.add(addi);
		JTextField textField4 = new JTextField("");
		textField4.setPreferredSize(new Dimension(80, 20));
		textField4.setEditable(false);
		frame.add(textField4);
		JPanel rowPanel4 = new JPanel();
		rowPanel4.add( dii );
		rowPanel4.add( textField4 );
		frame.add( rowPanel2 );
		frame.add( rowPanel3 );
		frame.add( rowPanel4 );
		frame.pack();
	}


	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.createAndShowGUI();
	}

}
