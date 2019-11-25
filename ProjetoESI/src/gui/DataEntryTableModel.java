package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import code.DataEntry;

public class DataEntryTableModel extends AbstractTableModel  {
	  private List<DataEntry> entries ;
	  private String[] columns ; 

	  public DataEntryTableModel(List<DataEntry> dataEntryList){
	    super();
	    entries = dataEntryList ;
	    columns = new String[]{"ID","Package","Class", "Method", "LOC", "CYCLO", "ATFD", "LAA", "Long-Method", "IPlasma","PMD","Feature-Envy"};
	  }

	  // Number of column of your table
	  public int getColumnCount() {
	    return columns.length ;
	  }

	  // Number of row of your table
	  public int getRowCount() {
	    return entries.size();
	  }

	  // The object to render in a cell
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

	  // Optional, the name of your column
	  public String getColumnName(int col) {
	    return columns[col] ;
	  }

}
