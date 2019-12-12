package gui;

import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import code.DetectedDefect;
/**
 * 
 * DetectedDefectTableModel displays a list of DetectedDefect in table format.
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
public class DetectedDefectTableModel extends AbstractTableModel  {
	/**
	 * Represents the attributes of the DetectedDefectTableModel class.
	 */
	private List<DetectedDefect> entries ;
	private String[] columns ; 
	/**
	 * Creates the DetectedDefectTableModel with the specific parameters.
	 * @param detectedDefects is a List of DetectedDefect.
	 */
	public DetectedDefectTableModel(List<DetectedDefect> detectedDefects){
		super();
		entries = detectedDefects ;
		columns = new String[]{"MethodID","IPlasma","PMD", "CustomRule"};
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
		DetectedDefect dd = entries.get(row);
		switch(col) {
		case 0: return dd.getId();
		case 1: return dd.isIplasma();
		case 2: return dd.isPmd();
		case 3: return dd.isCustomrule();
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
	/**
	 * Setter for the values at row and column given values position
	 * @param value is a boolean
	 * @param col is a Integer
	 * @param row is a Integer
	 */
	public void setDefectAt(boolean value, int row, int col) {
		DetectedDefect dd = entries.get(row);
		switch(col) {
		case 1: dd.setIplasma(value);
		case 2: dd.setPmd(value);
		case 3: dd.setCustomrule(value);
		}
	}

}
