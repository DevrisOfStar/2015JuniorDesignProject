import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class BranchInfo extends JFrame{
	JTable table;
	JTextField namef;
	JTextField scoref;
	JButton button;
	
	MyTableModel model;
	
	//지점 이름을 입력받음
	public BranchInfo(String BranchName){
		super(BranchName);
		setSize(600, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		model = new MyTableModel();
		model.fillTable();
		// 클릭한 동이름 전달
		String ConturyName = BranchName;
		JLabel label = new JLabel(""+ConturyName ,JLabel.LEFT);
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
		private String[] columnNames = {"빵종류", "제조시간", "유통기한", "개수", "구매하기"};
		private static final int ROWS = 20;
		private static final int COLS = 5;
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
