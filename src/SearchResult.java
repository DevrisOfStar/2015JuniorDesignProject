import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		super("��ϵ� ��ǰ");
		setSize(600, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		model = new MyTableModel();
		model.fillTable();
		// Ŭ���� ���̸� ����
		String ConturyName = "���浿";
		JLabel label = new JLabel(""+ConturyName ,JLabel.LEFT);
		label.setFont(new Font("SansSerif", Font.PLAIN, 30));
		add(label, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("�ٽ� �˻��ϱ�"));
		namef = new JTextField(10);
		panel.add(namef);
		
		button = new JButton("�˻�");
		//button.addActionListener(this);
		panel.add(button);
		
		//�ӽ÷�
		button = new JButton("BranchInfo");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			//setVisible(true);
			new BranchInfo("paris");}
			});
		panel.add(button);
		
		add(panel, BorderLayout.SOUTH);
		
		table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 200));
		add(scrollPane, BorderLayout.CENTER);
		
		
		setLocation(300,300);
		setVisible(true);
	}//databoard
	
	public class MyTableModel extends AbstractTableModel{
		private String[] columnNames = {"BRAND", "Location", "Open/Close"};
		private static final int ROWS = 10;
		private static final int COLS = 3;
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
			//�����ͺ��̽��κ��� �迭�� ü���
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
