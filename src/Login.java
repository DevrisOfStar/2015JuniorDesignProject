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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame
{
	JLabel labelid, labelpwd;
	JTextField Textid;
	JPasswordField Textpwd;
	JButton sign_in, cancel;
	
	Login()
	{
		setTitle("login");
		setSize(280, 150);
		setResizable(false);
		setLocation(300,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		placeLoginPanel(panel);
		
		add(panel);
		setVisible(true);
	}
	
	public void placeLoginPanel(JPanel panel)
	{
		panel.setLayout(null);
		labelid = new JLabel("User");
		labelid.setBounds(10,10,80,25);
		panel.add(labelid);
		
		labelpwd = new JLabel("Pwd");
		labelpwd.setBounds(10,40,80,25);
		panel.add(labelpwd);
		
		Textid = new JTextField(20);
		Textid.setBounds(100,10,160,25);
		panel.add(Textid);
		
		Textpwd = new JPasswordField(20);
		Textpwd.setBounds(100,40,160,25);
		panel.add(Textpwd);

		
		sign_in = new JButton("sign in");
		sign_in.setBounds(10,80,100,25);
		panel.add(sign_in);
		
		sign_in.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ //Textid �� Textpwd�� ������ DB�� ��
				// SQL Connect
				SQLConnection a = new SQLConnection();
				Connection con = a.makeConnection();
				try{

					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM USER WHERE UID ='" +Textid.getText() + "'");
					if(rs.next()) {
						
						if((rs.getString(2)).equals(Textpwd.getText())){ //pwd ��ġ
							setVisible(false);
							new Form1(Textid.getText(),rs.getInt(7));
							JOptionPane.showMessageDialog(null,"\""+ rs.getString(1) + "\"(" +rs.getString(4) +") �� ȯ���մϴ�.", "�α���", JOptionPane.PLAIN_MESSAGE);
						}
						else { //pwd ��ġ
							JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ���ϴ�", "�α��ν���", JOptionPane.PLAIN_MESSAGE);
						}
					}
					else JOptionPane.showMessageDialog(null, "�����ϴ� ���̵� �����ϴ�.", "�α��ν���", JOptionPane.PLAIN_MESSAGE);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			});
		
		cancel = new JButton("cancel");
		cancel.setBounds(160, 80, 100, 25);
		panel.add(cancel);

		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			//Textid �� Textpwd�� ������ DB�� ��
			setVisible(false);
			dispose();
			new Form1(null,0);}
			});

	}

}
