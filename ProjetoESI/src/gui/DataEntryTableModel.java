package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import code.DataEntry;

/**
 * 
 * DataEntryTableModel displays an arraylist of DataEntry in table format.
 * 
 * 
 * Date: Dec 05-2019
 * 
 * @author Filipe Cruz
 * @version 1.0
 * 
 * 
 *
 */
public class DataEntryTableModel extends AbstractTableModel  {
	/**
	 * Represents the attributes of the DataEntryTableModel class.
	 */
	private ArrayList<DataEntry> entries ;
	private String[] columns ; 
	/**
	 * Creates the DataEntryTableModel with the specific parameters.
	 * @param dataEntryList is an ArrayList of DataEntry.
	 */
	public DataEntryTableModel(ArrayList<DataEntry> dataEntryList){
		super();
		entries = dataEntryList ;
		columns = new String[]{"ID","Package","Class", "Method", "LOC", "CYCLO", "ATFD", "LAA", "Long-Method", "IPlasma","PMD","Feature-Envy"};
	}
	/**
	 * 
	 * @return the number of columns
	 */
	public int getColumnCount() {
		return columns.length ;
	}
	/**
	 * 
	 * @return the number of rows
	 */
	public int getRowCount() {
		return entries.size();
	}
	/**
	 * @param row is a Integer
	 * @param col is a Integer
	 * @return the object at the position of the row and column values given
	 */
	public Object getValueAt(int row, int col) {
		DataEntry de = entries.get(row);
		switch(col) {
		case 0: return de.getEntryMethodId();
		case 1: return de.getEntryPackage();
		case 2: return de.getEntryClass();
		case 3: return de.getEntryMethod();
		case 4: return de.getEntryLOC();
		case 5: return de.getEntryCYCLO();
		case 6: return de.getEntryATFD();
		case 7: return de.getEntryLAA();
		case 8: return de.Is_Long_Method();
		case 9: return de.IPlasma();
		case 10: return de.PMD();
		case 11: return de.Is_Feature_Envy();
		default: return null;
		}
	}
	/**
	 * @param col is a Integer
	 * @return the column name of the given column value
	 */
	public String getColumnName(int col) {
		return columns[col] ;
	}

}
