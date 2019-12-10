package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import code.CustomDataEntry;

public class CustomDataEntryTableModel extends AbstractTableModel {
	private List<CustomDataEntry> entries ;
	private String[] columns ; 

	public CustomDataEntryTableModel(List<CustomDataEntry> dataEntryList){
		super();
		entries = dataEntryList ;
		columns = new String[]{"ID","Package","Class", "Method", "LOC", "CYCLO", "ATFD", "LAA", "Custom Rule"};
	}

	public int getColumnCount() {
		return columns.length ;
	}

	public int getRowCount() {
		return entries.size();
	}

	public Object getValueAt(int row, int col) {
		CustomDataEntry de = entries.get(row);
		switch(col) {
		case 0: return de.getEntryMethodId();
		case 1: return de.getEntryPackage();
		case 2: return de.getEntryClass();
		case 3: return de.getEntryMethod();
		case 4: return de.getEntryLOC();
		case 5: return de.getEntryCYCLO();
		case 6: return de.getEntryATFD();
		case 7: return de.getEntryLAA();
		case 8: return de.Is_CustomRule();
		default: return null;
		}
	}

	public String getColumnName(int col) {
		return columns[col] ;
	}

}
