package gui;

import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import code.DetectedDefect;
/**
 * Represents the Model of the DefectTable and introduces some useful methods to manipulate it's data.
 */
public class DetectedDefectTableModel extends AbstractTableModel  {
	private List<DetectedDefect> entries ;
	private String[] columns ; 

	public DetectedDefectTableModel(List<DetectedDefect> detectedDefects){
		super();
		entries = detectedDefects ;
		columns = new String[]{"MethodID","IPlasma","PMD", "CustomRule"};
	}

	/**
	 * Getter of the number of columns of the DefectTable.
	 * @return int that represents the number of columns.
	 */
	public int getColumnCount() {
		return columns.length ;
	}
	/**
	 * Getter of the number of rows of the DefectTable.
	 * @return int that represents the number of rows.
	 */
	public int getRowCount() {
		return entries.size();
	}
	/**
	 * Getter of the value at a certain row and column.
	 * @return Object at a certain row and column.
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
	 * @return String that represents the name of a certain Column.
	 * @param int index of the column.
	 */
	public String getColumnName(int col) {
		return columns[col] ;
	}
	/**
	 * Setter of a value to a certain row and column of the DefectTable.
	 * @param Boolean value to be set at a certain row and columns of the DefectTable.
	 * @param int index of a row of the DefectTable.
	 * @param int index of a column of the DefectTable.
	 */
	public void setDefectAt(boolean Value, int row, int col) {
		DetectedDefect dd = entries.get(row);
		switch(col) {
		case 1: dd.setIplasma(Value);
		case 2: dd.setPmd(Value);
		case 3: dd.setCustomrule(Value);
		}
	}

}
