import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class DataBoard extends JFrame {
	JTable table;
	JTextField namef;
	JTextField scoref;
	JButton button;
	
	MyTableModel model;
	
	public DataBoard(){
		super("��ϵ� ��ǰ");
		setSize(600, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		model = new MyTableModel();
		model.fillTable();
		JLabel label = new JLabel("��ϵ� ��ǰ", JLabel.CENTER);
		label.setFont(new Font("SansSerif", Font.PLAIN, 30));
		add(label, BorderLayout.NORTH);
		
		table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 200));
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("�̸�"));
		namef = new JTextField(10);
		panel.add(namef);
		
		panel.add(new JLabel("����"));
		scoref = new JTextField(10);
		panel.add(scoref);
		
		button = new JButton("�Է�");
		//button.addActionListener(this);
		panel.add(button);
		
		add(panel, BorderLayout.SOUTH);
		setLocation(300,300);
		setVisible(true);
	}//databoard
	
	public class MyTableModel extends AbstractTableModel{
		private String[] columnNames = {"�̸�", "����", "������", "�������"};
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
			//�����ͺ��̽��κ��� �迭�� ä���
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
