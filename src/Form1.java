import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;

public class Form1 extends JFrame{

	public static void main(String[] args) {
		
		new Form1(null,0);
		
	}
	
	String LoginId = null;
	
	public Form1(String LoginId, int Code){
		setLayout(null);
		setSize(580, 380);
		setLocation(200, 200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("빵집찾기 프로그램");
		
		JPanel panel = new JPanel();
		JLabel label1 = new JLabel("빵 이름");
		panel.add(label1);
		JTextField Text1 = new JTextField(10);
		panel.add(Text1);
		JLabel label3 = new JLabel("동 이름");
		panel.add(label3);
		JTextField Text2 = new JTextField(10);
		panel.add(Text2);
		JButton button1 = new JButton("검색");
		panel.add(button1);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			//setVisible(true);
			}
			});
		
		panel.setBounds(20, 20, 400, 40);
		add(panel);
		
		JPanel panel2 = new JPanel();
		//String LoginStack 로그인하면 로그인정보 가져오기
		if(LoginId != null) { // Login 후 상태
		JLabel label2 = new JLabel(LoginId + "님 반갑습니다.");
		panel2.add(label2);
		}
		else { // Login 전 상태
			JLabel label2 = new JLabel("User 님 반갑습니다.");
			panel2.add(label2);
		}
		panel2.setBounds(390, 25, 200, 30);
		add(panel2);
		
		if(LoginId == null) { // Login 전 상태
		JPanel panel3 = new JPanel();
		JButton button2 = new JButton("     회원가입     ");
		panel3.add(button2);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			new SignUp();}
			});
		JButton button3 = new JButton("판매자 로그인");
		panel3.add(button3);
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			dispose(); // 로그인 버튼 누를 시 사라짐
			new Login();}
			});
		panel3.setBounds(300, 280,250, 100);
		add(panel3);
		}
		else { // Login 후 상태
			JPanel panel3 = new JPanel();
			JButton button2 = new JButton(" 빵집 관리 ");
			panel3.add(button2);
			button2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					new DataBoard(Code); // DB 설정을 위해 생성자를 통해 parameter를 전달
				}
				});
			JButton button3 = new JButton(" 개인정보수정 ");
			panel3.add(button3);
			button3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("개인정보수정");
					}
				});
			panel3.setBounds(300, 280,250, 100);
			add(panel3);
		}
		
		MyTableModel model;
		model = new MyTableModel();
		model.fillTable();
		JTable table = new JTable(model);
				
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 200));
		scrollPane.setBounds(20,65, 500, 200);
		add(scrollPane);
		
		
		JPanel panel4 = new JPanel();
		Border border = BorderFactory.createTitledBorder("선택사항");
		JScrollPane scroll = new JScrollPane();
		String[] test = {"test","test","test","test","test"};
		JList<String> itemList = new JList<>(test);
		itemList.setSelectedIndex(0);
		//스크롤 셋팅
        scroll.setViewportView(itemList);
        scroll.setBorder(border); //경계 설정
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //가로바정책
        //list 셋팅
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemList.setListData(test); //리스트의 데이터가 될 목록 설정
        //itemList.addListSelectionListener(this); //이벤트리스너 장착
        //프레임에 컴포넌트 장착
        //panel4.add(label, BorderLayout.NORTH);
		scroll.setBounds(50, 300, 300, 300);
		panel4.add(scroll);
		panel4.setBackground(Color.red);
		add(panel4);
		
		
		JButton button5 = new JButton("인접 지역");
		button5.setBounds(20,285, 150, 30);
		add(button5);
		button5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			dispose();
			new Login();}
			});
		
		setVisible(true);
	}
	public class MyTableModel extends AbstractTableModel{
		private String[] columnNames = {"BRAND", "Location", "Open/Close", "들어가기"};
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
			//데이터베이스로부터 배열을 채운다
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