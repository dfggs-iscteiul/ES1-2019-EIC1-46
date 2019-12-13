package gui;

import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import code.DetectedDefect;
/**
 * Represents the Model of the DefectTable and introduces some useful methods to manipulate it's data.
=======
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
	 * Getter of the number of columns of the DefectTable.
	 * @return int that represents the number of columns.
	/**
	 * 
	 * @return the number of columns
	 */
	public int getColumnCount() {
		return columns.length ;
	}
	/**
	 * Getter of the number of rows of the DefectTable.
	 * @return int that represents the number of rows.
	 * 
	 * @return the number of rows
	 */
	public int getRowCount() {
		return entries.size();
	}
	/**
	 * Getter of the value at a certain row and column.
	 * @return Object at a certain row and column.
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
	 * Getter of the name of a certain column of the DefectTable.
	 * @param col is a Integer
	 * @return the column name of the given column value
	 */
	public String getColumnName(int col) {
		return columns[col] ;
	}
	/**
	 * Setter of a value to a certain row and column of the DefectTable.
	 * @param Boolean value to be set at a certain row and columns of the DefectTable.
	 * @param int index of a row of the DefectTable.
	 * @param int index of a column of the DefectTable.
	 *
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
