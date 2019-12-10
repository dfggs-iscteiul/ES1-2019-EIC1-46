package gui;

import java.util.ArrayList;
//import java.util.List;

import javax.swing.table.AbstractTableModel;

import code.CustomDataEntry;
import code.DataEntry;

public class CustomDataEntryTableModel extends AbstractTableModel  {
	private ArrayList<CustomDataEntry> entries ;
	private String[] columns ; 

	public CustomDataEntryTableModel(ArrayList<CustomDataEntry> CustomdataEntryList){
		super();
		entries = CustomdataEntryList ;
		columns = new String[]{"ID","Package","Class", "Method", "LOC", "CYCLO", "ATFD", "LAA", "NewRule"};
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
