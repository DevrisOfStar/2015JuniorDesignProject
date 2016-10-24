import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class SearchResult extends JFrame{
	
	JTable table;
	JTextField namef;
	JTextField scoref;
	JButton button;
	
	MyTableModel model;
	
	public SearchResult(){
		super("등록된 물품");
		setSize(600, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		model = new MyTableModel();
		model.fillTable();
		JLabel label = new JLabel("가까운 빵집List", JLabel.CENTER);
		label.setFont(new Font("SansSerif", Font.PLAIN, 30));
		add(label, BorderLayout.NORTH);
		
		table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 200));
		add(scrollPane, BorderLayout.CENTER);
		
		
		setLocation(300,300);
		setVisible(true);
	}//databoard
	
	public class MyTableModel extends AbstractTableModel{
		private String[] columnNames = {"BRAND", "Location", "Distance", "Open/Close"};
		private static final int ROWS = 10;
		private static final int COLS = 4;
		Object[][] data = new String[ROWS][COLS];
		
		public int getColumnCount()
		{
			return columnNames.length;
		}
		
		public int getRowCount(){
			return data.length;
		}
		
		public String getColumnName(int col){
			return columnNames[col].toString();
		}
		
		public void fillTable()
		{
			//데이터베이스로부터 배열을 체운다
		}
		
		public void setValueAt(Object value, int row, int col){
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}
		
		public Object getValueAt(int row, int col){
			return data[row][col];
		}
	}
}
