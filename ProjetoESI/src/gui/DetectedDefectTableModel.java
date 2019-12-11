package gui;

import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import code.DetectedDefect;

public class DetectedDefectTableModel extends AbstractTableModel  {
	private List<DetectedDefect> entries ;
	private String[] columns ; 

	public DetectedDefectTableModel(List<DetectedDefect> detectedDefects){
		super();
		entries = detectedDefects ;
		columns = new String[]{"MethodID","IPlasma","PMD", "CustomRule"};
	}

	public int getColumnCount() {
		return columns.length ;
	}

	public int getRowCount() {
		return entries.size();
	}

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

	public String getColumnName(int col) {
		return columns[col] ;
	}

}
