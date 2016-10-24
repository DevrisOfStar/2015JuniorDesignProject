import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class SignUp extends JFrame{

	SignUp()
	{
		setTitle("Sign Up");
		setBounds(400, 20, 450, 360);
		setResizable(false);
		setLocation(300,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		placeSignUpPanel(panel);

		add(panel);
		setVisible(true);
	}

	public void placeSignUpPanel(JPanel panel)
	{
		// SQL Connect
		SQLConnection a = new SQLConnection();
		Connection con = a.makeConnection();

		
		panel.setLayout(null);

		JLabel labelid = new JLabel("���̵�");
		labelid.setBounds(20, 30, 100, 20);
		panel.add(labelid);

		JTextField Textid = new JTextField();
		Textid.setBounds(140, 30, 150, 20);
		panel.add(Textid);
		
		JButton ButtonId = new JButton("�ߺ�Ȯ��");
		ButtonId.setBounds(310, 30, 90, 20);
		panel.add(ButtonId);
		// �ߺ�Ȯ�� : SQL������ DB Table UID�� ���� Ž��
		ButtonId.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{

					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM USER WHERE UID ='" +Textid.getText() + "'");
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "���̵� �̹� �����մϴ�", "�ߺ�Ȯ��", JOptionPane.PLAIN_MESSAGE);
					}
					else JOptionPane.showMessageDialog(null, "�����ϴ� ���̵� �����ϴ�.", "�ߺ�Ȯ��", JOptionPane.PLAIN_MESSAGE);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		JLabel labelpwd = new JLabel("�н�����");
		labelpwd.setBounds(20, 70, 150, 20);
		panel.add(labelpwd);

		JPasswordField pw = new JPasswordField();
		pw.setBounds(140, 70, 150, 20);
		panel.add(pw);

		JLabel labelpwd2 = new JLabel("�н����� ��Ȯ��");
		labelpwd2.setBounds(20, 110, 100, 20);
		panel.add(labelpwd2);

		JPasswordField pw2 = new JPasswordField();
		pw2.setBounds(140, 110, 150, 20);
		panel.add(pw2);

		JLabel labelname = new JLabel("���� �̸�");
		labelname.setBounds(20, 150, 100, 20);
		panel.add(labelname);
		
		JTextField Textname = new JTextField();
		Textname.setBounds(140, 150, 150, 20);
		panel.add(Textname);
		
		JLabel labelname2 = new JLabel("���� ��ġ");
		labelname2.setBounds(20, 190, 100, 20);
		panel.add(labelname2);
		
		//region1
		Vector region1 = new Vector<>();
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT DISTINCT Region1 FROM region");
			while(rs.next()) {
					region1.add(rs.getString(1));
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		JComboBox Region1 = new JComboBox<>(region1);
		Region1.setBounds(140, 190, 90, 20);
		panel.add(Region1);
		
		// region2
		Vector region2 = new Vector<>();
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT DISTINCT Region2 FROM region");
			while(rs.next()) {
					region2.add(rs.getString(1));
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		JComboBox Region2 = new JComboBox<>(region2);
		Region2.setBounds(250, 190, 90, 20);
		panel.add(Region2);

		
		

		JLabel phone_id = new JLabel("��ȭ��ȣ");
		phone_id.setBounds(20, 230, 150, 20);
		panel.add(phone_id);
		Vector phone_v = new Vector<>();
		phone_v.add("010");
		phone_v.add("011");
		JComboBox phone = new JComboBox<>(phone_v);
		phone.setBounds(140, 230, 60, 20);
		panel.add(phone);

		JTextField phone_t = new JTextField();
		phone_t.setBounds(210, 230, 100, 20);
		panel.add(phone_t);

		JButton join = new JButton("�����ϱ�");
		join.setBounds(120, 270, 90, 40);
		panel.add(join);
		
		//Join Button ActionListener
		join.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//UID Textid, pw password Textname name region1 region1 region2 region2 phone + phone_t tel
				try{
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM USER WHERE UID ='" +Textid.getText() + "'");
					if(Textid.getText().equals("")||pw.getText().equals("")||pw2.getText().equals("")||Textname.getText().equals("")||phone_t.getText().equals("")) {
						// ����ִ� ������ ����
						JOptionPane.showMessageDialog(null, "����ִ� ������ �����մϴ�.", "ȸ������ ����", JOptionPane.PLAIN_MESSAGE);
					}
					else if (!pw.getText().equals(pw2.getText())) {
					// pw�� ��ġ�����ʽ��ϴ�.
						JOptionPane.showMessageDialog(null, "Password�� ��ġ�����ʽ��ϴ�.", "ȸ������ ����", JOptionPane.PLAIN_MESSAGE);
					}
					else if	(rs.next()) { // ID �ߺ�
						JOptionPane.showMessageDialog(null, "���̵� �̹� �����մϴ�", "ȸ������ ����", JOptionPane.PLAIN_MESSAGE);
					}
					else { // ȸ������ data�� DB�� user Table �� ����
					rs = stmt.executeQuery("select RegionCode From region where Region1 = '" + Region1.getSelectedItem().toString() + "' && ' Region 2 = '" + Region2.getSelectedItem().toString()+"'");
					rs.next();
					int RegionCode = rs.getInt(1);
					String sql = "insert into user values('" + Textid.getText() +"', '" + pw.getText() + "', 'Y','"+ RegionCode +"','" +Textname.getText() +"','" + phone.getSelectedItem().toString() + phone_t.getText()+"');";
					//String sql = "insert into user values('" + Textid.getText() +"', '" + pw.getText() + "', 'Y','"+Region1.getSelectedItem().toString() + "','"+Region2.getSelectedItem().toString() + "','" +Textname.getText() +"','" + phone.getSelectedItem().toString() + phone_t.getText()+"');";
					stmt.executeUpdate(sql); // select ���� ������ �������� �����Ҷ� ����ϴ� �޼ҵ�
					setVisible(false);
					dispose();
					JOptionPane.showMessageDialog(null, "ȸ������ �Ϸ��Ͽ����ϴ�. �α����Ͽ��ּ���.", "ȸ������ ����", JOptionPane.PLAIN_MESSAGE);
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
	
				}
				
				}
		});

		JButton cancel = new JButton("���");
		cancel.setBounds(230, 270, 90, 40);
		panel.add(cancel);

		//Cancel Button ActionListener
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				dispose();}
		});

	}
}
