import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class DataBoard extends JFrame {
	JTable table;
	JTextField namef;
	JTextField scoref;
	JButton button1,button2;
	int BranchCode;
	MyTableModel model;
	
	public DataBoard(int Code){
		super("등록된 물품");
		BranchCode = Code;
		setSize(600, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		model = new MyTableModel();
		JLabel label = new JLabel("등록된 물품", JLabel.CENTER);
		label.setFont(new Font("SansSerif", Font.PLAIN, 30));
		add(label, BorderLayout.NORTH);
		
		table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 200));
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		
		/*panel.add(new JLabel("이름"));
		namef = new JTextField(10);
		panel.add(namef);
		
		panel.add(new JLabel("가격"));
		scoref = new JTextField(10);
		panel.add(scoref);
		*/
		button1 = new JButton("등록");
		//button.addActionListener(this);
		panel.add(button1);
		
		button2 = new JButton("수정");
		panel.add(button2);
		button2.addActionListener(new ActionListener(){// 테이블에서 선택한 값 가져오기
			public void actionPerformed(ActionEvent e){
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				Object value = table.getValueAt(row, col);
				System.out.println(value);
			}
			});
		add(panel, BorderLayout.SOUTH);
		setLocation(300,300);
		setVisible(true);
		model.fillTable();
	}//databoard
	
	public class MyTableModel extends AbstractTableModel{
		private String[] columnNames = {"이름", "가격","재고", "제조일", "유통기한"};
		private static final int ROWS = 10;
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
			// SQL Connect
			SQLConnection a = new SQLConnection();
			Connection con = a.makeConnection();
			try{
				int i = 0; 
				int j = 0;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM branch_info WHERE BranchCode ='" +BranchCode+ "'");
				if(rs.next()) {
					do {
					setValueAt(rs.getString(3), i,0);
					setValueAt( rs.getString(7),i,1);
					setValueAt(rs.getString(4),i,2);
					setValueAt(rs.getString(5),i,3);
					setValueAt(rs.getString(6),i,4);
					i++;	j++;	
				} while(rs.next());
					
				
					for( i = 0;i<j;i++ ) {
						ResultSet rs2 = stmt.executeQuery("Select * FROM bread where breadCode = '" + getValueAt(i, 0)+"'");
						if(!rs2.next()) {setValueAt("종류없음",i,0);}
					else{setValueAt(rs2.getString(2),i,0);}
					}
					
				}
				else {JOptionPane.showMessageDialog(null, "존재하는 데이터가 없습니다.", "데이터 존재 에러", JOptionPane.PLAIN_MESSAGE);}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		

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
